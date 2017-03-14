package nk.algorithm;

import nk.algorithm.T13.ListNode;

/**
 * 合并2个排序单链表
 * 
 * @author nk
 * 
 */
public class T17 {

	/**
	 * 递归实现
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static <E extends Comparable<E>> ListNode<E> merge(
			ListNode<E> node1, ListNode<E> node2) {
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		ListNode<E> merge;
		if (node1.value.compareTo(node2.value) < 0) {
			merge = node1;
			merge.next = merge(node1.next, node2);
		} else {
			merge = node2;
			merge.next = merge(node1, node2.next);
		}

		return merge;
	}

	/**
	 * 循环实现
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static <E extends Comparable<E>> ListNode<E> merge2(
			ListNode<E> node1, ListNode<E> node2) {
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		ListNode<E> root = new ListNode<E>();
		ListNode<E> merge = root;
		ListNode<E> one = node1, two = node2;
		while (one != null && two != null) {
			if (one.value.compareTo(two.value) < 0) {
				merge.next = one;
				one = one.next;
			} else {
				merge.next = two;
				two = two.next;
			}
			merge = merge.next;
		}

		if (one != null)
			merge.next = one;
		else
			merge.next = two;
		return root.next;
	}

	public static void main(String[] args) {
		ListNode<Integer> node5 = new ListNode<>(5, null);
		ListNode<Integer> node4 = new ListNode<>(4, node5);
		ListNode<Integer> node3 = new ListNode<>(3, node4);
		ListNode<Integer> node2 = new ListNode<>(2, node3);
		ListNode<Integer> node1 = new ListNode<>(1, node2);

		ListNode<Integer> node32 = new ListNode<>(3, null);
		ListNode<Integer> node22 = new ListNode<>(2, node32);
		ListNode<Integer> node12 = new ListNode<>(1, node22);

		T13.p(merge2(node1, node12));

	}

}
