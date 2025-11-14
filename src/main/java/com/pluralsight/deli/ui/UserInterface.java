package com.pluralsight.deli.ui;

import com.pluralsight.deli.enums.*;
import com.pluralsight.deli.models.Chips;
import com.pluralsight.deli.models.Drink;
import com.pluralsight.deli.models.Order;
import com.pluralsight.deli.models.Sandwich;
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

                    case "O":
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
                case 0 -> {
                    System.out.println("Order Cancelled. All items Removed");
                    currentOrder.clearOrder();
                    ordering = false;
                }
                default -> System.out.println(" Invalid option. Please try again..");
            }
        }
    }

    private void checkout() {

        System.out.println("╔═════════════════════════════╗");
        System.out.println("║           Checkout          ║");
        System.out.println("╚═════════════════════════════╝");
        currentOrder.getOrderDetails();

        if (!currentOrder.isValid()){
            System.out.println("Can't checkout - order is empty!");
            return;

        } else {
            System.out.println(currentOrder.getOrderDetails());

            System.out.println("Confirm order? (y/n): ");
            String confirmation = keyboard.nextLine().trim().toUpperCase();

            if (confirmation.equals("Y")){
                rw.saveReceipt(currentOrder);
                System.out.println("╔══════════════════════════════════════════════════════╗");
                System.out.println("║\uD83C\uDF89 Order complete - your receipt has been saved!   ║");
                System.out.println("║                 Thanks for your order                ║");
                System.out.println("╚══════════════════════════════════════════════════════╝");
                currentOrder = new Order();

            } else {
                System.out.println("Checkout cancelled - returning to ordering menu");

            }
        }
    }
    private void addSandwich() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║\uD83D\uDD28 Build your sandwich   ║");
        System.out.println("╚═════════════════════════════╝");

        BreadType type = selectBreadType();
        SandwichSize size = selectSandwichSize();

        Sandwich sandwich = new Sandwich(size,type);

        addMeatsToSandwich(sandwich);
        addCheesesToSandwich(sandwich);
        addToppingsToSandwich(sandwich);
        addSaucesToSandwich(sandwich);
        askIfToasted(sandwich);

        currentOrder.addItem(sandwich);

        System.out.println("\uD83E\uDD6A Sandwich added to order!");

    }

    private void askIfToasted(Sandwich sandwich) {
    }

    private void addSaucesToSandwich(Sandwich sandwich) {
    }

    private void addToppingsToSandwich(Sandwich sandwich) {
    }

    private void addCheesesToSandwich(Sandwich sandwich) {
    }

    private void addMeatsToSandwich(Sandwich sandwich) {

        System.out.println("╔═════════════════════════════╗");
        System.out.println("║\uD83C\uDF56 Add Meats       ║");
        System.out.println("╚═════════════════════════════╝");

        while (true) {

            System.out.println("Meats added: " + sandwich.getMeat().size());
            MeatType [] meat = MeatType.values();

            for (int i = 0; i < meat.length; i++) {
                System.out.println((i + 1) + ". " + meat[i].getDisplayName());
            }
            System.out.println("0. Done adding meats");

            System.out.println("Choose meat (Select '0' when done): ");
            int choice = Integer.parseInt(keyboard.nextLine().trim());

            if (choice == 0) {
                break;
            }
            if (choice < 1 || choice > meat.length) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            sandwich.addMeat(meat[choice - 1]);
            System.out.println(meat[choice - 1].getDisplayName() + "added!");
        }
        if (!sandwich.getMeat().isEmpty()) {
            System.out.println("Would you like Xtra meat? (y/n): ");
            String xtraMeat = keyboard.nextLine().trim().toUpperCase();

            if (xtraMeat.equals("Y")){
                sandwich.setHasExtraMeat(true);
                System.out.println("Extra meat added!");
            }
        }
}
    private SandwichSize selectSandwichSize() {

        SandwichSize[] length = SandwichSize.values();
        for (int i = 0; i < length.length; i++) {
            System.out.println((i + 1) + ". " + length[i].getDisplayName());
        }
        System.out.println("Choose a sandwich size: 1-" + length.length + "):");
        int selection = Integer.parseInt(keyboard.nextLine().trim());

        if (selection < 1 || selection > length.length) {
            System.out.println("Invalid choice. Please try again.");
            return SandwichSize.MEDIUM;
        }
        return length[selection - 1];
    }

    private BreadType selectBreadType() {
        BreadType[] types = BreadType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ". " + types[i].getDisplayName());
        }
        System.out.println("Choose a bread type: 1-" + types.length + "):");
        int selection = Integer.parseInt(keyboard.nextLine().trim());

        if (selection < 1 || selection > types.length) {
            System.out.println("Invalid choice. Please try again.");
            return BreadType.WHITE;
        }
        return types[selection - 1];
    }

    private void addDrink() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║          Add Drink          ║");
        System.out.println("╚═════════════════════════════╝");

        DrinkSize size = selectDrinkSize();
        DrinkFlavor flavor = selectDrinkFlavor();

        Drink drink = new Drink(size,flavor);
        currentOrder.addItem(drink);

        System.out.println("Drink added!");
    }

    private DrinkSize selectDrinkSize() {
        DrinkSize[] sizes = DrinkSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ". " + sizes[i].getDisplayName());
        }
        System.out.println("Choose a size: (1-" + sizes.length + "):");
        int choice = Integer.parseInt(keyboard.nextLine().trim());

        if (choice < 1 || choice > sizes.length) {
            System.out.println("Invalid choice. Please try again.");
            return DrinkSize.MEDIUM;
        }
        return sizes[choice - 1];
    }

    private DrinkFlavor selectDrinkFlavor() {

        DrinkFlavor[] flavors = DrinkFlavor.values();
        for (int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ". " + flavors[i].getDisplayName());
        }
        System.out.println("Choose a flavor: (1-" + flavors.length + "):");
        int choice = Integer.parseInt(keyboard.nextLine().trim());

        if (choice < 1 || choice > flavors.length) {
            System.out.println("Invalid choice. Defaulting to Water.");
            return DrinkFlavor.WATER;
        }
        return flavors[choice - 1];
    }

    private void addChips() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║          Add Chips          ║");
        System.out.println("╚═════════════════════════════╝");

        ChipType[] chips = ChipType.values();
        for (int i = 0; i < chips.length; i++) {
            System.out.println((i + 1) + ". " + chips[i].getDisplayName());
        }
        System.out.println("Choose some chips: (1-" + chips.length + "):");
        int choice = Integer.parseInt(keyboard.nextLine().trim());

        if (choice < 1 || choice > chips.length) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }
        Chips selectedChips = new Chips(chips[choice - 1]);
        currentOrder.addItem(selectedChips);

        System.out.println("Chips added!");
    }
}

