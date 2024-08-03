import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * <h2>StringLengthSorter.java</h2>
 * <p>This program sorts an array list of strings by increasing length using a Comparator.</p>
 *
 * <p><b>Problem statement:</b> Write a program that sorts an ArrayList of strings by their lengths
 * in increasing order. The program should then print the sorted list.</p>
 *
 * <div style="text-align: center;"><code><b>public class Main</b></code></div>
 * <p><b>Algorithm:</b></p>
 * <p>In <code><b>main</b></code>:</p>
 * <ol>
 *    <li>Create an ArrayList of strings and populate it with sample data.</li>
 *    <li>Sort the list using a Comparator that compares the lengths of the strings.</li>
 *    <li>Print the sorted list to the console.</li>
 * </ol>
 *
 * <p><b>Note:</b> The Comparator is defined inline using an anonymous class. It compares the lengths
 * of the strings using Integer.compare().</p>
 */
public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of strings and populate it with sample data
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "Tom", "Dick", "Harry", "Romeo", "Juliet", "William", "Sarah", "Dixon", "Robert", "Tomaz");

        // Sort the list using a Comparator that compares the lengths of the strings
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // Print the sorted list to the console
        System.out.println(names);
    }
}
