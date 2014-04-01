package homework4;

import java.io.Serializable;
import java.text.DecimalFormat;

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
    public Address(String name, String street, String city, String state, String zip, String phone) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;  //validate state exists?
        this.zip = zip;
        newPhone(phone);
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
    public void newPhone(String phone) {
        String phone1 = phone.replace("(", "");
        phone1 = phone1.replace(")", "");
        phone1 = phone1.replace("-", "");

        if (phone1.length() == 10) {
            try {
                this.phone = Double.parseDouble(phone1);
            } catch (NumberFormatException e) {
                System.out.println("***" +name+ " has an incorrect phone number format: " +phone);
            }
        } else {
            System.out.println("***" +name+ " has an incorrect phone number format: " +phone);
        }
    }

    /**
     * Reports information for an address object
     */
    public String toString() {
        String output = "NAME: " +name+ "\nSTREET: " +street+ "\nCITY: " +city;
        output += "\nSTATE: " +state+ "\nZIP CODE: " +zip+ "\nPHONE NUMBER: ";

        if (phone > 0) {
            // format phone number
            DecimalFormat formatter = new DecimalFormat("0");
            String number = "" +formatter.format(phone);
            output += "(";
            for (int dex = 0; dex < 10; dex++) {
                output += number.charAt(dex);
                if (dex == 2) {
                    output += ")";
                }
                else if (dex == 5) {
                    output += "-";
                }
            }
        } else {
            output += "---";
        }

        return output;
    }

}

