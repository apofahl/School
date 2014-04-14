package labs;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Builds an list with a generic parameter
 * @param <T> variable type being used
 *
 * Created by apofahl
 */
public class MyList<T extends Number> extends ArrayList{

    /**
     * Finds minimum value of the list
     * @return minimum value
     */
	public T min() {
		Collections.sort(this);
		return (T) (this.get(0));
	}

    /**
     * Finds maximum value of the list
     * @return maximum value
     */
	public T max() {
		Collections.sort(this);
		return (T) (this.get(this.size() - 1));
	}

    public String toString() {
        String output = "This list contains: ";

        for (int dex = 0; dex < this.size(); dex++) {
            output += this.get(dex)+ " ";
        }

        return output;
    }

}
