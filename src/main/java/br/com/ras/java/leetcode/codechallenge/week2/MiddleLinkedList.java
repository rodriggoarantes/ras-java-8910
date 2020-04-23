package br.com.ras.java.leetcode.codechallenge.week2;

/**
 * Middle of the Linked List
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 *
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Note:
 *     The number of nodes in the given list will be between 1 and 100.
 */
public class MiddleLinkedList {

    /**
     * Method 1:
     * Traverse the whole linked list and count the no. of nodes.
     * Now traverse the list again till count/2 and return the node at count/2.
     *
     * Method 2:
     * Traverse linked list using two pointers. Move one pointer by one and other pointer by two.
     * When the fast pointer reaches end slow pointer will reach middle of the linked list.
     *
     * @param head
     * @return ListNode Middle
     */
    public ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode jump1 = head;
        ListNode jump2 = head;
        while (jump2 != null && jump2.next != null) {
            jump2 = jump2.next.next;
            jump1 = jump1.next;
        }
        return jump1;
    }

    public static class Builder {
        ListNode head;

        private Builder(){}

        public static Builder get() {
            return new Builder();
        }

        public ListNode builder(int[] numbers) {
            if (numbers.length == 0) {
                return null;
            }

            for(int i : numbers) {
                push(i);
            }
            return head;
        }

        public void push(int new_data) {
            ListNode new_node = new ListNode(new_data);
            new_node.next = head;
            head = new_node;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

