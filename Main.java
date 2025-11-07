import java.util.List;
import java.util.Scanner;
import core.ProgramInterface;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ProgramInterface> programs = ProgramLoader.getPrograms();

        System.out.println("========================================");
        System.out.println(" Welcome to the Program Collection!");
        System.out.println("========================================");
        System.out.println("Select a program to run:\n");

        for (int i = 0; i < programs.size(); i++) {
            ProgramInterface p = programs.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " - " + p.getDescription());
        }

        System.out.print("\nEnter number: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice > 0 && choice <= programs.size()) {
            ProgramInterface selected = programs.get(choice - 1);
            System.out.println("\nRunning: " + selected.getName());
            System.out.println("Author: " + selected.getAuthor());
            System.out.println("----------------------------------------");
            selected.run();
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println("\nThank you for using the Program Collection!");
    }
}
