package programs.palindrome; // <-- Correct and ONLY package declaration

import java.util.Scanner; // Required for Scanner
import core.ProgramInterface; // Required for the interface

// Checks if a word is a palindrome (reads same backward and forward).
public class PalindromeProgram implements ProgramInterface {

    public String getName() { return "Palindrome Checker"; }
    public String getDescription() { return "Checks if a word is a palindrome."; }
    public String getAuthor() { return "Example Author"; }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.nextLine();
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equalsIgnoreCase(reversed))
            System.out.println(word + " is a palindrome!");
        else
            System.out.println(word + " is NOT a palindrome.");
    }
}
