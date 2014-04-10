package labs;

import java.text.DecimalFormat;

/**
 * Stores information about an employee
 * Created by apofahl
 */
public class Employee implements Rules{
    private String name;
    private int salary;

    /**
     * Builds a bare bones Employee object
     */
    public Employee() {
        name = "";
        salary = 0;
    }

    /**
     * Builds an Employee object
     * @param name name of employee
     * @param salary salary of employee
     */
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Accesses name of employee
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Accesses salary of employee
     * @return salary
     */
    @Override
    public int getSalary() {
        return salary;
    }

    /**
     *  Formats employee info into usable form
     * @return Employee information
     */
    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("$X");
        String output = name+ " makes " +formatter.format(salary);
        return output;
    }
}
