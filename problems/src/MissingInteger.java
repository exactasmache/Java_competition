import java.util.Arrays;

/*
 * Description
 */

public class MissingInteger {
	public int solution(int[] A) {
		
		int n = A.length;
		if (n == 0)
			return 1;
		
		if (n == 1) {
			if (A[0]!=1)
				return 1;
			return 2;
		}
			
		// I can make a quicksort or mergesort while filtering the negative values 
		// and the repeated numbers. But it doesn't modify the complexity. 
		// It is O(n*log(n)) 
		Arrays.sort(A);		

		if (A[n - 1] <= 0)
			return 1;

		int i = 0;
		// Search the first positive.
		if (A[0] < 0 && A[n - 1] > 0)
			while (A[++i]<0) {}
		
		System.out.println(i);
		if (A[i++] >= 2)
			return 1;
		
		for (; i < n; i++) {
			if (A[i - 1] + 1 < A[i])
				return A[i - 1] + 1;
		}
		return A[n - 1] + 1;
	}
}