package nk.algorithm;

import nk.algorithm.T06.BinaryTreeNode;

/**
 * 判断B树是否是A树的子树
 * 
 * @author nk
 * 
 */
public class T18 {

	public static <E> boolean isChild(BinaryTreeNode<E> a, BinaryTreeNode<E> b) {
		if (a == b)
			return true;
		if (a == null)
			return false;
		if (b == null)
			return true;
		boolean result = false;
		if (a.value.equals(b.value)) {
			result = isInclude(a, b);
		}
		if (result)
			result = isChild(a.left, b) || isChild(a.right, b);
		return result;
	}

	private static <E> boolean isInclude(BinaryTreeNode<E> a,
			BinaryTreeNode<E> b) {
		if (b == null)
			return true;
		if (a == null)
			return false;
		if (!a.value.equals(b.value))
			return false;
		return isInclude(a.left, b.left) && isInclude(a.right, b.right);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>();
		root1.value = 8;
		root1.right = new BinaryTreeNode<>();
		root1.right.value = 7;
		root1.left = new BinaryTreeNode<>();
		root1.left.value = 8;
		root1.left.left = new BinaryTreeNode<>();
		root1.left.left.value = 9;
		root1.left.right = new BinaryTreeNode<>();
		root1.left.right.value = 2;
		root1.left.right.left = new BinaryTreeNode<>();
		root1.left.right.left.left = new BinaryTreeNode<>();
		root1.left.right.left.left.value = 4;
		root1.left.right.left.right = new BinaryTreeNode<>();
		root1.left.right.left.right.value = 7;

		BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>();
		root2.value = 8;
		root2.left = new BinaryTreeNode<>();
		root2.left.value = 9;
		root2.right = new BinaryTreeNode<>();
		root2.right.value = 2;

		System.out.println(isChild(root1, root2));
		System.out.println(isChild(root2, root1));
		System.out.println(isChild(root1, root1.left));
		System.out.println(isChild(root1, null));
		System.out.println(isChild(null, root2));
		System.out.println(isChild(null, null));
	}

}
