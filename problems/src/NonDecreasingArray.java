/*
 * Given an array with n integers, your task is to check if it could 
 * become non-decreasing by modifying at most 1 element.
 * 
 * We define an array is non-decreasing if array[i] <= array[i + 1] 
 * holds for every i (1 <= i < n).
 */
public class NonDecreasingArray {
	public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if (n <= 2)
            return true;
        
        // n >= 3
        int pen = Integer.MIN_VALUE;
        int last = nums[0];
        int act;
        int i;
        int changes = 0;
        // -inf, [5,10,0,0]
        //             ^
        //             i
        for (i = 1; i < n; i++) {
            act = nums[i];
            if (act < last) {
                if (changes > 0)
                    return false;
                
                if(act < pen)
                    nums[i] = last;    // act <- last
                else
                    nums[i-1] = act;    // last <- act
                
                changes += 1;
            }
            last = nums[i];
            pen = nums[i-1];
        }
        return true;
    }
}