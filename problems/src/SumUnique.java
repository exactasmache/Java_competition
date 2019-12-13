/*
 * You are given a list of int values. We wish to find the sum of these values, 
 * however we want to ignore duplicates. Return the sum of the unique values in the list.
 */

public class SumUnique {
	public int getSum(int[] values) {
		if(values == null)
			return 0;
		int n = values.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return values[0];
		
		boolean[] found = new boolean[101];
		int i, e, sum = 0;
		for (i = 0; i < n; i++) {
			e = values[i];
			if(!found[e]) {
				sum+=e;
				found[e] = true;
			}
		}
		return sum;
	}
}