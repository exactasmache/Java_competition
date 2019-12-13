/*
 * Elly has N integers, given in the int[] numbers. She also has N-1 signs. 
 * Each of the signs is either a plus ('+') or a minus ('-'). The girl has 
 * numPluses plus signs and numMinuses minus signs. It is guaranteed that 
 * numPluses + numMinuses equals N-1.
 * 
 * Elly wants to place her numbers in a sequence and then put a single sign 
 * between each pair of integers. She can put the signs and the numbers in 
 * any order. Now the girl wonders what is the maximal value she can get after 
 * putting the signs and evaluating the expression. Help her by finding the 
 * resulting value.
 */

import java.util.Arrays;

public class EllysExpression {
	public int getMax(int[] numbers, int numPluses, int numMinuses) {
		if (numbers == null) 
			return 0;
		
		int n = numbers.length;
		
		if (n == 0)
			return 0;
		
		int sum = 0, i;
		if (numMinuses == 0) {
			for (i = 0 ; i < n ; i++)
				sum += numbers[i];
			return sum;
		}
		
		Arrays.sort(numbers);	// [-13,-12,-10,0,1,3,5,7,8,18,1000], [12], []
		
		// |numbers|>0, numMinuses > 0
		sum = numbers[n-1];
		for (i = n-2; i > n-2 -numPluses ; i--)
			sum += numbers[i];
		for (; i >=0; i--)
			sum -= numbers[i];
		return sum;
	}
}