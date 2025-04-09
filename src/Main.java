import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String choice;

        do {
            displayList();
            displayMenu();

            // Menu choice
            choice = SafeInput.getRegExString(in, "Enter your choice [A D I P Q]", "[AaDdIiPpQq]").toUpperCase();

            // Menu options
            switch (choice) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                        System.out.println("Exiting program.");
                    } else {
                        choice = "";
                    }
                    break;
            }
        } while (!choice.equals("Q"));
    }

    // Display menu options
    private static void displayMenu() {
        System.out.println("\nMENU OPTIONS:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit the program");
    }

    // Show the current list, numbered
    private static void displayList() {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("[List is empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d: %s\n", i + 1, list.get(i));
            }
        }
    }

    // Add item to the end of the list
    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add");
        list.add(item);
    }

    // Delete item by number
    private static void deleteItem() {
        if (list.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        int index = SafeInput.getRangedInt(in, "Enter item number to delete (1 to " + list.size() + ")", 1, list.size());
        list.remove(index - 1);
        System.out.println("Item deleted.");
    }

    // Insert item at a specific position
    private static void insertItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert");
        int index = SafeInput.getRangedInt(in, "Enter position to insert (1 to " + (list.size() + 1) + ")", 1, list.size() + 1);
        list.add(index - 1, item);
        System.out.println("Item inserted.");
    }

    // Prints the list again
    private static void printList() {
        displayList();
    }
}
