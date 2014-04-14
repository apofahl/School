package labs;

/**
 * Tests the functionality of MyList
 * Created by apofahl
 */
public class Lab8 {

	public static void main(String[] args) {
        // Integer test
        System.out.println("************ Integer Test! ************");
		MyList<Integer> intList = new MyList();

		intList.add(8);
		intList.add(7);
		intList.add(837);
		intList.add(96);
		intList.add(12);

        System.out.println(intList.toString());
		System.out.println("The min is: " + intList.min());
        System.out.println("The max is: " + intList.max());
        System.out.println(intList.toString());

        // Double test
        System.out.println("\n************ Double Test! ************");
        MyList<Integer> dubList = new MyList();

        dubList.add(6.32);
        dubList.add(905.7);
        dubList.add(81.32);
        dubList.add(6.33);
        dubList.add(34.1);

        System.out.println(dubList.toString());
        System.out.println("The min is: " + dubList.min());
        System.out.println("The max is: " + dubList.max());
        System.out.println(dubList.toString());

//        // String test --- will not allow it (without the extends Number we can)
//        System.out.println("\n************ String Test! ************");
//        MyList<String> words = new MyList();
//
//        words.add("Chocolate");
//        words.add("purple");
//        words.add("62");
//        words.add("New toy");
//        words.add(" ");
//
//        System.out.println(words.toString());
//        System.out.println("The min is: " + words.min());
//        System.out.println("The max is: " + words.max());
//        System.out.println(words.toString());
	}

}
