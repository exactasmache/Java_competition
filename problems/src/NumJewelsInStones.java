/*
 * You're given strings J representing the types of stones 
 * that are jewels, and S representing the stones you have.  
 * Each character in S is a type of stone you have.  
 * You want to know how many of the stones you have are 
 * also jewels.
 * 
 * The letters in J are guaranteed distinct, and all 
 * characters in J and S are letters. Letters are case 
 * sensitive, so "a" is considered a different type of 
 * stone from "A".
 * 
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */

public class NumJewelsInStones {
	public int numJewelsInStones(String J, String S) {
        int m = J.length();
        int n = S.length();
        
        if (m == 0 || n == 0)
            return 0;
        
        boolean[] js = new boolean['z'-'A'+1];
        int j;
        for (j = 0; j < m; j++)
            js[J.charAt(j)-'A'] = true;
        
        int ret = 0;
        for (j = 0; j < n; j++) {
            if(js[S.charAt(j)-'A'])
                ret++;
        }
        
        return ret;
    }
}