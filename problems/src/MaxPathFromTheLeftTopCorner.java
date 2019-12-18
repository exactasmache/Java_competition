/*
 * You are given a matrix A consisting of N rows and M columns, where each cell contains a digit. 
 * Your task is to find a continuous sequence of neighbouring cells, starting in the top-left 
 * corner and ending in the bottom-right corner (going only down and right), that creates the 
 * biggest possible integer by concatenation of digits on the path. By neighbouring cells we 
 * mean cells that have exactly one common side.
 * 
 * Write a function:
 * 
 * class Solution { public String solution(int[][] A); }
 * 
 * that, given matrix A consisting of N rows and M columns, returns a string which represents 
 * the sequence of cells that we should pick to obtain the biggest possible integer.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 *   + N and M are integers within the range [1..1,000];
 *   + Each element of matrix A is an integer within the range [1..9].
 */
import java.math.BigInteger;


class MaxPathFromTheLeftTopCorner {
    private String method = "StringBuilder";
	private String solveLittleInstance(int[][] A, int m, int n) {
        int[] even = new int[n];      // 0, 2, 4, ...
        int[] odd = new int[n];       //   1, 3, 5, ...
        int c, r;
        int[] act, prev;
        
        even[0] = A[0][0];
        for (c = 1; c < n; c++)
            even[c] = even[c-1]*10 + A[0][c];       // A[0]: 9, 99, 997
        
        for (r = 1; r < m; r++) {
            if (r % 2 == 0) {   // r = 0, 2, 4,
                act = even;
                prev = odd;
            } else {
                act = odd;
                prev = even;
            }
            act[0] = prev[0]*10 + A[r][0];
            for (c = 1; c < n; c++)
                act[c] = Math.max(act[c-1], prev[c])*10 + A[r][c];       // A[1]: 9, 997|997, 9972|9972
        }
        if (m % 2 == 0)
            return String.valueOf(odd[n-1]);
        return String.valueOf(even[n-1]);
    }
    
    private String solveMediumInstance(int[][] A, int m, int n) {
        long[] even = new long[n];      // 0, 2, 4, ...
        long[] odd = new long[n];       //   1, 3, 5, ...
        int c, r;
        long[] act, prev;
        
        even[0] = A[0][0];
        for (c = 1; c < n; c++)
            even[c] = even[c-1]*10 + A[0][c];       // A[0]: 9, 99, 997
        
        for (r = 1; r < m; r++) {
            if (r % 2 == 0) {   // r = 0, 2, 4,
                act = even;
                prev = odd;
            } else {
                act = odd;
                prev = even;
            }
            act[0] = prev[0]*10 + A[r][0];
            for (c = 1; c < n; c++)
                act[c] = Math.max(act[c-1], prev[c])*10 + A[r][c];       // A[1]: 9, 997|997, 9972|9972
        }
        if (m % 2 == 0)
            return String.valueOf(odd[n-1]);
        return String.valueOf(even[n-1]);
    }
    
    
 // Complexity: O(2**(N+M)) or O(N*M*(N+M))
    private String solveHugeInstance(int[][] A, int m, int n) {
        StringBuilder[] even = new StringBuilder[n];
        StringBuilder[] odd = new StringBuilder[n];
        StringBuilder[] act, prev;
        int c, r;
        
        odd[0] = new StringBuilder(m);
        even[0] = new StringBuilder(m);
        even[0].append(A[0][0]);
        for (c = 1; c < n; c++) {
            even[c] = new StringBuilder(m+c);
            odd[c] = new StringBuilder(m+c);
            even[c].append(even[c-1]).append(A[0][c]);
        }
        
        for (r = 1; r < m; r++) {
            if (r % 2 == 0) {   // r = 0, 2, 4,
                act = even;
                prev = odd;
            } else {
                act = odd;
                prev = even;
            }
            act[0].setLength(0);
            act[0].append(prev[0]).append(A[r][0]);
            for (c = 1; c < n; c++) {
                act[c].setLength(0);
                act[c].append(greater(act[c-1], prev[c])).append(A[r][c]);
            }
        }
        
        if (m % 2 == 0)
            return odd[n-1].toString();
        return even[n-1].toString();
    }
    
