import java.util.HashSet;

/*
 * Given an array of integers, find out whether there are two distinct indices i and j 
 * in the array such that the absolute difference between nums[i] and nums[j] is at 
 * most t and the absolute difference between i and j is at most k.
 */

public class ContainsNearbyAlmostDuplicate {
	private boolean containsNearDuplicate(int[] nums, int k) {
        int bound, i, ival, kval;
        HashSet<Integer> set = new HashSet<Integer>();
        
        bound = Math.min(nums.length-1, k);
        for (i = 0; i <= bound; i++) {
            ival = nums[i];
            if (set.contains(ival))
                return true;
            else
                set.add(ival);
        }
        
        bound = nums.length - k - 1;
        for (i = 0; i < bound ; i++) {
            ival = nums[i];
            set.remove(ival);
            kval = nums[i+k+1];
            if (set.contains(kval)) {
                return true;
            } else
                set.add(kval);
            
        }
        return false;
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length <= 1 || k == 0)
            return false;
        
        int n = nums.length;
        if(t == 0)
            return containsNearDuplicate(nums, k);
        
        int l = 0;
        int r = 0;
        while(l < n-1){
            if(r != l && Math.abs((long) nums[l] - (long) nums[r]) <= t){
                return true;
            }
            if(r - l == k || r == n - 1){
                l++;
                r = l+1;
            }
            else {
                r++;
            }
        }
        return false;
    }
}