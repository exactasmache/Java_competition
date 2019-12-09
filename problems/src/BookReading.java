import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
public class BookReading {

    	public static void main() throws FileNotFoundException {
	    	String file = "inputs/bookreading.txt";
	    	FileInputStream fis = new FileInputStream(file);
	        Scanner s = new Scanner(fis);

//		public static void main() {
//	        Scanner s = new Scanner(System.in);
	        int T, N, M, Q;
	        int pages;
	        T = s.nextInt();
	        for (int t = 1; t <= T; t++) {
	        	N = s.nextInt();
	        	M = s.nextInt();
	        	Q = s.nextInt();
	        	pages = 0;
	        	
	        	TreeSet<Integer> P = new TreeSet<Integer>();	// sorted torn pages
	        	int[] R = new int[Q];							// readers
	        	
	        	for (int p = 0; p < M; p++)
	        		P.add(s.nextInt());
	        	
	        	for (int r = 0; r < Q; r++)
	        		R[r] = s.nextInt();
	        	
	        	Arrays.sort(R);
	        	// For each reader 
	        	for (int r : R) {
	        		// I can optimize trying something like 
	        		// decomposing into prime numbers
	        		// At least pre-solving it for 2 and 3 ...
	        		int ifTotal = N/r;
	        		pages += ifTotal;
	        		for (int tornPage : P.tailSet(r, true)) {
	        			if(tornPage % r == 0)
	        				pages -= 1;
	        		}
	        	}
	        	System.out.println("Case #" + t + ": " + pages);
	        }
	        s.close();
	}
}
