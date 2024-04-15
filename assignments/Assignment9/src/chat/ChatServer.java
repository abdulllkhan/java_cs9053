package chat;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;

import encryption.Encryption;

import java.security.*;

public class ChatServer extends JFrame {

    private JTextArea jTextArea = new JTextArea();

	private static final String RSA = "RSA";
	private PrivateKey privateKey;

    private static int clientCount = 0;
    private ArrayList<ClientHandler> clients = new ArrayList<>();
	
	public ChatServer() {
	
		super("Chat Server");
        prepareServerUI();
        readPrivateKey();
        startServer();

	}
		
	private void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(9898); // if this doesn't work, try initializing ServerSocket outside the constructor
            jTextArea.append("Server started at port 9898 at " + new Date() + '\n');
            while(true){
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // jTextAreaAppend("Error message: " + e.getMessage());
            jTextArea.append("Error message: " + e.getMessage() + '\n');
        }
    }

    protected void jTextAreaAppend(String text) {
        SwingUtilities.invokeLater(() -> jTextArea.append(text));
    }

    private void readPrivateKey() {
        try {
            // byte[] keyBytes = Encryption.readPublicKey("keypairs/pkcs8_key");
            // PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            // KeyFactory kf = KeyFactory.getInstance(RSA);
            // privateKey = kf.generatePrivate(spec);
            privateKey = Encryption.readPrivateKey("keypairs/pkcs8_key");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error message: " + e.getMessage());
            System.exit(1);
        }
    }

    private void prepareServerUI() {

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Client Options");

        JMenuItem jMenuItemExit = new JMenuItem("Stop Server");
        jMenuItemExit.addActionListener(e -> {
            System.exit(0);
        });
        jMenu.add(jMenuItemExit);

        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);

        setLayout(new BorderLayout());
        add(new JScrollPane(jTextArea), BorderLayout.CENTER);   
        setTitle("Chat Server");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }



    public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
	}

    public class ClientHandler extends Thread{

        // JTextArea jTextArea = new JTextArea();
        private int clientNumber;
        private Socket socket;
        private DataInputStream dataInputStream;
        private DataOutputStream dataOutputStream;
        // private PrivateKey privateKey;
        private Key aesKey;
    
        public ClientHandler(Socket socket) {
            this.socket = socket;
            this.clientNumber = ++clientCount;
            try{
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
                jTextArea.append("Error message while setting up input/output stream: " + e.getMessage());
            }
    
        }
    
        public void run(){
    
            jTextArea.append("Client " + clientNumber + " connected at " 
                    + socket.getInetAddress() + " on port " + socket.getPort() + '\n');
            jTextArea.append("Client name is " + socket.getInetAddress().getHostName() + '\n');
    
            try{
                String hello = dataInputStream.readUTF();
                if(hello.equals("HELLO")){
                    dataOutputStream.writeUTF("CONNECTED");
                    byte[] encryptedSeed = Base64.getDecoder().decode(dataInputStream.readUTF());
                    // byte[] encryptedMessage = Base64.getDecoder().decode(dataInputStream.readUTF());
                    byte[] seed = Encryption.pkDecrypt(privateKey, encryptedSeed);
                    aesKey = Encryption.generateAESKey(seed);

                    while(true){
                        String encryptedMessage = dataInputStream.readUTF();
                        String message = Encryption.decrypt(aesKey, encryptedMessage);
                        broadcastMessage(this, message);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                jTextArea.append("Error message while reading message: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    jTextArea.append("Error message while closing socket: " + e.getMessage());
                }
            }
    
        }

        private void broadcastMessage(ClientHandler clientHandler, String message) throws InvalidAlgorithmParameterException {
            for(ClientHandler client : clients){
                try {
                    if(client != clientHandler){
                        message = String.valueOf(clientHandler.clientNumber) + ": " + message;
                        String encryptedMessage = Encryption.encrypt(client.aesKey, message);
                        client.dataOutputStream.writeUTF(encryptedMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    jTextArea.append("Error message while broadcasting message: " + e.getMessage());
                }
            }
        }
    
    }
	
	
}




