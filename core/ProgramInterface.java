package core;
// Defines what every program must have.
// Think of this as a "contract" that all programs agree to follow.

public interface ProgramInterface {
    String getName();          // Program title
    String getDescription();   // Short summary of what it does
    String getAuthor();        // Student name
    void run();                // Main logic of the program
}
