package nk.algorithm;

import java.util.Stack;

public class T5<E> {

	/**
	 * 利用栈结构逆向打印单链表
	 * 
	 * @param node
	 */
	public static <E> void reversePrint(Node<E> node) {
		Stack<Node<E>> stack = new Stack<>();
		Node<E> temp = node;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		Node<E> item;
		while (!stack.isEmpty()) {
			item = stack.pop();
			System.out.println(item.item.toString());
		}

	}

	/**
	 * 利用递归逆向打印单链表 步骤1——>步骤2： 前序遍历 
	 * 步骤2——>步骤1：后序遍历
	 * 
	 * @param node
	 */
	public static <E> void reversePrint2(Node<E> node) {
		if (node != null) {
			reversePrint2(node.next);// 步骤2
			System.out.println(node.item + " "); // 步骤1
		}
	}

	public static void main(String[] args) {
		Node<Integer> node5 = new Node<>(5, null);
		Node<Integer> node4 = new Node<>(4, node5);
		Node<Integer> node3 = new Node<>(3, node4);
		Node<Integer> node2 = new Node<>(2, node3);
		Node<Integer> node1 = new Node<>(1, node2);
		reversePrint(node1);
	}

	private static class Node<E> {
		E item;
		Node<E> next;

		Node(E item, Node<E> next) {
			super();
			this.item = item;
			this.next = next;
		}

	}

}
