import java.util.Arrays;

public class DeleteArrays {

//	returns [ remaining, cost ]
//	I receive 3 arrays, 3 costs, an accumulated cost. 
//	If there are at least 2 non-empty, I apply recursively x, y and z, selecting the heaviest elements of the arrays.
//	and my cost is going to be cost + min(doRemove(i)[cost]) for i= x, y, z. 

	private long[] doRemove(int[] A, int[] B, int[] C, long x, long y, long z, long cost) {

		long costx = 0, costy = 0, costz = 0, remx = Long.MAX_VALUE, remy = Long.MAX_VALUE, remz = Long.MAX_VALUE;
		int a = A.length, b = B.length, c = C.length;

		if (a == 0 && b == 0 || a == 0 && c == 0 || b == 0 && c == 0) {
			long[] ret = { Arrays.stream(A).sum() + Arrays.stream(B).sum() + Arrays.stream(C).sum(), cost };
			return ret;
		}

		// x
		if (a > 0 && b > 0) {
			costx = x + A[a - 1] + B[b - 1];
			long[] ret = doRemove(Arrays.copyOf(A, a - 1), Arrays.copyOf(B, b - 1), Arrays.copyOf(C, c), x, y, z,
					costx + cost);
			remx = ret[0];
			costx = ret[1];
		}

		// y
		if (c > 0 && b > 0) {
			costy = y + C[c - 1] + B[b - 1];
			long[] ret = doRemove(Arrays.copyOf(A, a), Arrays.copyOf(B, b - 1), Arrays.copyOf(C, c - 1), x, y, z,
					costy + cost);
			remy = ret[0];
			costy = ret[1];
		}

		// z
		if (a > 0 && c > 0) {
			costz = z + A[a - 1] + C[c - 1];
			long[] ret = doRemove(Arrays.copyOf(A, a - 1), Arrays.copyOf(B, b), Arrays.copyOf(C, c - 1), x, y, z,
					costz + cost);
			remz = ret[0];
			costz = ret[1];
		}

//		int i;
//		System.out.println("Initial cost: " + cost);
//		System.out.println("x cost: " + costx + " ;    x remainder: " + remx);
//		System.out.println("y cost: " + costy + " ;    y remainder: " + remy);
//		System.out.println("z cost: " + costz + " ;    z remainder: " + remz);
//		
//		for (i = 0; i < a; i++)
//			System.out.print(A[i] + " ");
//		System.out.println();
//		for (i = 0; i < b; i++)
//			System.out.print(B[i] + " ");
//		System.out.println();
//		for (i = 0; i < c; i++)
//			System.out.print(C[i] + " ");
//		System.out.println();

		// It won't cover the equality cases.
		if (remx <= remy && remx <= remz) {
			long[] ret = { remx, costx };
			return ret;
		} else if (remy <= remx && remy <= remz) {
			long[] ret = { remy, costy };
			return ret;
		} else if (remz <= remx && remz <= remy) {
			long[] ret = { remz, costz };
			return ret;
		}

		return null;
	}

	public long[] doDelete(int a, int b, int c, long x, long y, long z) {
		long[] ret = { 0, 0 };
		int[] A = new int[a];
		int[] B = new int[b];
		int[] C = new int[c];
		int i;

		A[0] = 33;
		A[1] = 42;

		for (i = 2; i < a; i++) {
			A[i] = (5 * A[i - 1] + 7 * A[i - 2]) % 1000000007 + 1;
		}

		B[0] = 13;
		for (i = 1; i < b; i++) {
			B[i] = (11 * B[i - 1]) % 1000000007 + 1;
		}

		C[0] = 7;
		C[1] = 2;
		for (i = 2; i < c; i++) {
			C[i] = (5 * C[i - 1] + 7 * C[i - 2]) % 1000000007 + 1;
		}

		// ascending order [1,2,3,4...]
		Arrays.sort(A);
		Arrays.sort(B);
		Arrays.sort(C);

		if (a > b + c) {
			// one or more of A will be left over.
			int[] reduced_A = Arrays.copyOfRange(A, a - b - c - 2, a - 1);
			ret = doRemove(reduced_A, B, C, x, y, z, 0);
			// returned remaining + removed from A.
			for (i = 0; i < b + c - 1; i++) {
				ret[0] += (long) A[i];
			}
		} else if (b > a + c) {
			// one or more of A will be left over.
			int[] reduced_B = Arrays.copyOfRange(B, b - a - c - 2, b - 1);
			ret = doRemove(A, reduced_B, C, x, y, z, 0);
			// returned remaining + removed from A.
			for (i = 0; i < a + c - 1; i++) {
				ret[0] += (long) B[i];
			}
		} else if (c > b + a) {
			// one or more of A will be left over.
			int[] reduced_C = Arrays.copyOfRange(C, c - b - a - 2, c - 1);
			ret = doRemove(A, B, reduced_C, x, y, z, 0);
			// returned remaining + removed from A.
			for (i = 0; i < b + a - 1; i++) {
				ret[0] += (long) C[i];
			}
		} else {
			ret = doRemove(A, B, C, x, y, z, 0);
		}

		return ret;
	}
}

//Thinking possible prunes...
//if (a >= b + c) {
//	// one or more of A will be left over.
//	// Pick that amount and make a little math to return the answer.
//} else if (b >= a + c) {
//	// one or more of B will be left over.
//	// Pick that amount and make a little math to return the answer.
//} else if (c >= b + a) {
//	// one or more of C will be left over.
//	// Pick that amount and make a little math to return the answer.
//}
//
//else if ((a + b + c) % 2 == 0) {
//	// no one will be left over. 
//	
//}