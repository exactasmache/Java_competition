/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * For example, two is written as II in Roman numeral, just two one's added together. 
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written 
 * as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right. However, 
 * the numeral for four is not IIII. Instead, the number four is written as IV. Because 
 * the one is before the five we subtract it making four. The same principle applies to 
 * the number nine, which is written as IX. There are six instances where subtraction 
 * is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within 
 * the range from 1 to 3999.
 */
import java.util.HashMap;

public class RomanToInteger {
	
	public int romanToInt(String s) {
        /* It assumes a valid Roman numeral */
        int n = s.length();
        int carry = 0, ret = 0, val = 0;
        char tmp;
        for (int i = 0; i < n; i++) {
            tmp = s.charAt(i);
            switch (tmp) {
                case 'I': 
                    val = 1;
                    break;
                case 'V': 
                    val = 5;
                    break;
                case 'X': 
                    val = 10;
                    break;
                case 'L': 
                    val = 50;
                    break;
                case 'C': 
                    val = 100;
                    break;
                case 'D': 
                    val = 500;
                    break;
                case 'M': 
                    val = 1000;
                    break;
            }
            if (carry > 0) {
                if (carry < val) {
                    ret += val - carry;
                    carry = 0;
                } else if (carry == val) {
                    ret += val + carry;
                    carry = 0;
                } else {
                    ret += carry;
                    carry = val;
                }
            } else {
                carry = val;
            }
        }
        
        return ret + carry;
    }
	
	public int romanToIntWithHashMap(String s) {
        /* It assumes a valid Roman numeral */
        int n = s.length();
        int carry = 0, ret = 0, val = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char tmp;
        for (int i = 0; i < n; i++) {
            tmp = s.charAt(i);
            val = map.get(tmp);
            if (carry > 0) {
                if (carry < val) {
                    ret += val - carry;
                    carry = 0;
                } else if (carry == val) {
                    ret += val + carry;
                    carry = 0;
                } else {
                    ret += carry;
                    carry = val;
                }
            } else {
                carry = val;
            }
        }
        
        return ret + carry;
    }
}