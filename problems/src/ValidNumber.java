/*
 * Given two strings A and B of lowercase letters, return true if 
 * and only if we can swap two letters in A so that the result equals B.
 * 
 * Runtime: 1 ms, faster than 98.08% of Java online submissions for Buddy Strings.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Buddy Strings.
 */
public class ValidNumber {
	public boolean isNumber(String s) {
        if (s == null || s.length() == 0) 
            return false;
        
        String regex = "\\s*(-|\\+)?"                   // +/-
        		+ "(([0-9]+\\.?[0-9]*)|(\\.[0-9]+))"    // .0, .90, 2.15315, 4.
                + "(e(-|\\+)?[0-9]+)?\\s*";             // 1e1, 12e-45, 12.e-32, 12.4560e+3
        return s.matches(regex);
    }
}