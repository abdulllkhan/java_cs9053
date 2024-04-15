package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.security.PrivateKey;
import java.util.Base64;

import javax.swing.JTextArea;
import javax.xml.crypto.Data;

import encryption.Encryption;

public class ClientHandler extends Thread{

    JTextArea jTextArea = new JTextArea();
    private int clientNumber;
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private PrivateKey privateKey;

    // public ClientHandler(Socket socket, int clientCount, JTextArea jTextArea, PrivateKey privateKey) {
    //     this.socket = socket;
    //     this.clientNumber = clientCount;
    //     this.privateKey = privateKey;
    //     this.jTextArea = jTextArea;
    //     try{
    //         dataInputStream = new DataInputStream(socket.getInputStream());
    //         dataOutputStream = new DataOutputStream(socket.getOutputStream());
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         jTextArea.append("Error message while setting up input/output stream: " + e.getMessage());
    //     }

    // }

    // public void run(){

    //     jTextArea.append("Client " + clientNumber + " connected at " 
    //             + socket.getInetAddress() + " on port " + socket.getPort() + '\n');
    //     jTextArea.append("Client name is " + socket.getInetAddress().getHostName() + '\n');

    //     try{
    //         String hello = dataInputStream.readUTF();
    //         if(hello.equals("Hello")){
    //             dataOutputStream.writeUTF("CONNECTED");
    //             byte[] encryptedSeed = Base64.getDecoder().decode(dataInputStream.readUTF());
    //             // byte[] encryptedMessage = Base64.getDecoder().decode(dataInputStream.readUTF());
    //             byte[] seed = Encryption.pkDecrypt(privateKey, encryptedSeed);
    //             aesKey = Encryption.generateAESKey(seed);
    //         }
    //     }

    // }

}
