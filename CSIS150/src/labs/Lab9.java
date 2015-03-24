package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Lab9 {
	
	static ArrayList <String> goodWords;
	
	/**
	 * Checks iteratively to see if a word is a palindrome
	 * @param word to be checked
	 * @return whether or not it is a palindrome
	 */
	public static boolean palindromeIterative(String word) {
		boolean check = false;
		
		for (int dex = 0; dex < word.length(); dex++) {
			if (word.charAt(dex) == word.charAt((word.length() - dex) - 1)) {
				check = true;
			} else {
				check = false;
				break;
			}
		}
		
		return check;
	}
	
	/**
	 * Checks recursively to see if a word is a palindrome
	 * @param word to be checked
	 * @return whether or not it is a palindrome
	 */
	public static boolean palindrome(String word) {
		boolean check = false;
		
		if (word.length() % 2 == 0) { // for even
			if (word.length() == 2 && word.charAt(0) == word.charAt(word.length() - 1)) {
				check = true;
			} else if (word.charAt(0) == word.charAt(word.length() - 1)) {
				check = palindrome(word.substring(1, (word.length() - 1)));
			} else {
				check = false;
			}
		} else { // for odd
			if (word.length() == 1) {
				check = true;
			} else if (word.charAt(0) == word.charAt(word.length() - 1)) {
				check = palindrome(word.substring(1, (word.length() - 1)));
			} else {
				check = false;
			}
			
		}
		
		return check;
	}
	
	/**
	 * Builds array with no nulls and sorts the words
	 * @param words to be sorted
	 * @param count number of good words
	 * @return words after sorting
	 */
	public static String [ ] sortGoodWords(String [ ] words, int count) {
		String [ ] goodWords = new String [count];
		
		for (int dex = 0; dex < goodWords.length; dex++) {
			goodWords [dex] = words [dex];
			System.out.println(goodWords [dex]);
		}
		
		Arrays.sort(goodWords);
		
		return goodWords;
	}
	
	/**
	 * Checks to make sure the word is a palindrome. It checks both iteratively and recursively
	 */
	public static void checkWords() {
		//Set up variables
		boolean check1 = false;
		boolean check2 = false;
		int wordCount = 0;
		int trueCount = 0;
		
		try {
			// Set up scanner
			File file = new File("palindrome.txt");
			Scanner fRead = new Scanner(file);
			
			// Word count
			while (fRead.hasNext()) {
				String word = fRead.next();
				wordCount++;
			}
			
			// Set up good words array
			goodWords = new ArrayList();
			fRead = new Scanner(file);
		
			// Read words in
			while (fRead.hasNext()) {
				String word = fRead.nextLine();     // read in word
				
				// Check it for a palindrome
				check1 = palindromeIterative(word);
				check2 = palindrome(word);
			
				if (check1 == true && check2 == true) {
					JOptionPane.showMessageDialog(null, word+ " is a palindrome. Will write to file!");
					goodWords.add(word); // Could use a string and StringTokenizer too
					trueCount++;
				}
				else {
					JOptionPane.showMessageDialog(null, word+ " is not a palindrome. Next!");
				}
			}
			
			// Set up output file
			PrintWriter file2 = new PrintWriter("goodWords.txt");
			Collections.sort(goodWords);
			for (int dex = 0; dex < goodWords.size(); dex++) {
				file2.println(goodWords.get(dex));
				System.out.println(goodWords.get(dex));
			}
	
			fRead.close(); // close scanner
			file2.close(); // close output file
			
			JOptionPane.showMessageDialog(null, "Well, " +trueCount+ " out of " +wordCount+ " words were palindromes!");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "The file does not exist.");
		}
		
	}
	
	/**
	 * Looks for a word chosen by user in list of palindromes. 
	 * *** method based of one from class. 
	 */
	public static void lookFor() {
		int lower = 0, upper = goodWords.size()-1;
		boolean found = false;
		String search = JOptionPane.showInputDialog("What word would you like to search for?");
		while (!found && lower <= upper) {
			int middle = (lower + upper)/2;
			if (goodWords.get(middle).equalsIgnoreCase(search)) {
				found = true;
			} else if (goodWords.get(middle).compareToIgnoreCase(search) > 0) { 
				upper = middle-1;
			} else { 
				lower = middle +1;
			}
		}
		
		if (found) {
			System.out.println("Your word was found!");
		} else {
			System.out.println("Your word was not found.");
		}
	}
	
	/**
	 * Title: Palindrome
	 * 
	 * Algorithm:
	 *	1. Scan in the word
	 *	2. Put word into array form
	 *	3. Check word for palindrome recursively
	 *	4. Check word for palindrome iteratively
	 *	5. Report back to user
	 *
	 * Author: Abi Pofahl
	 * @param args
	 */
		public static void main(String[] args) {
				checkWords();
	//			lookFor();
		}
}