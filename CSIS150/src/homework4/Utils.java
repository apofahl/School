package homework4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by apofahl on 3/21/14.
 */
public class Utils {

    public static Address [] parse(String inFile) {
        Address [] addresses = new Address[0];
        try {
            // Set up to read
            BufferedReader inReader = new BufferedReader(new FileReader(inFile));
            String fileLine = inReader.readLine();
            StringTokenizer stTolk = new StringTokenizer(fileLine);

            // Count the addresses

            // Read addresses into array
            for (int dex = 0; dex < addresses.length; dex++) {

            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }

        return addresses;
    }

    public static void saveObjects(Address[] addresses, String fileName) {

    }

    public static Object [] readObjects(String fileName) {
        Object [] addresses = new Object[0];

        return addresses;
    }


}
