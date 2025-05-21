import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("FIVE NIGHT AT FREDDY'S");
        System.out.println("Please make an option below:" + "\n");
        System.out.println("1. Start Game");
        System.out.println("2. 6th Night");
        System.out.println("3. Ultra Custom Night");
        System.out.println("4. Options");
        System.out.println();

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\nStarting Game...");
                
        } else if (choice == 2) {
            System.out.println("\nStarting 6th Night...");
        } else if (choice == 3) {
            System.out.println("\nStarting Ultra Custom Night...");
        } else if (choice == 4) {
            System.out.println("\nOpening Options...");
        } else {
            System.out.println("\nInvalid choice. Please try again.");
        }

        scanner.close();
    }
}
