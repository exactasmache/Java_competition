class NumWaysDynamic {
	private static final int MOD = 1000000007;
	public int numWays(int steps, int arrLen) {
		if (arrLen == 1)
			return 1;
		if (arrLen > 1 && steps <= 2)
			return steps;

		final int maxPos = Math.min(steps / 2 + 1, arrLen);
		int[][] dp = new int[steps + 1][maxPos + 1];

		dp[1][0] = 1;
		for (int i = 1; i < maxPos; i++) {
			dp[i][i] = 1;
			dp[i + 1][i] = i + 1;
		}

		
		int tmp, limit, s, p;
		for (s = 2; s <= steps; s++) {
			limit = Math.min(maxPos-1, Math.min(steps - s, s));
			for (p = 0; p <= limit; p++) {
				tmp = (dp[s - 1][p] + dp[s - 1][p + 1]) % MOD;
				if (p>0)
					tmp += dp[s - 1][p - 1];
				
				dp[s][p] = tmp % MOD;
			}
		}

		return dp[steps][0]; // = dp[steps-1][0] + dp[steps-1][1]
	}
}


// dp[steps][0] = dp[s-1][0]              + dp[s-1][1]
// dp[steps][0] = dp[s-2][0] + dp[s-2][1] + dp[s-2][0] + dp[s-2][1] + dp[s-2][2]


//for (int s = 0; s <= steps; s++) {
//for (int p = 0; p <= maxPos; p++) {
//	System.out.print(dp[s][p] + " ");
//}
//System.out.println();
//}

//  p <= s
//  p <= steps -s
//  p < maxPos
