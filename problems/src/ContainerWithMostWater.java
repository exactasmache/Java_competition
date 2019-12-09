/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point 
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
 * forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 */

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		// Linear solution
        int n = height.length;
        int ret = 0;
        int l, r;
        int l_id = 0, r_id = n-1;
        int vol;
        while (l_id < r_id) {
            l = height[l_id];
            r = height[r_id];
            if (l <= r)
                vol =  l * (r_id - l_id++);
            else
                vol = r  * (r_id-- -l_id);
            
            if (vol >= ret)
                ret = vol;
        }
        return ret;
    }
	
	public int maxArea_On2(int[] height) {
		// Quadratic solution
        int l_id, l, r_id, r;
        int n = height.length;
        int ret = 0;
        int vol;
        for (l_id = 0; l_id < n-1; l_id++) {   // Check for a better bound
            l = height[l_id];
            for (r_id = 1; r_id < n; r_id++) {
                r = height[r_id];
                vol = Math.min(l,r) * (r_id-l_id);
                if (vol >= ret)
                    ret = vol;
            }
        }
        return ret;
    }
}