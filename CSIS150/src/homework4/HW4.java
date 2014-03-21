package homework4;

/**
 * Created by apofahl
 */
public class HW4 {

    public static void main(String[] args) {

        // Read the addresses from file "address.txt"
        Address[] addrs = Utils.parse("address.txt");

        // Save these address objects into file "objects.dat"
        Utils.saveObjects(addrs, "objects.dat");

        // Read these objects back from "objects.dat"
        Object[] objs = Utils.readObjects("objects.dat");

        // Print the information about each address in the specified format
        for (int i = 0; i < objs.length; i++) {
            System.out.println((Address) objs[i]);
        }

    }

}
