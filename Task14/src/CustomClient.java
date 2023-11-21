package Task14.src;

import java.io.*;
import java.net.Socket;

public class CustomClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 8081);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter out = new PrintWriter(outputStream, true);

            String serverMessage = in.readLine();
            System.out.println(serverMessage);
            System.out.println("Enter your answer : ");
            String answer = consoleReader.readLine();
            out.println(answer);

            String serverQuestion = in.readLine();
            System.out.println(serverQuestion);
            System.out.println("Enter your answer : ");
            String answerQuestion = consoleReader.readLine();
            out.println(answerQuestion);

            String response = in.readLine();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
