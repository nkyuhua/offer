package nk.algorithm;

/**
 * 已知前序中序，重建二叉树
 * 
 * @author nk
 * 
 */
public class T06 {

	public static <E> BinaryTreeNode<E> getTreeFromPreMidOrder(E[] preOrder,
			E[] midOrder) {
		if (preOrder == null || midOrder == null || preOrder.length <= 0
				|| midOrder.length <= 0)
			return null;
		if (preOrder.length != midOrder.length)
			throw new IllegalArgumentException(
					"preOrder's length must equal to midOrder's length");
		return getTreeFromPreMidOrder(preOrder, 0, preOrder.length - 1,
				midOrder, 0, midOrder.length - 1);
	}

	private static <E> BinaryTreeNode<E> getTreeFromPreMidOrder(E[] preOrder,
			int preStart, int preEnd, E[] midOrder, int midStart, int midEnd) {
		if (preEnd < preStart)
			return null;
		E value = preOrder[preStart];
		int index = midStart;
		while (index <= midEnd && midOrder[index] != value)
			index++;
		if (index > midEnd)
			throw new IllegalArgumentException("midOrder doesn't contain "
					+ value);
		BinaryTreeNode<E> root = new BinaryTreeNode<E>();
		root.value = value;
		int leftLength = index - midStart;
		root.left = getTreeFromPreMidOrder(preOrder, preStart + 1, preStart
				+ leftLength, midOrder, midStart, index - 1);
		root.right = getTreeFromPreMidOrder(preOrder,
				preStart + leftLength + 1, preEnd, midOrder, index + 1, midEnd);

		return root;

	}

	/**
	 * 二叉树定义
	 * 
	 * @author nk
	 * 
	 * @param <E>
	 */
	public static class BinaryTreeNode<E> {
		E value;
		BinaryTreeNode<E> left;
		BinaryTreeNode<E> right;

		public BinaryTreeNode() {
		}

		/**
		 * 前序遍历二叉树
		 * 
		 * @param root
		 */
		public static <E> void preSearch(BinaryTreeNode<E> root) {
			if (root != null) {
				System.out.print(root.value.toString() + "\t");
				preSearch(root.left);
				preSearch(root.right);
			}
		}

		/**
		 * 中序遍历二叉树
		 * 
		 * @param root
		 */
		public static <E> void midSearch(BinaryTreeNode<E> root) {
			if (root != null) {
				midSearch(root.left);
				System.out.print(root.value.toString() + "\t");
				midSearch(root.right);
			}
		}

		/**
		 * 后续遍历二叉树
		 * 
		 * @param root
		 */
		public static <E> void backSearch(BinaryTreeNode<E> root) {
			if (root != null) {
				backSearch(root.left);
				backSearch(root.right);
				System.out.print(root.value.toString() + "\t");
			}
		}

	}

	public static void main(String[] args) {
		Integer[] left = { 1, 2, 4, 7, 3, 5, 6, 8 };
		Integer[] mid = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode<Integer> root = getTreeFromPreMidOrder(left, mid);
		System.out.print("前序遍历\t");
		root.preSearch(root);
		System.out.print("\n中序遍历\t");
		root.midSearch(root);
		System.out.print("\n后序遍历\t");
		root.backSearch(root);

	}

}
