package Task14.src;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class CustomServer {
    private ServerSocket serverSocket;

    public CustomServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            System.out.println("Server is listening on port" + serverSocket.getLocalPort() + "...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client successfully connected");

            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            out.println("Server: hello");
            String message = in.readLine();
            System.out.println("Client : " + message);

            if (containsRestrictedRussianLetters(message)) {
                out.println("Server : що таке паляниця?");

                String answer = in.readLine();

                if (answer.contains("хліб")) {
                    out.println("Server : " + LocalDateTime.now());
                    out.println("Server : bye!");
                } else {
                    out.println("Server : геть з України москаль некрасівий!");
                    out.println("Disconnecting client");
                    clientSocket.close();
                }
            } else {
                out.println("Server : Слава Україні! Героям Слава!");
                out.println("Server : bye!");
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean containsRestrictedRussianLetters(String str) {
        return str.matches(".*[эЭъЪёЁыЫ].*");
    }

    public void close() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
