package nk.algorithm;

/**
 * 复杂链表的复制
 * 
 * @author nk
 * 
 */
public class T26 {

	public static <E> ComplexListNode<E> clone(ComplexListNode<E> node) {
		if (node == null)
			return null;
		ComplexListNode<E> root = new ComplexListNode<>();
		ComplexListNode<E> temp;
		root.value = node.value;
		while (node.next != null) {
			ComplexListNode<E> newNode = clone2(node);
			root.next = newNode;
//			temp = temp.next;
		}

		return root;

	}

	private static <E> ComplexListNode<E> clone2(ComplexListNode<E> node) {
		if (node == null)
			return null;
		ComplexListNode<E> root = new ComplexListNode<>();
		root.value = node.value;
		root.next = node.next;
		root.sibling = node.sibling;
		System.out.println(node);
		System.out.println(root);
		return root;

	}

	public static void main(String[] args) {

		ComplexListNode<Integer> node = new ComplexListNode<>();
		node.value = 1;
		node.next = new ComplexListNode<>();
		node.next.value = 2;
		node.next.next = new ComplexListNode<>();
		node.next.next.value = 3;
		node.next.next.next = new ComplexListNode<>();
		node.next.next.next.value = 4;

		ComplexListNode<Integer> root = clone(node);

	}

	public static class ComplexListNode<E> {
		E value;
		ComplexListNode<E> next;
		ComplexListNode<E> sibling;
	}

}
