/*
 * You want to have desired white marbles. Currently you have none. All the marbles are in bags owned by your friend. 
 * Each of your friend's bags contains exactly bagSize marbles. Each of those marbles is either white (you want those) 
 * or black (you don't care about those).
 * 
 * Your friends has bags of four types:
 * 	Red bags are guaranteed to have no white marbles inside. There are noWhiteBags such bags.
 * 	Green bags are guaranteed to have no black marbles inside. There are noBlackBags such bags.
 * 	Blue bags are guaranteed to have some white marbles inside. There are someWhiteBags such bags.
 * 	Fuchsia bags are guaranteed to have some black marbles inside. There are someBlackBags such bags.
 * 
 * You are going to take marbles from your friend's bags, one at a time. More precisely, in each step you may choose 
 * any specific bag owned by your friend and take one random marble from that bag.
 * 
 * Return the smallest X such that you can be sure to reach your goal after taking X marbles (provided that you choose 
 * the bags in a smart way). If it's impossible to give such a guarantee, return -1 instead.
 */

public class BagsOfMarbles {

	public int removeFewest(int desired, int bagSize, int noWhiteBags, int noBlackBags, int someWhiteBags, int someBlackBags) {
		if (desired < 0 || bagSize < 0 || noBlackBags < 0)
			return -1;
			
		int fixed_amount = noBlackBags * bagSize;

		int left = desired - fixed_amount;
		if (left <= 0)
			return desired;
		
		if (someWhiteBags < 0)
			return -1;
			
		if (someWhiteBags - left >= 0)
			return fixed_amount + left * bagSize;
		
		return -1;
	}
}