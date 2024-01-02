import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        String databasePath = "jdbc:h2:./todo-database";

        if (args.length > 0) {
            databasePath = args[0];
        }

        Scanner scanner = new Scanner(System.in);
        TodoDao database = new TodoDao(databasePath);
        new UserInterface(scanner, database).start();
    }
}
