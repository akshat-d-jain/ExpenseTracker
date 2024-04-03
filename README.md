**Expense Tracker**

---

**Description:**
Expense Tracker is a Java program designed to help users track their expenses and store them in a MySQL database. It provides functionality to add expenses, save them to the database, fetch data from the database, and display expense records. The program offers a user-friendly interface through the console, allowing users to input expense details and view their financial data conveniently.

---

**Features:**
1. Add Expense: Users can add expenses by providing category, amount, date, and description.
2. Save Expenses to Database: The program saves the added expenses to a MySQL database table named `expenses`.
3. Fetch Expense Data: It fetches expense data from the `expenses` table and displays it in the console.
4. Expense Categories: Users can categorize their expenses into different categories such as Food, Travel, etc.
5. Expense Amount: The program accepts the amount spent for each expense entry.
6. Expense Date: Users can input the date of the expense in the format YYYY-MM-DD.
7. Expense Description: Users can provide a description for each expense entry to provide additional details.
8. Error Handling: The program handles SQL exceptions and input validation to ensure smooth execution.

---

**Installation:**
1. Ensure that you have Java Development Kit (JDK) installed on your system.
2. Download the Java source files (`ExpenseTracker.java`, `ExpenseDataFetcher.java`) and the SQL script (`create_expenses_table.sql`).
3. Make sure you have MySQL installed and running on your local machine.
4. Execute the SQL script `create_expenses_table.sql` to create a MySQL database named `expense` with a table named `expenses`.
5. Update the database connection details (`url`, `username`, `password`) in the Java source files to match your MySQL server configuration.

---

**Usage:**
1. Compile the Java source files using the following commands:
   ('javac ExpenseTracker.java','javac ExpenseDataFetcher.java')
3. Run the compiled programs using the following commands:
   ('java ExpenseTracker','java ExpenseDataFetcher')
4. Follow the on-screen instructions to add expenses, save them to the database, and fetch/display expense data.

---
