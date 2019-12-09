/*
 * Determine whether an integer is a palindrome. An integer 
 * is a palindrome when it reads the same backward as forward.
 * 
 * Coud you solve it without converting the integer to a string?
 */

public class PalindromeNumber {
	
	public boolean isPalindrome(int x) {
        if (x % 10 == 0 && x!= 0)
            return false;
            
        int rev_x = 0;
        while (x > rev_x) {
            rev_x = rev_x * 10 + x % 10;
            x = x/10;
        }
        return x == rev_x || x == rev_x/10;
    }
}