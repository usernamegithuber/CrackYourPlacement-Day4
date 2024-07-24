package CrackYourPlacementDay4;

public class PalindromeLinkedList {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true; // An empty list or single node list is a palindrome
            }

            ListNode slow = head, fast = head;
            int len = 0;

            // Calculate the length of the linked list
            for (ListNode curr = head; curr != null; curr = curr.next) {
                len++;
            }

            // Move slow to the middle of the list
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // If the length is odd, move slow to the start of the second half
            if (len % 2 != 0) {
                slow = slow.next;
            }

            // Reverse the second half of the list
            ListNode secondHalfHead = reverse(slow);
            ListNode firstHalfHead = head;

            // Compare the first half with the reversed second half
            while (secondHalfHead != null) {
                if (firstHalfHead.val != secondHalfHead.val) {
                    return false;
                }
                firstHalfHead = firstHalfHead.next;
                secondHalfHead = secondHalfHead.next;
            }

            return true;
        }

        // Helper function to reverse a linked list
        private ListNode reverse(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = prev;
                prev = head;
                head = nextNode;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        // Create a test case for the palindrome check

        // Example 1: Palindrome list [1, 2, 2, 1]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        Solution solution = new Solution();
        boolean result1 = solution.isPalindrome(head1);
        System.out.println("Is the list [1, 2, 2, 1] a palindrome? " + result1);

    }
}
