package homework4;

import java.io.Serializable;

public class Address implements Serializable{

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private double phone;

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
     * @param name for name
     * @param street for street address
     * @param city for city
     * @param state for state
     * @param zip for zip code
     * @param phone for phone number
     */
    public Address(String name, String street, String city, String state, String zip, double phone) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;  //validate state exists?
        this.zip = zip;
        this.phone = phone; // check to make sure it has enough numbers?
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
     * @param street new street address
     * @param city new city
     * @param state new state
     * @param zip new zip code
     */
    public void moving(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * changes the phone number of an address object
     * @param phone for the new number
     */
    public void newPhone(double phone) {
        this.phone = phone;  // check length?
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

