/*
 * Given an integer number n, return the difference between 
 * the product of its digits and the sum of its digits.
 * 
 * 1 <= n <= 10^5
 */

public class SubstractProdAndSum {
	public int subtractProductAndSum(int n) {
        int sum = 0;
        int prd = 1;
        int r;
        
        while(n > 0) {
            r = n % 10;
            n = n/10;
            sum += r;
            prd *= r;
        }

        return prd - sum;
    }
	
	public int subtractProductAndSumIfLong(int n) {
		/* If n is a longer number and it's 
		 * probable to have a zero. */
        int sum = 0;
        int prd = 1;
        
        // 10^5 = 100.000 > 9*9*9*9*9 < "int"
        // 234
        int r;
        while(n > 0) {
            r = n % 10;
            n = n/10;
            sum += r;
            prd *= r;
            if (r == 0) break;
        }
        
        while(n > 0) {
            r = n % 10;
            n = n/10;
            sum += r;
        }
        
        return prd - sum;
    }
}