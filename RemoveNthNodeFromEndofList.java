package CrackYourPlacementDay4;

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

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Calculate the size of the linked list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // If the node to remove is the head
        if (n == size) {
            head = head.next; // remove the first node
            return head;
        }

        // Find the (size-n)th node
        int i = 1;
        int toFind = size - n;
        ListNode prev = head;
        while (i < toFind) {
            prev = prev.next;
            i++;
        }

        // Remove the nth node from the end
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        // Sample test to demonstrate the usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthNodeFromEndofList solution = new RemoveNthNodeFromEndofList();
        ListNode result = solution.removeNthFromEnd(head, 2);

        // Print the updated linked list
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        // Expected output: 1 2 3 5 (if the 2nd node from the end is removed)
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
