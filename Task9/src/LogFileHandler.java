package Task9.src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFileHandler {
    private String path;

    public LogFileHandler(String path) {
        this.path = path;
    }

    public void createLogFileIfNotExists() {
        File logFile = new File(path);
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeLogMessage(String level, String message) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.write(level + " : " + message);
            bufferedWriter.newLine();
            System.out.println("A log message has been recorded : " + level + " : " + message);
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    public List<String> readLogMessage() {
        List<String> messages = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                messages.add(line);
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return messages;
    }

    public void printLogMessagesByLevel(String level) {
        List<String> messages = readLogMessage();
        System.out.println("Level log message : " + level + " : ");
        for (String logMessage : messages) {
            if (logMessage.startsWith(level + " : ")) {
                System.out.println(logMessage);
            }
        }
    }


}
