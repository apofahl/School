package littleGuys;

/**
 * Created by apofahl
 */
public class Problem14 {

//    The following iterative sequence is defined for the set of positive integers:
//
//    n → n/2 (n is even)
//    n → 3n + 1 (n is odd)
//
//    Using the rule above and starting with 13, we generate the following sequence:
//
//            13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//    It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//    Which starting number, under one million, produces the longest chain?
//
//    NOTE: Once the chain starts the terms are allowed to go above one million.

    public static int tryNext(int current) {
        int count = 0;

        while (current >= 1) {
//			System.out.print(current + " ");  // for debugging
            if (current == 1) {
                count ++;
                break;
            }
            else if (current%2 == 0) {
                current = current / 2;
            } else {
                current = (current * 3) + 1;
            }
            count ++;
        }

//		System.out.println("\nThe chain is " +count+ " terms long."); // for debugging
        return count;
    }

    public static void main(String args[]) {
        int current = 13;
        int top = 0;
        int answer = 13;

        while (current < 1000000) {
            if (tryNext(current) > top) {
                top = tryNext(current);
                answer = current;
            }

            current++;
        }

        System.out.println("\nThe answer is " +answer+ " with " +top+ " terms.");
    }
}
