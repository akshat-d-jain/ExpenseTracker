import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        List<Expense> expenses = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);

        addExpense(scanner, expenses);


        saveExpensesToDatabase(expenses);

        for (Expense expense : expenses) {
            System.out.println("Category: " + expense.getCategory());
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Amount: $" + expense.getAmount().getValue());
            System.out.println("Date: " + expense.getDate().toString());
            System.out.println("Tax: $" + expense.calculateTax());
            System.out.println();
        }

        // Close scanner
        scanner.close();
    }

    private static void addExpense(Scanner scanner, List<Expense> expenses) {
        String choice;
        do {
            System.out.println("Enter expense category (Food/Travel):");
            String category = scanner.nextLine();

            System.out.println("Enter expense amount:");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter expense date (YYYY-MM-DD):");
            String date = scanner.nextLine();

            System.out.println("Enter expense description:");
            String description = scanner.nextLine();

            if (category.equalsIgnoreCase("Food")) {
                expenses.add(new FoodExpense(category, new Amount(amount), new Date(date), description));
            } else if (category.equalsIgnoreCase("Travel")) {
                expenses.add(new TravelExpense(category, new Amount(amount), new Date(date), description));
            } else {
                System.out.println("Invalid category. Please enter 'Food' or 'Travel'.");
            }

            System.out.println("Do you want to add another expense? (yes/no)");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));
    }

    private static void saveExpensesToDatabase(List<Expense> expenses) {
        String url = "jdbc:mysql://localhost:3306/expense";
        String username = "root";
        String password = "expense";
        String sql = "INSERT INTO expenses (category, amount, date, description) VALUES (?, ?, ?, ?)";

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {

            for (Expense expense : expenses) {
                statement.setString(1, expense.getCategory());
                statement.setDouble(2, expense.getAmount().getValue());
                statement.setString(3, expense.getDate().toString());
                statement.setString(4, expense.getDescription());
                statement.executeUpdate();
            }
            System.out.println("Expenses saved to the database successfully.");
        } catch (SQLException e) {
            System.out.println("Error saving expenses to the database: " + e.getMessage());
        }
    }
}