/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0) return head;
        int num = getSize(head);
        if(num == 0) return head;
        k = k % num;
        return shift(head, k);            
    }
    
    private ListNode shift(ListNode head, int k){
        ListNode rightPointer = getRightNode(head, k);
        ListNode leftPointer = head;
        
        while(rightPointer.next != null){
            leftPointer = leftPointer.next;
            rightPointer = rightPointer.next;
        }
        // 1) save ref for new head.
        ListNode newHead = leftPointer.next;
        if(newHead == null){
            return head;
        }
        // 2) rightPointer.next = head.
        rightPointer.next = head;
        
        // 3) prevent cyclic list.
        leftPointer.next = null;
        
        return newHead;
        
    }
    
    private ListNode getRightNode(ListNode node, int k){
        while(k > 0 && node != null){
            node = node.next;
            k--;
        }
        return node;
    }
    
    private int getSize(ListNode node){
        int result = 0;
        ListNode ref = node;
        while(ref != null){
            ref = ref.next;
            result++;
        }
        return result;
    }
}
