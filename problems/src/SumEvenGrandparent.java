/*
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  
 * (A grandparent of a node is the parent of its parent, if it exists.)
 * 
 * If there are no nodes with an even-valued grandparent, return 0.
 * 
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 * 
 */

public class SumEvenGrandparent {
	public int sumEvenGrandparent(TreeNode root) {
        boolean egp = root.val % 2 == 0;
        return sumEvenGrandParent(root.left, egp) + sumEvenGrandParent(root.right, egp);
    }
    
    private int sumEvenGrandParent(TreeNode stree, boolean egp) {
        int ret = 0;
        if (stree == null)
            return ret;
        
        if (egp) {
            if (stree.left != null)
                ret += stree.left.val;
            if (stree.right != null)
                ret += stree.right.val;
        }
        egp = stree.val % 2 == 0;
        return ret + sumEvenGrandParent(stree.left, egp) + sumEvenGrandParent(stree.right, egp);
    }
}