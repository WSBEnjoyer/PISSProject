package com.project.logging.service;

import com.project.logging.model.LogMessage;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LoggingService {
    private final String LOG_FILE_PATH = "D:\\tmp\\logging-service-log.txt";
    private final DateTimeFormatter logDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LoggingService() {
        createFileIfItDoesNotExist();
    }

    public void log(LogMessage logMessage) {
        System.out.println("Log message received:");
        System.out.println(logMessage.getMessage());

        writeMessageToFile(logMessage.getMessage());
    }

    private void createFileIfItDoesNotExist() {
        File logFile = new File(LOG_FILE_PATH);

        try {
            logFile.createNewFile();
        } catch (IOException e) {
            System.err.println("Error while trying to create log file");
            throw new RuntimeException(e);
        }
    }

    private void writeMessageToFile(String message) {
        if (message == null) {
            return;
        }

        try (FileWriter logFileWriter = new FileWriter(LOG_FILE_PATH, true);
             PrintWriter logFilePrintWriter = new PrintWriter(logFileWriter)) {
            logFilePrintWriter.printf("[%s] %s\n", getCurrentDateTime(), message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getCurrentDateTime() {
        return logDateTimeFormatter.format(LocalDateTime.now());
    }
}
