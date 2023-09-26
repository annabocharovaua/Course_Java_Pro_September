package Task9.src;

import Task8.src.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String logPath = "log.log";
        LogFileHandler logFileHandler = new LogFileHandler(logPath);

        logFileHandler.createLogFileIfNotExists();

        logFileHandler.writeLogMessage("INFO", "Starting JuniorCrudServiceApplication using Java 17.0.7");
        logFileHandler.writeLogMessage("DEBUG", "User admin created");
        logFileHandler.writeLogMessage("INFO", "Application started.");
        logFileHandler.writeLogMessage("DEBUG", "User login successful.");
        logFileHandler.writeLogMessage("DEBUG", "Database connection established.");
        logFileHandler.writeLogMessage("INFO", "Data processing started.");


        List<String> logMessages = logFileHandler.readLogMessage();
        for (String logMessage : logMessages) {
            System.out.println(logMessage);
        }

        // Виведення лог-повідомлень з певним рівнем (лог-левел) - INFO або DEBUG
        logFileHandler.printLogMessagesByLevel("INFO");
    }

}