    private String solveHugeInstancesWithBigInteger(int[][] A, int m, int n) {
        BigInteger ten = BigInteger.valueOf(10);
        
        BigInteger[] even = new BigInteger[n];      // 0, 2, 4, ...
        BigInteger[] odd = new BigInteger[n];       //   1, 3, 5, ...
        int c, r;
        BigInteger[] act, prev;
        
        even[0] = BigInteger.valueOf(A[0][0]);
        for (c = 1; c < n; c++)
            even[c] = even[c-1].multiply(ten).add(BigInteger.valueOf(A[0][c]));       // A[0]: 9, 99, 997
        
        for (r = 1; r < m; r++) {
            if (r % 2 == 0) {       // r = 0, 2, 4,
                act = even;
                prev = odd;
            } else {
                act = odd;
                prev = even;
            }
            act[0] = prev[0].multiply(ten).add(BigInteger.valueOf(A[r][0]));
            for (c = 1; c < n; c++) {
                if (act[c-1].compareTo(prev[c]) >= 0) {
                    act[c] = act[c-1].multiply(ten);
                } else {
                    act[c] = prev[c].multiply(ten);
                }
                act[c].add(BigInteger.valueOf(A[r][c]));
            }
        }
        if (m % 2 == 0)
            return String.valueOf(odd[n-1]);
        return String.valueOf(even[n-1]);
    }
    
    public String DynamicProgrammingSolution(int[][] A) {
    	int m = A.length;
        if (m <= 0)
            return "0";
        
        int n = A[0].length;
        
        if (n <= 0)
            return "0";
        
        if (m == 1) {
            StringBuilder str = new StringBuilder(n);
            for (int c = 0; c < n; c++)
                str.append(A[0][c]);
            
            return str.toString();
        }
        
        // MAX int val = 2 147 483 648 > 9 * [9]
        if (n + m -1 < 9 )
            return solveLittleInstance(A, m, n);
        
        // MAX long val = 9 223 372 036 854 775 807 > 9 * [18]
        if (n + m -1 < 19 )
            return solveMediumInstance(A, m, n);
        
        if (method == "StringBuilder")
        	return solveHugeInstance(A, m, n);
        else
        	return solveHugeInstancesWithBigInteger(A, m, n);
    }
    
    private StringBuilder greater(StringBuilder strA, StringBuilder strB) {
        int a = strA.length();
        int b = strB.length();
        if (a > b)
            return strA;
        else if (a < b)
            return strB;
        else {
            int diff;
            for (int i = 0; i< a; i++) {
                diff = strA.charAt(i) - strB.charAt(i);
                if (diff > 0)
                    return strA;
                else if (diff < 0)
                    return strB;
            }
        }
        return strA;
    }
    
    private StringBuilder solveSubmatrix(int[][] A, int r, int c, StringBuilder res) {
    	int n = A[0].length;
    	int m = A.length;
    	if (r == m-1) {
    		for (int j = c; j < n; j++)
    			res.append(A[r][j]);
    		return res;
    	}
    	if (c == n-1) {
    		for (int i = r; i < m; i++)
    			res.append(A[i][c]);
    		return res;
    	}
    	res.append(A[r][c]);
    	int r_elem = A[r][c+1];
    	int l_elem = A[r+1][c];
    	int sMSize = n-c+m-r;
    	if (r_elem > l_elem) {
    		return res.append(solveSubmatrix(A, r, c+1, new StringBuilder(sMSize)));
    	} else if (r_elem < l_elem){
    		return res.append(solveSubmatrix(A, r+1, c, new StringBuilder(sMSize)));
    	}
    	
    	return res.append(greater(
    	    solveSubmatrix(A, r+1, c, new StringBuilder(sMSize)), 
    	    solveSubmatrix(A, r, c+1, new StringBuilder(sMSize))
    	));
    }
    
    public String solution(int[][] A) {
    	int m = A.length;
        if (m <= 0)
            return "0";
        
        int n = A[0].length;
        
        if (n <= 0)
            return "0";
        
        if (m == 1) {
            StringBuilder str = new StringBuilder(n);
            for (int c = 0; c < n; c++)
                str.append(A[0][c]);
            
            return str.toString();
        }
        
        return solveSubmatrix(A, 0, 0, new StringBuilder(n+m-1)).toString();
    }
}
