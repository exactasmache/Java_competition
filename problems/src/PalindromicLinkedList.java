/*
 * Given a singly linked list, determine if it is a palindrome.
 */

public class PalindromicLinkedList {
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	 }
	
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        
        ListNode cursor = head;
        ListNode revList = new ListNode(cursor.val);
        ListNode tmp = null;
        // 1 -> -12 -> -12 -> 1
        while (cursor.next != null) {
            tmp = new ListNode(cursor.next.val);
            tmp.next = revList;
            revList = tmp;
            cursor = cursor.next;
        }
        while (head.next != null) {
            if (head.val != revList.val)
                return false;
            head = head.next;
            revList = revList.next;
        }
        return true;
    }
}