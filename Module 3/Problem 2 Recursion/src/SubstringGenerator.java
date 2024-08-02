import java.util.ArrayList;
import java.util.List;

/**
 * <h2>SubstringGenerator.java - A class to generate all substrings of a given string.</h2>
 * <p>This class provides a method to recursively generate all possible substrings of a given string.</p>
 *
 * <p><b>Problem statement:</b> Create a method that generates all substrings of a given string using recursion.</p>
 *
 * <div style="text-align: center;"><code><b>public class SubstringGenerator</b></code></div>
 *
 * @version Module 3 project 2
 * @author Hunter S O'Brien
 */
public class SubstringGenerator {

    /**
     * Generates all substrings of the given string.
     * @param s the input string
     * @return a list containing all substrings of the input string
     */
    public static List<String> generateSubstrings(String s) {
        // Base case: if the string is empty, return a list with an empty string
        if (s.isEmpty()) {
            List<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }

        // Get the first character
        char firstChar = s.charAt(0);

        // Get all substrings of the remaining string
        List<String> substringsWithoutFirst = generateSubstrings(s.substring(1));

        // Initialize the list for substrings that start with the first character
        List<String> substringsWithFirst = new ArrayList<>();

        // Generate all substrings that start with the first character
        for (String substring : substringsWithoutFirst) {
            substringsWithFirst.add(firstChar + substring);
        }

        // Combine the two lists
        List<String> result = new ArrayList<>(substringsWithFirst);
        result.addAll(substringsWithoutFirst);

        return result;
    }

    /**
     * The main method to test the substring generation.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String string = "rum";
        List<String> substrings = generateSubstrings(string);

        System.out.println(substrings);
    }
}
