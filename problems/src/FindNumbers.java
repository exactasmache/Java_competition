/*
 * Given an array nums of integers, return how many of them 
 * contain an even number of digits.
 */

public class FindNumbers {
	public int findNumbers(int[] nums) {
        int ret = 0;
        boolean sum;
        for (int i = 0; i < nums.length; i++) {
            int digits = nums[i];
            sum = true;
            while (digits > 0) {
                digits = digits/10;
                sum = !sum;
            }
            if (sum) ret++;
        }
        return ret;
    }
}

//This is a better solution. A geniality of another guy.
//public int findNumbers(int[] nums) {
//  int result = 0;
//  for (int i = 0; i < nums.length; i++) {
//      if (((int) Math.log10(nums[i]) + 1) % 2 == 0)
//          result++;
//  }
//  return result;
//}