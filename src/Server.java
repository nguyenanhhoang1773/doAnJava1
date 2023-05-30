import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private ArrayList<Socket> clients;
    private ServerSocket serverSocket;
    private DB database;
    private List<Room> Rooms;
    private List<String> user = new ArrayList<>(); 
    public Server() {
    	database = new DB();
    	database.ConnectDB();
        clients = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("Server started. Waiting for clients...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);
                clients.add(clientSocket);
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader reader;
        private PrintWriter writer;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String userName = null;
            String password = null;
            int a = 0; 
            int b = 1;
            List<String> lines = new ArrayList<>(); // Lưu trữ các dòng văn bản đã đọc được
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    lines.add(line); 
                    if( line.equals("user")) {
                    Boolean verify = database.verifyUser(lines.get(a), lines.get(b));
                   
                    System.out.println(verify);
                    System.out.println(lines.get(a));
                    System.out.println(lines.get(b));
                    if( verify) {
                    	System.out.print("lum tien");
                    	writer.println("valid");
                    }
                    a += 3;
                    b += 3;
                    }
                    
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clients.remove(clientSocket);
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//        private void broadcastMessage(String message) {
//            for (Socket client : clients) {
//                try {
//                    PrintWriter clientWriter = new PrintWriter(client.getOutputStream(), true);
//                    clientWriter.println(message);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
