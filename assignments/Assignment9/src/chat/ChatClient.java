package chat;

import java.awt.BorderLayout;
import java.io.*;
import java.net.*;
import java.security.Key;
import java.security.PublicKey;
import java.util.Base64;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import encryption.Encryption;

public class ChatClient extends JFrame {

    private static final int PORT = 9898;
	private static final String SERVER_PUBLIC_KEY = "MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgGk9wUQ4G9PChyL5SUkCyuHjTNOglEy5h4KEi0xpgjxi/UbIH27NXLXOr94JP1N5pa1BbaVSxlvpuCDF0jF9jlZw5IbBg1OW2R1zUACK+NrUIAYHWtagG7KB/YcyNXHOZ6Icv2lXXd7MbIao3ShrUVXo3u+5BJFCEibd8a/JD/KpAgMBAAE=";

    private Socket clientSocket;
    private PublicKey serverPublicKey;
    private Key aesKey;

    private JTextArea jTextArea;
    private JTextField jTextField;

    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ChatClient() {
        super("Chat Client");
        prepareClientUI();
        readServerPublicKey();
    }

    private void readServerPublicKey() {
        try{
            // BufferedReader reader = new BufferedReader(new FileReader("keypairs/id_rsa.pub"));
            // serverPublicKey = reader.readLine();
            // reader.close();
            serverPublicKey = Encryption.readPublicKey(SERVER_PUBLIC_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error message: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error getting server public key: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            // throw new RuntimeException("Error reading server public key");
        }
    }

    private void prepareClientUI() {

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Client Options");
        
        JMenuItem jMenuItemConnect = new JMenuItem("Connect To Server");
        jMenuItemConnect.addActionListener(e -> initiateServerConnection());
        jMenu.add(jMenuItemConnect);

        JMenuItem jMenuItemExit = new JMenuItem("Exit");
        jMenuItemExit.addActionListener(e -> {
            endServerConnection();
            System.exit(0);
        });
        jMenu.add(jMenuItemExit);

        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);

        jTextArea = new JTextArea(20, 40);
        jTextArea.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jTextField = new JTextField(40);
        jTextField.addActionListener(e -> {
            sendMessage();
            jTextField.setText("");
        });

        setLayout(new BorderLayout());
        add(jScrollPane, BorderLayout.CENTER);
        add(jTextField, BorderLayout.SOUTH);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void sendMessage() {
        try {
            String encryptedMessage = Encryption.encrypt(aesKey, jTextField.getText());
            dataOutputStream.writeUTF(encryptedMessage);
            jTextArea.append("");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error message: " + e.getMessage());
            throw new RuntimeException("Error sending message to server");
        }
    }

    private Object initiateServerConnection() {
        try {
            clientSocket = new Socket("localhost", PORT);
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            jTextArea.append("Client connected to server\n");

            dataOutputStream.writeUTF("HELLO");            
            String response = dataInputStream.readUTF();
            if (response.equals("CONNECTED")) {
                jTextArea.append("Client is connected to the server\n");
                byte[] seed = Encryption.generateSeed();
                byte[] encryptedSeed = Encryption.pkEncrypt(serverPublicKey, seed);
                dataOutputStream.writeUTF(Base64.getEncoder().encodeToString(encryptedSeed));
                aesKey = Encryption.generateAESKey(seed);

                listenerForServerMessages();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error message: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error connecting to the server" + e.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Error connecting to server" + e.getMessage());
        }
        return null;
    }

    private void listenerForServerMessages() {
        new Thread(() -> {
            try {
                while(true){
                    String encryptedMessage = dataInputStream.readUTF();
                    String message = Encryption.decrypt(aesKey, encryptedMessage);
                    jTextArea.append("Client " + message + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error reading message from the server. Error message: " + e.getMessage());
                endServerConnection();
                // throw new RuntimeException("Error reading message from server");
            }
        }).start();
    }

    private void endServerConnection() {
        try {
            if (dataInputStream != null) dataInputStream.close();
            if (dataOutputStream != null) dataOutputStream.close();
            if (clientSocket != null) clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error message: " + e.getMessage());
            throw new RuntimeException("Error closing connection to server");
        }
    }

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(ChatClient::new);
        // ChatClient chatClient = new ChatClient();

    }
}