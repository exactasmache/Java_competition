/*
 * Given two strings A and B of lowercase letters, return true if 
 * and only if we can swap two letters in A so that the result equals B.
 * 
 * Runtime: 1 ms, faster than 98.08% of Java online submissions for Buddy Strings.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Buddy Strings.
 */
public class BuddyStrings {
	public boolean buddyStrings(String A, String B) {
        int n = A.length();
        if (n != B.length())
            return false;
        
        if (n == 0) 
            return false;
        
        int[] amount_A = new int[26];  //amount[0] = 'a' : char 97
        char a, b;
        char pend_a = ' ', pend_b = ' ';
        boolean pair = false;
        boolean diff = false;
        boolean swapped = false;
        for (int i = 0; i < n; i++) {
            a = A.charAt(i);
            b = B.charAt(i);
            if (a != b) {
                if (swapped) return false;
                
                diff = true;
                if (pend_a != ' ') {
                    if (pend_b == a && pend_a == b)
                        swapped = true;
                    else
                        return false;
                } else {
                    pend_a = a;
                    pend_b = b;
                }
            } else if (!pair && !diff){
                amount_A[a-97] += 1;
                if (amount_A[a-97] == 2)
                    pair = true;
            }
        }
        return (!diff && pair) || swapped;
    }
}