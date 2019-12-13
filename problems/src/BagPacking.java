/*
 * Bob's exams are over and he wants to go home on his summer vacation. 
 * Bob has some bags and wants to send them home. You are given sizes 
 * of the bags in int[] bagsizes.
 * 
 * A bag of size x can fit inside a bag of size y, if y is strictly 
 * greater than x. The courier service charges based on the number of 
 * bags, so it is in Bob's best interest to nest bags inside of each 
 * other as efficiently as possible. Note that only a single bag of size 
 * less than y can fit inside a bag of size y. However, the smaller bag 
 * may have a still smaller bag inside of it, and so on.
 * 
 * Return the minimum number of bags Bob must pay for, assuming he packs 
 * them inside each other optimally.
 */

public class BagPacking {
	public int minPay(int[] bagsizes) {
		int n = bagsizes.length;
		if (n <= 1)
			return n;
		
		int[] amounts = new int[101];
		int i, e, max = 1;
		for (i = 0; i < n; i++) {
			e = bagsizes[i];
			amounts[e]+= 1;
			max = Math.max(amounts[e], max);
		}
		return max;
	}
}