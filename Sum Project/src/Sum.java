package assignment2;
import java.util.ArrayList;
import java.util.Iterator;


public class Sum {

	public Sum() {
	}
	
	/**
	 * Adds all integers from 0 (non-inclusive) to the number passed through the method (inclusive)
	 * via an iterative process, using the Iterator class.
	 * @param num
	 * @return - the sum of all integers from 0 to num
	 */
	public static int sumOfPosIntsIterative(int num) {
		if(num < 1) {
			throw new IllegalArgumentException("This method does not support negative integers or zero.");
		}
		int sum = 0;
		// Creates an ArrayList of all the integers from 0 to num
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for(int i=1; i<num+1; i++) {
			numList.add(i);
		}
		// Creating an iterator for the ArrayList created previously
		Iterator<Integer> numIterator = numList.iterator();
		while(numIterator.hasNext()) {
			sum = sum + numIterator.next();
		}
		return sum;
	}
	
	/**
	 * Adds all integers from 0 (non-inclusive) to the number passed through the method (inclusive)
	 * via a recursive process, i.e. calling the method within itself.
	 * @param num
	 * @return - the sum of all integers between 0 and num
	 */
	public static int sumOfPosIntsRecursive(int num) {
		if(num > 0) {
			return num + sumOfPosIntsRecursive(num - 1);
		}
		return 0;
	}
	
	/**
	 * Adds all integers from 0 (non-inclusive) to the number passed through the method (inclusive)
	 * @param num
	 * @return - the sum of all integers from 0 to num
	 */
	public static int sumOfPosIntsDirect(int num) {
		if(num < 1) {
			throw new IllegalArgumentException("This method does not support negative integers or zero.");
		}
		return ( num * (num + 1) ) / 2;
	}
	
}
