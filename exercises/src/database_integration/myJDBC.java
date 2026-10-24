package database_integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class myJDBC {
    public static void main(String[] args) {
        // Use these environment variables if set; otherwise connect to the local MySQL database.
        // The URL contains the server address (127.0.0.1), port (3306), and database name (cadastro).
        String url = System.getenv().getOrDefault(
                "DB_URL", "jdbc:mysql://127.0.0.1:3306/cadastro");
        // These defaults match the local MySQL setup; the password is empty.
        String user = System.getenv().getOrDefault("DB_USER", "root");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "");

        // Ask MySQL to return every row from the cursos table.
        String query = "SELECT * FROM cursos";

        // Open the connection, send the query, and get its results.
        // try-with-resources automatically closes these database resources when finished.
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {
            // Move through the returned rows one at a time.
            while (results.next()) {
                // Print the idcurso and nome columns from the current row.
                System.out.printf("%d: %s%n", results.getInt("idcurso"), results.getString("nome"));
            }
        } catch (SQLException e) {
            // Show the database error if connecting or running the query fails.
            System.err.println("Database connection or query failed: " + e.getMessage());
            System.exit(1);
        }
    }
}
