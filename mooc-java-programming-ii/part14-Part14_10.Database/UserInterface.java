import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            System.out.println();

            if (command.equals("x")) {
                break;
            }

            this.makeChoice(Integer.valueOf(command));
            System.out.println();
        }

        System.out.println("Thank you!");
    }

    private void makeChoice(int commandNumber) throws SQLException {
        switch (commandNumber) {
            case 1:
                this.list();
                break;
            case 2:
                this.add();
                break;
            case 3:
                this.markAsDone();
                break;
            case 4:
                this.remove();
                break;
            default:
                System.out.println("Please enter a valid command.");
                break;
        }
    }

    private void list() throws SQLException {
        System.out.println("Listing the database contents");
        for (Todo todo : this.database.list()) {
            System.out.println(todo);
        }
    }

    private void add() throws SQLException {
        System.out.println("Adding a new todo");

        System.out.println("Enter name");
        String name = this.scanner.nextLine();

        System.out.println("Enter description");
        String description = this.scanner.nextLine();

        this.database.add(new Todo(name, description, false));
    }

    private void markAsDone() throws SQLException {
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.valueOf(this.scanner.nextLine());

        this.database.markAsDone(id);
    }

    private void remove() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.valueOf(this.scanner.nextLine());

        this.database.remove(id);
    }
}
