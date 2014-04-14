package labs;

import java.util.ArrayList;
import java.util.Collections;

public class MyList<T> extends ArrayList{

	public MyList() {
		
	}
	
	public T min() {
		Collections.sort(this);
		
		return (T) (this.get(0));
	}
	
	public T max() {
		Collections.sort(this);
		
		return (T) (this.get(this.size()));
	}
}
