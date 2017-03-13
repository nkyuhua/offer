package nk.algorithm;

import nk.algorithm.T13.ListNode;

/**
 * 获取单链表倒数第k个数
 * 
 * @author nk
 * 
 */
public class T15 {

	/**
	 * 
	 * @param root
	 * @param k
	 *            从1开始计数
	 * @return
	 */
	public static <E> ListNode<E> get(ListNode<E> root, int k) {
		if (root == null || k <= 0)
			throw new IllegalArgumentException();
		ListNode<E> p1 = root;
		ListNode<E> p2 = root;
		for (int i = 0; i < k - 1; i++) {
			if (p1.next != null)
				p1 = p1.next;
			else
				throw new IllegalArgumentException();
		}
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	public static void main(String[] args) {
		ListNode<Integer> node5 = new ListNode<>(5, null);
		ListNode<Integer> node4 = new ListNode<>(4, node5);
		ListNode<Integer> node3 = new ListNode<>(3, node4);
		ListNode<Integer> node2 = new ListNode<>(2, node3);
		ListNode<Integer> node1 = new ListNode<>(1, node2);

		System.out.println(get(node1, 6).value);
		// System.out.println(get(node5, 1).value);
		// System.out.println(get(node4, 2).value);
		// System.out.println(get(node4, 3).value);
	}
}
