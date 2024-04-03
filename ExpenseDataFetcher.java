import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExpenseDataFetcher {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/expense";
        String username = "root";
        String password = "expense";

        // SQL query to fetch data from the expenses table
        String sql = "SELECT * FROM expenses";

        try (
                // Establish database connection
                Connection connection = DriverManager.getConnection(url, username, password);
                // Create statement
                Statement statement = connection.createStatement();
                // Execute query and store result in ResultSet
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            // Print column headers
            System.out.println("Category\tAmount\tDate\tDescription");

            // Iterate through the ResultSet and print each record
            while (resultSet.next()) {
                String category = resultSet.getString("category");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                String description = resultSet.getString("description");

                // Print record details
                System.out.println(category + "\t\t" + amount + "\t" + date + "\t" + description);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching data from the database: " + e.getMessage());
        }
    }
}