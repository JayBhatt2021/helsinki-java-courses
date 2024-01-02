import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private String databasePath;

    public TodoDao(String databasePath) {
        this.databasePath = databasePath;
    }

    public List<Todo> list() throws SQLException {
        List<Todo> todos = new ArrayList<>();

        try (Connection connection = this.createConnectionAndEnsureDatabase()) {
            ResultSet results = connection.prepareStatement("SELECT * FROM Todo").executeQuery();

            while (results.next()) {
                todos.add(
                        new Todo(
                                results.getInt("id"),
                                results.getString("name"),
                                results.getString("description"),
                                results.getBoolean("done")
                        )
                );
            }
        }

        return todos;
    }

    public void add(Todo todo) throws SQLException {
        try (Connection connection = this.createConnectionAndEnsureDatabase()) {
            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO Todo (name, description, done) VALUES (?, ?, ?)"
            );

            insertStatement.setString(1, todo.getName());
            insertStatement.setString(2, todo.getDescription());
            insertStatement.setBoolean(3, todo.getDone());
            insertStatement.executeUpdate();
        }
    }

    public void markAsDone(int id) throws SQLException {
        try (Connection connection = this.createConnectionAndEnsureDatabase()) {
            PreparedStatement updateStatement = connection.prepareStatement(
                    "UPDATE Todo SET done = true WHERE id = ?"
            );

            updateStatement.setInt(1, id);
            updateStatement.executeUpdate();
        }
    }

    public void remove(int id) throws SQLException {
        try (Connection connection = this.createConnectionAndEnsureDatabase()) {
            PreparedStatement deleteStatement = connection.prepareStatement(
                    "DELETE FROM Todo WHERE id = ?"
            );

            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        }
    }

    private Connection createConnectionAndEnsureDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(this.databasePath, "sa", "");

        try {
            connection.prepareStatement(
                    "CREATE TABLE Todo (id int auto_increment primary key, name varchar(255), description varchar(10000), done boolean)"
            ).execute();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }

        return connection;
    }
}
