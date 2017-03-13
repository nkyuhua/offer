package nk.algorithm;

import nk.algorithm.T13.ListNode;

/**
 * 反转单链表
 * 
 * @author nk
 * 
 */
public class T16 {

	public static <E> ListNode<E> reverseNode(ListNode<E> root) {
		if (root == null || root.next == null)
			return root;
		ListNode<E> left = null;
		ListNode<E> mid = root;
		ListNode<E> right = root.next;
		while (right != null) {
			mid.next = left;
			left = mid;
			mid = right;
			right = right.next;
		}
		mid.next = left;
		return mid;
	}

	public static void main(String[] args) {
		ListNode<Integer> node5 = new ListNode<>(5, null);
		ListNode<Integer> node4 = new ListNode<>(4, node5);
		ListNode<Integer> node3 = new ListNode<>(3, node4);
		ListNode<Integer> node2 = new ListNode<>(2, node3);
		ListNode<Integer> node1 = new ListNode<>(1, node2);

		reverseNode(node1).p();

	}

}
