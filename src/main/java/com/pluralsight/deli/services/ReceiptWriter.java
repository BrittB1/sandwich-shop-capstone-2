package com.pluralsight.deli.services;

import com.pluralsight.deli.models.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public String generateFileName() {

        LocalDateTime currentTime = LocalDateTime.now();
        String pattern = "yyyyMMdd-HHmmss";

        DateTimeFormatter f = DateTimeFormatter.ofPattern(pattern);

        String formattedDate = currentTime.format(f);

        String fileName = formattedDate + ".txt";

        return fileName;
    }

    private void ensureReceiptsFolderExists() {
        File folder = new File("receipts");

        if (!folder.mkdirs()) {
            if (folder.mkdirs()) {
                System.out.println("Folder created!");

            } else {
                System.out.println("ERROR: receipts folder could not be created");
            }
        }
    }
    public void saveReceipt(Order order) {
        ensureReceiptsFolderExists();
        String fileName = generateFileName();

        String filePath = "receipts" + File.separator + fileName;

        String orderContent = order.getOrderDetails();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            bw.write(orderContent);
            System.out.println("Receipts saved to: " + filePath);

        } catch (IOException e) {
            System.out.println("ERROR! Could not save file" + e.getMessage());
        }
    }
}