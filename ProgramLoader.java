import java.util.ArrayList;
import java.util.List;
import core.ProgramInterface;

// Import program classes to make their types known
import programs.fibonacci.FibonacciProgram;
import programs.hanoi.HanoiProgram;
import programs.palindrome.PalindromeProgram;

// Loads all available programs.
// Students only need to ADD ONE LINE per new program in getPrograms().
public class ProgramLoader {

    public static List<ProgramInterface> getPrograms() {
        List<ProgramInterface> programs = new ArrayList<>();

        // 👇 Register programs here
        programs.add(new programs.fibonacci.FibonacciProgram());
        programs.add(new programs.hanoi.HanoiProgram());
        programs.add(new programs.palindrome.PalindromeProgram());

        // Example: programs.add(new programs.[folder].[ClassName]());
        // Only one line per new program.

        return programs;
    }
}
