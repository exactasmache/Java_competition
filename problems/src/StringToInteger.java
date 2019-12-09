/*
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until the first non-whitespace
 * character is found. Then, starting from this character, takes an optional initial plus or minus sign 
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are 
 * ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such 
 * sequence exists because either str is empty or it contains only whitespace characters, no conversion is 
 * performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed 
 * integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, 
 * INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 */
public class StringToInteger {
	private final int MAX = Integer.MAX_VALUE;
    private final int MIN = Integer.MIN_VALUE;
    
    public int myAtoi(String str) {
        int n = str.length(), i = 0;
        
        // jumping white spaces
        while (i < n && str.charAt(i) == ' ')
            i++;
        
        if (i == n)
            return 0;
        
        int ret = 1;
        char tmp = str.charAt(i);
            
        if (tmp == '-') {
            ret = -1;
            i++;
        } else if (tmp == '+')
            i++;

        // jumping zero characters. TODO: Check if they do it
        while (i < n && str.charAt(i) == 48)
            i++;
        
        if (i == n || str.charAt(i) < 48 || str.charAt(i) > 57)
            return 0;
        
        long tmp_ret = 0;
        while (i < n) {
            tmp = str.charAt(i++);
            if (tmp < 48 || tmp > 57 || tmp_ret > MAX)
                break;
            tmp_ret = tmp_ret*10 + (tmp-48);
        }
        
        tmp_ret *= ret;
        if (tmp_ret >= MAX) {
            return MAX;
        }
        if (tmp_ret <= MIN) {
            return MIN;
        }
        return (int) tmp_ret;
    }
}