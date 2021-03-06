package CTCI.LinkedList;


/*
 * P: You have two numbers represented by a LinkedLists
 *    Each node has single digit
 *    Digits stored in the reverse order
 *    WAF: that adds two numbers and returns the sum in the form of LinkedList
 * */

// Problem: (7 -> 1 -> 6) + (5 -> 9 -> 2)  =  (2 -> 1 -> 9)

import java.util.LinkedList;

public class SumLists {


    // naive solution
    public LinkedList SumList(LinkedListNode a, LinkedListNode b) {
        LinkedList<LinkedListNode> ans = new LinkedList<>();
        int a1 = 1, b1 = 1;
        int aPart, bPart, carry = 0;
        while (a == null && b == null) {
            if (a != null) {
                aPart = a1 * a.value;
                a1 *= 10;
            } else {
                aPart = 0;
            }

            if (b != null) {
                bPart = b1 * b.value;
                b1 *= 10;
            } else {
                bPart = 0;
            }

            // add them

            int sum = aPart + bPart + carry;

            LinkedListNode n = new LinkedListNode(sum % 10);
            carry = sum / 10;
            ans.add(n);
        }

        while (carry != 0) {

            LinkedListNode n = new LinkedListNode(carry % 10);
            carry = carry / 10;
            ans.add(n);

        }

        return ans;
    }

    // Recursive Solution -> returns Node

    LinkedListNode addList(LinkedListNode a, LinkedListNode b) {
        return addList(a, b, 0);
    }

    private LinkedListNode addList(LinkedListNode a, LinkedListNode b, int carry) {
        if (a == null && b == null && carry == 0) {
            return null;
        }

        LinkedListNode ans = new LinkedListNode();
        int value = carry;
        if (a != null) {
            value += a.value;
        }
        if (b != null) {
            value += b.value;
        }

        ans.value = value % 10;

        // Recurse Logic
        if (a != null || b != null) {
            LinkedListNode more = addList(a == null ? null : a.next,
                                b == null ? null : b.next,
                                value >= 10 ? 1 : 0);

        ans.setNext(more);
        }

        return ans;
    }


}
