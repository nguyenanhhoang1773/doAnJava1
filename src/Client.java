import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class Client extends JFrame {

    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;

//    public Client() {
//    	EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LogIn frame = new LogIn();
//					frame.setVisible(true);
//				} catch (Exception e) {
//				}
//			}
//		});
//            try {
//                clientSocket = new Socket("localhost", 8888);
//                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                writer = new PrintWriter(clientSocket.getOutputStream(), true);
//                System.out.println("Connected to server.");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        private void sendMessage() {
//            String message = messageTextField.getText();
//            if (!message.isEmpty()) {
//                writer.println(message);
//                messageTextField.setText("");
//            }
//        }

//        private class MessageReceiver implements Runnable {
//            @Override
//            public void run() {
//                String message;
//                try {
//                    while ((message = reader.readLine()) != null) {
//                        chatTextArea.append(message + "\n");
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

//        public static void main(String[] args) {
//        	new Client();
//        	
//        }
}