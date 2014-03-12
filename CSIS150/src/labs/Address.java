package labs;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Address implements Serializable{

    String name;
    String street;
    String city;
    String state;
    String zip;
    double phone;

    /**
     * Skeleton of address object
     */
    public Address() {
        name = "not available";
        street = "not available";
        city = "not available";
        state = "not available";
        zip = "not available";
        phone = 0000000000;
    }

    /**
     * Builds an address object with given input
     * @param n for name
     * @param str for street address
     * @param c for city
     * @param sta for state
     * @param z for zip code
     * @param p for phone number
     */
    public Address(String n, String str, String c, String sta, String z, double p) {
        name = n;
        street = str;
        city = c;
        state = sta;  //validate state exists?
        zip = z;
        phone = p; // check to make sure it has enough numbers?
    }

    /**
     * changes the name of an address object
     * @param newName the new name
     */
    public void gotMarried(String newName) {
        name = newName;
    }

    /**
     * changes the street address of an address object
     * @param str new street address
     * @param c new city
     * @param sta new state
     * @param z new zip code
     */
    public void moving(String str, String c, String sta, String z) {
        street = str;
        city = c;
        state = sta;
        zip = z;
    }

    /**
     * changes the phone number of an address object
     * @param p for the new number
     */
    public void newPhone(double p) {
        phone = p;  // check length?
    }

    /**
     * Reports information for an address object
     */
    public String toString() {
        int [ ] phoneArray = new int [10];
        double j = 1000000000;
        for (int i = 0; i < 10; i++) {
            phoneArray [i] = (int) (phone / j);
            phone = phone % j;
            j = j/ 10;
        }

        String output = "NAME: " +name+ "\nSTREET: " +street+ "\nCITY: " +city;
        output += "\nSTATE: " +state+ "\nZIP CODE: " +zip+ "\nPHONE NUMBER: (";

        for (int i = 0; i < 10; i++) {
            output += phoneArray [i];
            if (i == 2) {
                output += ")";
            }
            else if (i == 5) {
                output += "-";
            }
        }

        return output;
    }

}

