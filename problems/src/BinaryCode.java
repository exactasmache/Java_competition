public class BinaryCode {

	private int intAt(String m, int i) {
		return Character.getNumericValue(m.charAt(i));
	}

	public String[] decode(String Q) {
		String[] ret = { "NONE", "NONE" };

		int Q1 = intAt(Q, 0);
		int Qn = intAt(Q, Q.length() - 1);

		if (Q1 > 2 || Qn > 2)
			return ret;

		// Assuming P[0-1] = P[0] = 0:

		for (int j = 0; j < 2; j++) {
			String P = String.valueOf(j);

			Boolean isOk = true;
			int pi1, p;
			for (int i = 0; i < Q.length() - 1; i++) {
				// Q = "123210122";
				// P = "011100011";
				if (i > 0)
					p = intAt(P, i - 1);
				else
					p = 0;

				pi1 = intAt(Q, i) - p - intAt(P, i);
				P += String.valueOf(pi1);
				if (pi1 < 0 || pi1 > 1) {
					isOk = false;
					break;
				}
			}
			if (isOk) {
				ret[j] = P;
			}
		}
		return ret;
	}
}