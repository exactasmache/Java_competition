/*
 * Given an array A consisting of n integers. You have to tell whether you can make all 
 * of them equal by applying following operation as many times as you want. 
 * 	
 * 	+ Choose any number in the array and replace it by any non trivial divisor of it.
 * 
 * Return "yes" or "no" according to the situation.
 */

import java.util.*;

public class EquateNumbers {
	public String canMakeEqual(int[] A) {
		if (A == null || A.length <= 1)
			return "yes";
		
		int lower = A[0], n = A.length;
		for (int i = 0; i < n ; i++)
			lower = Math.min(lower, A[i]);
				
		if (lower == 0) 
			return "no";
		if (lower == 1)
			return "yes";
		
		HashSet<Integer> divs = new HashSet<Integer>();	
		HashSet<Integer> toRemove = new HashSet<Integer>();
		
		int remain = lower;
		int i = 2;
		while (remain != 1) {
			if(remain % i == 0) {
				divs.add(i);
				remain = remain / i;
			} else {
				i++;
			}
		}
		
		int e;
		for (i = 0; i < n; i++) {
			e = A[i];
			if(e % lower == 0)
				continue;
			
			for (int div : divs) {
				if (e % div != 0)
					toRemove.add(div);
			}
			for (int div : toRemove)
				divs.remove(div);
			toRemove.clear();
			
		
			if (divs.size() == 0)
				return "no";
		}
		return "yes";
	}
}