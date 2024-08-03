/**
 * Polynomial Calculator
 * <h2>Simulates a polynomial calculator for performing arithmetic operations on polynomials</h2>
 * <p><b>Description:</b> This project consists of two classes, <code>Term</code> and <code>Polynomial</code>,
 * which together represent and manipulate polynomials.</p>
 * <ul>
 *   <li><code>Term</code> captures the coefficient and exponent of each term in the polynomial.</li>
 *   <li><code>Polynomial</code> stores the polynomial as a linked list of terms and provides methods to add, multiply, and print polynomials.</li>
 * </ul>
 * <p><b>Discussion Items:</b></p>
 * <ul>
 *   <li>The <code>add</code> method adds another polynomial to the current polynomial.</li>
 *   <li>The <code>multiply</code> method multiplies the current polynomial with another polynomial.</li>
 *   <li>The <code>print</code> method prints the polynomial in a readable format.</li>
 * </ul>
 *
 * @version 1.0
 * @author Hunter O'Brien
 */

// Term class to represent each term in the polynomial
class Term {
    int coefficient;
    int exponent;
    Term next;

    /**
     * Constructor to create a term with a given coefficient and exponent
     * @param coefficient The coefficient of the term
     * @param exponent The exponent of the term
     */
    public Term(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

// Polynomial class to represent the polynomial using linked list
class Polynomial {
    private Term head;

    /**
     * Constructor to create a polynomial from a single term
     * @param term The term to initialize the polynomial
     */
    public Polynomial(Term term) {
        head = term;
    }

    /**
     * Adds another polynomial to the current polynomial
     * @param p The polynomial to be added
     */
    public void add(Polynomial p) {
        Term current = head;
        Term pCurrent = p.head;

        while (pCurrent != null) {
            boolean termAdded = false;
            Term prev = null;

            while (current != null && current.exponent >= pCurrent.exponent) {
                if (current.exponent == pCurrent.exponent) {
                    current.coefficient += pCurrent.coefficient;
                    termAdded = true;
                    break;
                }
                prev = current;
                current = current.next;
            }

            if (!termAdded) {
                Term newTerm = new Term(pCurrent.coefficient, pCurrent.exponent);
                if (prev == null) {
                    newTerm.next = head;
                    head = newTerm;
                } else {
                    newTerm.next = prev.next;
                    prev.next = newTerm;
                }
            }

            pCurrent = pCurrent.next;
            current = head;
        }
    }

    /**
     * Multiplies the current polynomial with another polynomial
     * @param p The polynomial to be multiplied with
     * @return The resulting polynomial after multiplication
     */
    public Polynomial multiply(Polynomial p) {
        Polynomial result = new Polynomial(new Term(0, 0));
        Term current = head;

        while (current != null) {
            Polynomial tempPoly = new Polynomial(new Term(0, 0));
            Term pCurrent = p.head;

            while (pCurrent != null) {
                int newCoeff = current.coefficient * pCurrent.coefficient;
                int newExp = current.exponent + pCurrent.exponent;
                tempPoly.add(new Polynomial(new Term(newCoeff, newExp)));
                pCurrent = pCurrent.next;
            }

            result.add(tempPoly);
            current = current.next;
        }

        return result;
    }

    /**
     * Prints the polynomial in a readable format
     */
    public void print() {
        Term current = head;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exponent);
            if (current.next != null) {
                System.out.print(" + ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to test the Polynomial class
public class PolynomialCalculator {
    public static void main(String[] args) {
        // Initialize polynomial p with terms
        Polynomial p = new Polynomial(new Term(-10, 0));
        p.add(new Polynomial(new Term(-1, 1)));
        p.add(new Polynomial(new Term(9, 7)));
        p.add(new Polynomial(new Term(5, 10)));

        // Print polynomial p(x)
        System.out.print("p(x) = ");
        p.print();

        // Compute q(x) = p(x) * p(x) and print the result
        Polynomial q = p.multiply(p);

        System.out.print("q(x) = p(x) * p(x) = ");
        q.print();
    }
}
