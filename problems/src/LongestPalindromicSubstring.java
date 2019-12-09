/*
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 */

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
		// TODO: Improve this solution, it's too bad.
        int n = s.length();
        if (n <= 1)
            return s;
        String ret = ""+s.charAt(0);
        
        if (n == 2) {
            if (s.charAt(0) == s.charAt(1))
                return s;
            return ret;
        }
        // 01234567
        // ^^^ 
        //  c
        // l
        //   r 
        int c_id, l_id, r_id;
        char c, l, r;
        StringBuilder tmp = new StringBuilder(n);
        int bound = 2*n-1;   // - 2*c_id;
        int offset;
        for (c_id = 0; tmp.length() < bound-2*c_id; c_id++) {    
        	//TODO add a better bound: I don't need c == n-2 if ret > (n-c)*2-1
        	
            c = s.charAt(c_id);
            for (offset = 0; offset < 2; offset++) {
                l_id = c_id;
                r_id = c_id + offset;
                l = c;
                r = s.charAt(r_id);
                if (l != r)
                    break;
                
                tmp.setLength(0);
                tmp.insert(0, l);
                if (l_id-- != r_id++)
                    tmp.append(r);
                
                while (l_id >= 0 && r_id < n) {
                    l = s.charAt(l_id--);
                    r = s.charAt(r_id++);
                    if(l != r)
                        break;
                    tmp.insert(0, l);
                    tmp.append(r);
                }
                if (tmp.length() > ret.length())
                    ret = tmp.toString();
            }
        }
        return ret;
    }
}