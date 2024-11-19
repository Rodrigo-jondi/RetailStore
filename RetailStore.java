import java.util.Scanner;
import java.util.regex.Pattern;

public class RetailStore {

    public static void main(String[] args) {
        // Arrays to store the stock levels and prices
        int[] stockLevels = new int[10];
        double[] prices = new double[10];
        
        // Regex patterns to validate the input (positive numbers)
        String quantityPattern = "^[0-9]+";  // Regex for non-negative integers (for stock levels)
        String pricePattern = "^[0-9]+(\\.[0-9]{1,2})?";  // Regex for positive decimal numbers (for prices)

        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Input stock levels and prices for the 10 products
        for (int i = 0; i < 10; i++) {
            boolean validInput = false;
            while (!validInput) {
                // Get the stock level for product i
                System.out.print("Enter stock level for product " + (i + 1) + ": ");
                String stockInput = scanner.nextLine();
                if (Pattern.matches(quantityPattern, stockInput)) {
                    stockLevels[i] = Integer.parseInt(stockInput);
                    validInput = true;
                } else {
                    System.out.println("Invalid stock level. Please enter a non-negative integer.");
                }
            }

            validInput = false;
            while (!validInput) {
                // Get the price for product i
                System.out.print("Enter price for product " + (i + 1) + ": ");
                String priceInput = scanner.nextLine();
                if (Pattern.matches(pricePattern, priceInput)) {
                    prices[i] = Double.parseDouble(priceInput);
                    validInput = true;
                } else {
                    System.out.println("Invalid price. Please enter a valid price (e.g., 10.50).");
                }
            }
        }

        // Calculate the total value of the stock
        double totalStockValue = 0;
        for (int i = 0; i < 10; i++) {
            totalStockValue += stockLevels[i] * prices[i];
        }

        // Output the total value
        System.out.println("\nTotal value of all items in stock: " + totalStockValue);
    }
}