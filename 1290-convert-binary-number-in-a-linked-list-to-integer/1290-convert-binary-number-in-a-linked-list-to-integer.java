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
    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        int count = 0;
        while(node != null){
            node = node.next;
            count++;
        }
        int sum = 0;
        node = head;
        for(int i = count-1; i >= 0 ; i--){
            if(node.val == 0) node = node.next;
            else{
                sum += Math.pow(2, i);
                node = node.next;
            }
        }
        return sum;
    }
}