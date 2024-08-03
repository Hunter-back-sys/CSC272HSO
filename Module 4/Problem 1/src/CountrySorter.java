/**
 * <h2>CountrySorter Class</h2>
 * <p><b>Description:</b> This class demonstrates the sorting of countries by their area in descending order.</p>
 * <ul>
 *   <li>The <code>Country</code> class represents a country with a name and area.</li>
 *   <li>The <code>CountrySorter</code> class contains the main method to add, display, and sort countries.</li>
 * </ul>
 * <p><b>Methods:</b></p>
 * <ul>
 *   <li><code>Country(String name, double area)</code>: Constructor to create a Country object.</li>
 *   <li><code>getName()</code>: Returns the name of the country.</li>
 *   <li><code>getArea()</code>: Returns the area of the country.</li>
 *   <li><code>toString()</code>: Returns a string representation of the country.</li>
 *   <li><code>main(String[] args)</code>: Main method to add, display, and sort countries.</li>
 * </ul>
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Country {
    private String name;
    private double area;

    /**
     * Constructor to create a Country object.
     * @param name Name of the country.
     * @param area Area of the country in square kilometers.
     */
    public Country(String name, double area) {
        this.name = name;
        this.area = area;
    }

    /**
     * Returns the name of the country.
     * @return Name of the country.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the area of the country.
     * @return Area of the country.
     */
    public double getArea() {
        return area;
    }

    /**
     * Returns a string representation of the country.
     * @return String representation of the country.
     */
    @Override
    public String toString() {
        return name + " (" + area + " sq km)";
    }
}

public class CountrySorter {
    public static void main(String[] args) {
        ArrayList<Country> countries = new ArrayList<>();

        // Adding the top 12 largest countries by area
        countries.add(new Country("Russia", 17098242));
        countries.add(new Country("Canada", 9984670));
        countries.add(new Country("China", 9596961));
        countries.add(new Country("United States", 9372610));
        countries.add(new Country("Brazil", 8515767));
        countries.add(new Country("Australia", 7692024));
        countries.add(new Country("India", 3287263));
        countries.add(new Country("Argentina", 2780400));
        countries.add(new Country("Kazakhstan", 2724900));
        countries.add(new Country("Algeria", 2381741));
        countries.add(new Country("Democratic Republic of the Congo", 2344858));
        countries.add(new Country("Greenland (Denmark)", 2166086));

        // Display countries before sorting
        System.out.println("Countries before sorting:");
        for (Country country : countries) {
            System.out.println(country);
        }

        // Sort countries in decreasing order by area
        Collections.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return Double.compare(c2.getArea(), c1.getArea());
            }
        });

        // Display countries after sorting
        System.out.println("\nCountries after sorting:");
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
