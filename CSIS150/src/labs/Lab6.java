package labs;

import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;

/**
 * Created by apofahl
 */
public class Lab6 {

    /**
     * How many numbers need to be in the array.
     * @param input file being used to see what is in it
     * @return number to be used for array
     * @throws java.io.IOException
     */
    public static int HowMany(DataInputStream input) throws IOException
    {
        int howMany = 0;
        double number;
        boolean end = false;

        while (!end)
        {
            try
            {
                number = input.readDouble();
                howMany ++;
            }
            catch (EOFException e)
            {
                end = true;
            }
        }

        return howMany;
    }

    /**
     * How many numbers need to be in the array.
     * @param input file being used to see what is in it
     * @return number to be used for array
     * @throws IOException
     */
    public static int HowMany2(FileReader input) throws IOException
    {
        int howMany = 0;
        double number = input.read();

        while (number != -1)
        {
            howMany ++;
            number = input.read();
        }

        return howMany;
    }

    /**
     * Creates String for outputing
     * @param file array of numbers
     * @param howMany length of file
     * @param average the average of the number in the file
     * @return output statement
     */
    public static String Output(double [ ] file, int howMany, double average)
    {
        String output = "This file contains the numbers";
        DecimalFormat DF = new DecimalFormat("0.00");
        for (int i = 0; i < howMany; i++)
        {
            if (i < (howMany - 1))
            {
                output += " " +file [i]+ ",";
            }
            else
            {
                output += " " +file [i]+ ".";
            }
        }
        output += "\n\nThe average of the numbers in the file is " +DF.format(average)+ ".";

        return output;
    }

    /**
     * Creates String for outputing
     * @param file array of numbers
     * @param howMany length of file
     * @param average the average of the number in the file
     * @return output statement
     */
    public static String Output2(double [ ] file, int howMany, double average)
    {
        String output = "This file contains the numbers";
        DecimalFormat DF = new DecimalFormat("0.00");
        for (int i = 0; i < howMany; i++)
        {
            if (i < (howMany - 1))
            {
                output += " " +file [i]+ ",";
            }
            else
            {
                output += " " +file [i]+ ".";
            }
        }
        output += "\n\nThe average of the numbers in the file is " +DF.format(average)+ ".";

        return output;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Set up binary file reader
        FileInputStream fstream = null;
        int howMany = 0;
        double average = 0;
        try {
            fstream = new FileInputStream("doubles.dat");
            DataInputStream input = new DataInputStream(fstream);

            // Count how many places
            howMany = HowMany(input);
            input.close();

            // Set up array
            fstream = new FileInputStream("doubles.dat");
            input = new DataInputStream(fstream);
            double [ ] dBinary = new double [howMany];

            // Load array
            for (int i = 0; i < howMany; i++)
            {
                dBinary [i] = input.readDouble();
            }

            // Calculate average
            for (int i = 0; i < howMany; i++)
            {
                average += dBinary [i];
            }
            average = average / howMany;

            // Output information
            String output = Output(dBinary, howMany, average);
            JOptionPane.showMessageDialog(null, output);
            input.close();

            // BONUS :)
            // Open the file.
            FileReader inputFile = new FileReader("doubles.csv");

            // Count how many places
            howMany = HowMany2(inputFile);
            inputFile.close();

            // Set up array
            inputFile = new FileReader("doubles.csv");
            double [ ] dCSV = new double [howMany];

            // Load array
            int raw = 0;
            for (int i = 0; i < howMany; i++)
            {
                raw = inputFile.read();
                dCSV [i] = (char) raw; // loads all into same array.
            }

            // Calculate average
            for (int i = 0; i < howMany; i++)
            {
                average += dCSV [i];
            }
            average = average / howMany;

            // Output information
            output = Output2(dCSV, howMany, average);
            JOptionPane.showMessageDialog(null, output);
            inputFile.close();

        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "The file does not exist.");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "I/O Error: " + e.getMessage());
        }

    }
}
