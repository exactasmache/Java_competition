class NumWaysRecursive {
    private long recursiveMove(int pos, int moved, int action, int steps, int arrLen) {
    	if (arrLen - pos > 1 && steps <= 2)
            return steps;
        
        pos += action;
        moved += 1;
        
        long ret = 0;
        
        if (pos >= arrLen || pos < 0) {
            return ret;
        }
        
        if (steps > moved) {
            ret += recursiveMove(pos, moved, 0, steps, arrLen);
            
            if (pos > 0) {
            	if (pos == steps-moved)
            		ret +=1;
            	else
            		ret += recursiveMove(pos, moved, -1, steps, arrLen);
            }
            if (pos < arrLen && steps-moved > pos)
                ret += recursiveMove(pos, moved, 1, steps, arrLen);
        }
        if (pos == 0 && moved == steps) {
        	return ret + 1;
        }
        return ret;
    }
    
    public int numWays(int steps, int arrLen) {	// 8, 1    [a]
        // steps = 1, arrLen = n => ret = |{[s]}|
        // steps = 2, arrLen = n => ret = |{[s,s],[r,l]}|
        if (arrLen > 1 && steps <= 2)
            return steps;
        
        // boolean carry = (steps % 2 == 0) ? false : true;
        // action in [-1,0,1]
        int pos = 0, moved = 0, nullaction = 0, rightaction = 1;
        long ret = recursiveMove(pos, moved, nullaction, steps, arrLen);
        ret += recursiveMove(pos, moved, rightaction, steps, arrLen);
        return (int) (ret % 1000000007);
    }
}