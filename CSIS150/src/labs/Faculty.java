package labs;

/**
 * Stores information about a faculty member
 * Created by apofahl
 */
public class Faculty extends Employee {

    private String [ ] courses;

    /**
     * Builds a bare bones Faculty object
     */
    public Faculty() {
        super();
        courses = new String [0];
    }

    /**
     * Builds a Faculty object
     * @param name name of employee
     * @param salary salary of employee
     * @param courses course list
     */
    public Faculty(String name, int salary, String [] courses) {
        super(name, salary);
        this.courses = courses;
    }

    /**
     * Accesses name of employee with title
     * @return name
     */
    @Override
    public String getName() {
        String toReturn = "Professor " +super.getName();
        return toReturn;
    }

    /**
     * Accesses a copy of the instructor's course list
     * @return course list
     */
    public String[] getCourses() {
        return courses;
    }

    /**
     * Sets the instructor's course list
     * @param courses course list
     */
    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    /**
     *  Formats faculty info into usable form
     * @return Faculty information
     */
    @Override
    public String toString() {
        String output = super.toString()+ " and teaches";
        for (int dex = 0; dex < courses.length; dex++) {
            if (dex < (courses.length - 1)) {
                output += " " +courses [dex];
            } else {
                output += " and " +courses [dex];
            }
        }
        return output;
    }
}
