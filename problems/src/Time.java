public class Time {
	public String whatTime(int seconds) {
		int H = 0, M = 0, S = seconds;
		M = S/60;
		H = M/60;
		M = M - H*60;
		S = S - H*60*60 - M*60;
		return H + ":" + M + ":" + S;
	}
}