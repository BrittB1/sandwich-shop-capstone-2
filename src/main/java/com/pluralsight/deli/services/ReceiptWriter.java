package com.pluralsight.deli.services;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public String generateFileName() {

        LocalDateTime currentTime = LocalDateTime.now();
        String pattern = "yyyy-MM-dd-HH:mm:ss";

        DateTimeFormatter f = DateTimeFormatter.ofPattern(pattern);

        String formattedDate = currentTime.format(f);

        String fileName = formattedDate + ".txt";

        return fileName;
    }

    private void ensureReceiptsFolderExists() {
        File folder = new File("receipts");

        if (!folder.mkdirs()) {
            folder.mkdirs();

        }
    }
}