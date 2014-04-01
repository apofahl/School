package homework4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;

/**
 * Created by apofahl
 */
public class Utils {

    private static int count;

    public static Address [] parse(String inFile) {
        Address [] addresses = new Address[0];
        try {
            // Set up to read
            BufferedReader inReader = new BufferedReader(new FileReader(inFile));

            // Count the addresses
            count = 0;
            while (inReader.readLine() != null) {
                count++;
            }

            addresses = new Address [count];
            inReader = new BufferedReader(new FileReader(inFile));

            // Read addresses into array
            for(int dex = 0; dex < count; dex++) {
                String fileLine = inReader.readLine();
                StringTokenizer stTok = new StringTokenizer(fileLine, ":,");
                String name = stTok.nextToken();
                String street = stTok.nextToken();
                String city = stTok.nextToken().trim();
                String stateZP = stTok.nextToken().trim();
                String state = stateZP.substring(0,2);
                String zip = stateZP.substring(3).trim();
                String phone = stTok.nextToken().trim();
                addresses [dex] = new Address(name, street, city, state, zip, phone);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Program termination.");
        } catch (IOException e) {
            System.out.println("IO Exception. Program termination.\n" +e);
        }

        return addresses;
    }

    public static void saveObjects(Address[] addresses, String fileName) {
        FileOutputStream file;
        try {
            file = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(file);
            for(int dex = 0; dex < addresses.length; dex++) {
                output.writeObject(addresses [dex]);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Object [] readObjects(String fileName) {
        Object [] addresses = new Address [count];
        try {
            FileInputStream inFile = new FileInputStream(fileName);
            ObjectInputStream inStrm = new ObjectInputStream(inFile);

            // read in objects
            for (int dex = 0; dex < count; dex++) {
                addresses [dex] = inStrm.readObject();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return addresses;
    }


}
