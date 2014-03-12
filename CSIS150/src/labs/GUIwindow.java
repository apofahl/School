package labs;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GUIwindow extends JFrame {

    JPanel panel;
    JTextField nameButton;
    JTextField streetButton;
    JTextField cityButton;
    JTextField stateButton;
    JTextField zipButton;
    JTextField phoneButton;

    /**
     * Builds a window where you can input information to be entered into
     * 		Address object.
     */
    public GUIwindow()
    {
        // Set the title
        setTitle("Save your addresses!");

        // Close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up text fields
        nameButton = new JTextField(" Enter name ");
        streetButton = new JTextField("  Enter street        ");
        cityButton = new JTextField(" Enter city ");
        stateButton = new JTextField(" Enter state ");
        zipButton = new JTextField(" Enter zip code ");
        phoneButton = new JTextField(" Phone number: XXXXXXXXXX ");

        // Set up message label
        JLabel messageLabel = new JLabel("Enter address information: ");

        // Set up Save Button
        JButton saveButton = new JButton("Save!");

        // Make the save button do something
        ButtonListener BL = new ButtonListener();
        saveButton.addActionListener(BL);

        // Put it all together
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 30 ,10));
        panel.add(messageLabel);
        panel.add(nameButton);
        panel.add(streetButton);
        panel.add(cityButton);
        panel.add(stateButton);
        panel.add(zipButton);
        panel.add(phoneButton);
        panel.add(saveButton);

        // Add the panel
        add(panel);

        // Let it shine!
        pack();
        setVisible(true);
    }

    /**
     * Save Address object in file chosen by the user.
     * @param addy Address object to be saved
     */
    public static void SaveStuff(Address addy)
    {
        // Where to save information?
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);

        if (status != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("No File Chosen");
            System.exit(0);
        }


        try {
            // Save information
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()));

            // Write Address in file
            oos.writeObject(addy);

            // Close file
            oos.close();
        }
        catch (FileNotFoundException e1) {
            JOptionPane.showMessageDialog(null, "The file does not exist.");
        }
        catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "I/O Error: " + e1.getMessage());
            e1.printStackTrace();
        }

    }

    /**
     * Creates action for when "Save!" button is pushed. It builds an Address
     * 		and then saves the object to a file chosen by the user.
     * @author CSIS110-29
     */
    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            // Pull info from GUI box
            String newName = nameButton.getText();
            String newStreet = streetButton.getText();
            String newCity = cityButton.getText();
            String newState = stateButton.getText();
            String newZip = zipButton.getText();
            String input = phoneButton.getText();
            double newPhone = Double.parseDouble(input);

            // Build Address
            Address addy = new Address(newName, newStreet, newCity, newState, newZip, newPhone);
            System.out.println(addy);

            // Save information
            SaveStuff(addy);

            // Tell about the fabulous author
            JOptionPane.showMessageDialog(null, "File Saved!!\n\nMade possible by the lovely Abi Pofahl.");

            // Close program
            System.exit(0);
        }


    }
}
