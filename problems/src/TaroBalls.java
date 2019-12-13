/*
 * Cat Taro has a box with exactly R red balls and B blue balls inside. 
 * He and his friend decided to play the following game.
 * 
 * Players take alternate turns, Taro goes first. In each turn, the current 
 * player should take exactly one ball from the box. The only constraint is 
 * that the color of the ball he took must be different from the color of the 
 * previously taken ball (i.e., the one taken by the opponent in the immediately 
 * preceding turn). (Note that in the first turn Taro can take a ball of any 
 * color.) The player that cannot take a valid turn loses. Both players play 
 * optimally.
 * 
 * You are given the two ints R and B. Return "Taro" if Taro wins the game and 
 * "Friend" otherwise (quotes for clarity)
 */

public class TaroBalls {
	
	public String getWinner(int R, int B) {
		
		return (R != B) ? "Taro" : "Friend";
		
	}
}