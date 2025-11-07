package programs.hanoi; // <-- Correct and ONLY package declaration

import java.util.Scanner; // Required for Scanner
import core.ProgramInterface; // Required for the interface

// Solves Tower of Hanoi recursively.
public class HanoiProgram implements ProgramInterface {

    public String getName() { return "Tower of Hanoi"; }
    public String getDescription() { return "Solves Tower of Hanoi recursively."; }
    public String getAuthor() { return "Example Author"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        solveHanoi(n, 'A', 'C', 'B');
    }

    private void solveHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        solveHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        solveHanoi(n - 1, aux, to, from);
    }
}
