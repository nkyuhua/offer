package nk.algorithm;

/**
 * 0(1) 删除单链表指定节点
 * 
 * @author nk
 * 
 */
public class T13 {

	public static <E> ListNode<E> delete(ListNode<E> listNode,
			ListNode<E> toDelete) {
		if (listNode == null || toDelete == null)
			throw new IllegalArgumentException(
					"neither listNode nor toDelete could be null");
		if (listNode.next == null) {
			if (!listNode.equals(toDelete))
				throw new IllegalArgumentException(
						"listNode not contain toDelete");
			else
				listNode = null;
		} else if (toDelete.next != null) {
			ListNode<E> next = toDelete.next;
			toDelete.value = next.value;
			toDelete.next = next.next;
			toDelete = null;
		} else {
			ListNode<E> next = listNode;
			while (!(next.next).equals(toDelete)) {
				next = next.next;
			}
			next.next = null;
			toDelete = null;
		}
		return listNode;

	}

	/**
	 * 单链表
	 * 
	 * @author nk
	 * 
	 * @param <E>
	 */
	public static class ListNode<E> {
		E value;
		ListNode<E> next;

		public ListNode(E value, ListNode<E> next) {
			super();
			this.value = value;
			this.next = next;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return this == null;
			if (getClass() != obj.getClass())
				return false;
			ListNode<?> other = (ListNode<?>) obj;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		public void p() {
			System.out.println(value);
			for (; next != null; next = next.next) {
				System.out.println(next.value);
			}
		}
	}

	public static void main(String[] args) {
		ListNode<Integer> node5 = new ListNode<>(5, null);
		ListNode<Integer> node4 = new ListNode<>(4, node5);
		ListNode<Integer> node3 = new ListNode<>(3, node4);
		ListNode<Integer> node2 = new ListNode<>(2, node3);
		ListNode<Integer> node1 = new ListNode<>(1, node2);

		// p(delete(node1, node3));
		// p(delete(node5, node5));
		// p(delete(node1, node5));

	}

	public static <E> void p(ListNode<E> node1) {
		if (node1 == null) {
			System.out.println(node1);
			return;
		}
		ListNode<E> next = node1;
		while (next != null) {
			System.out.println(next.value.toString());
			next = next.next;
		}
	}
}
