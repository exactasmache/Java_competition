/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given 
 * number of rows like this: (you may want to display this pattern in a 
 * fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given 
 * a number of rows:

 * string convert(string s, int numRows);
 */
public class ZigZagDecreasing {
	public String convert(String s, int numRows) {
		// Using a StringBuilder with fixed size.
        int n = s.length();
        if (numRows <= 1 || numRows >= n)
            return s;
            
        StringBuilder ret = new StringBuilder(n);
        int mod = numRows*2 - 2;
        int d_id;
        for(int i = 0; i < numRows; i++) {
            for (int k = i; k < n; k+=mod) {
                ret.append(s.charAt(k));
                
                d_id = k+mod-2*i;
                if (d_id >= n)
                    break;
                
                if (i != 0 && i != numRows-1)
                    ret.append(s.charAt(d_id));
            }
        }
        return ret.toString();
    }
	
	
	public String convertUsingString(String s, int numRows) {
        int n = s.length();
        if (numRows <= 1 || numRows >= n)
            return s;
            
        
        String ret = "";
        int mod = numRows*2 - 2;
        						// i + mod-(2i) + k.mod --> (k+1)mod - i
     
        // 0     8        16    // mod, 2mod, ...
        // 1   7 9     15 17    // mod-1, 2mod-1
        // 2  6 10   14   18    // mod-2, 2mod-2
        // 3 5  11 13     
        // 4    12
        
        int c_id, d_id;
        for(int i = 0; i < numRows; i++) {    // i = 1
            for (int k = 0; ; k++) {            // k = 1
                c_id = i+ k*mod;                // c_id = 9
                
                if (c_id >= n)
                    break;
                ret += s.charAt(c_id);          // add the 'column' char
                
                d_id = (k+1)*mod -i;            // d_id = 15
                if (d_id >= n)
                    break;
                
                if (d_id != c_id && d_id != c_id+mod )
                    ret += s.charAt(d_id);      // add the 'diagonal' char
            }
        }
        return ret;
    }
}