package com.pluralsight.deli.ui;

import com.pluralsight.deli.models.Order;
import com.pluralsight.deli.services.ReceiptWriter;

import java.util.Scanner;

public class UserInterface {
    private final Scanner keyboard;
    private Order currentOrder;
    private ReceiptWriter rw;

    public UserInterface() {
        keyboard = new Scanner(System.in);
        rw = new ReceiptWriter();
    }

    public void start() {
        showHomeScreen();
    }
        private void showHomeScreen() {
            boolean running = true;

            while (running) {
                System.out.println("""
╔════════════════════════════════════╗
║        Welcome to Billy's!         ║
║    The best sandwiches in town     ║
║   ══════════════════════════════   ║
║    Choose an option by letter:     ║
║   O. 🍔 New Order                  ║
║   X. 🚪 EXIT                       ║ \s
╚════════════════════════════════════╝
                        \s""");
                System.out.print("Enter choice: ");
                String choice = keyboard.nextLine().trim().toUpperCase();

                switch (choice) {

                    case "N":
                        currentOrder = new Order();
                        displayOrderScreen();
                        break;
                    case "X":
                        System.out.println("\uD83D\uDC4B Thanks for coming. See you again soon!");
                        running = false;
                        break;
                    default:
                        System.out.println("❌ Sorry, invalid choice. Please try again.");
                }
            }
        }

    private void displayOrderScreen() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("╔═════════════════════════════╗");
            System.out.println("║        Current Order        ║");
            System.out.println("╚═════════════════════════════╝");

            if (currentOrder.itemCount() == 0) {
                System.out.println("Order empty! Please order some food");
            } else {
                System.out.println(currentOrder.getOrderDetails());
            }
            System.out.println("""
                    ╔═════════════════════════════════════╗
                    ║         Add to Your Order           ║
                    ║     ═════════════════════════════   ║
                    ║       1. 🥪 Add Sandwich            ║
                    ║                                     ║
                    ║       2. 🥤 Add Drink               ║ 
                    ║                                     ║
                    ║       3. 🍟 Add Chips               ║
                    ║                                     ║
                    ║       4. ✅ Checkout                ║
                    ║                                     ║
                    ║       0. ❌ Cancel Order            ║
                    ╚═════════════════════════════════════╝
                    """);
            System.out.println("Enter choice: ");
            int choice = Integer.parseInt(keyboard.nextLine().trim());

            switch (choice) {
                case 1 -> addSandwich();
                case 2 -> addDrink();
                case 3 -> addChips();
                case 4 -> checkout();
                case 0 -> cancelOrder();
                default -> System.out.println(" Invalid option. Please try again..");
            }
        }
    }

    private void addSandwich() {
    }

    private void addDrink() {
    }

    private void addChips() {
    }
}
