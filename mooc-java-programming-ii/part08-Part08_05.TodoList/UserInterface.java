/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JayBh
 */
import java.util.Scanner;
public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;
    
    public UserInterface(TodoList todoList, Scanner scanner) {
        this.todoList = todoList;
        this.scanner = scanner;
    }
    
    public void start() {
        while(true) {
            System.out.print("Command: ");
            String command = this.scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("add")) {
                System.out.print("To add: ");
                String adder = this.scanner.nextLine();
                this.todoList.add(adder);
            } else if (command.equals("list")) {
                this.todoList.print();
            } else if (command.equals("remove")) {
                System.out.print("Which one is removed? ");
                int ci = Integer.valueOf(scanner.nextLine());
                this.todoList.remove(ci);
            }
        }
    }
}
