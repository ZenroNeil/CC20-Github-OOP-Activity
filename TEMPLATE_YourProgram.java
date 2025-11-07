package programs.yourprogram;

import java.util.Scanner;
import ProgramInterface;

// 🧩 TEMPLATE: Copy this to your own folder and modify values.
public class YourProgram implements ProgramInterface {

    public String getName() { return "My Sample Program"; }
    public String getDescription() { return "Brief description of what your program does."; }
    public String getAuthor() { return "Your Name"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! This is your custom program.");
        // Add your logic here
    }
}
