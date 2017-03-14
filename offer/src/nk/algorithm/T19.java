package nk.algorithm;

import nk.algorithm.T06.BinaryTreeNode;
import static nk.algorithm.T06.BinaryTreeNode.*;

/**
 * 二叉树的镜像
 * 
 * @author nk
 * 
 */
public class T19 {

	/**
	 * null =null;合法
	 */
	public static <E> void mirror(BinaryTreeNode<E> root) {
		if (root == null)
			return;
		BinaryTreeNode<E> temp = root.left;
		root.left = root.right;
		root.right = temp;

		mirror(root.left);
		mirror(root.right);

	}

	public static void main(String[] args) {
		// 8
		// / \
		// 6 10
		// / \ / \
		// 5 7 9 11
		BinaryTreeNode root = new BinaryTreeNode();
		root.value = 8;
		root.left = new BinaryTreeNode();
		root.left.value = 6;
		root.left.left = new BinaryTreeNode();
		root.left.left.value = 5;
		root.left.right = new BinaryTreeNode();
		root.left.right.value = 7;
		root.right = new BinaryTreeNode();
		root.right.value = 10;
		root.right.left = new BinaryTreeNode();
		root.right.left.value = 9;
		root.right.right = new BinaryTreeNode();
		root.right.right.value = 11;
		midSearch(root);
		System.out.println();
		mirror(root);
		midSearch(root);
		// 1
		// /
		// 3
		// /
		// 5
		// /
		// 7
		// /
		// 9
		BinaryTreeNode root2 = new BinaryTreeNode();
		root2.value = 1;
		root2.left = new BinaryTreeNode();
		root2.left.value = 3;
		root2.left.left = new BinaryTreeNode();
		root2.left.left.value = 5;
		root2.left.left.left = new BinaryTreeNode();
		root2.left.left.left.value = 7;
		root2.left.left.left.left = new BinaryTreeNode();
		root2.left.left.left.left.value = 9;
		System.out.println("\n");
		midSearch(root2);
		System.out.println();
		mirror(root2);
		midSearch(root2);

		// 0
		// \
		// 2
		// \
		// 4
		// \
		// 6
		// \
		// 8
		BinaryTreeNode root3 = new BinaryTreeNode();
		root3.value = 0;
		root3.right = new BinaryTreeNode();
		root3.right.value = 2;
		root3.right.right = new BinaryTreeNode();
		root3.right.right.value = 4;
		root3.right.right.right = new BinaryTreeNode();
		root3.right.right.right.value = 6;
		root3.right.right.right.right = new BinaryTreeNode();
		root3.right.right.right.right.value = 8;
		System.out.println("\n");
		midSearch(root3);
		System.out.println();
		mirror(root3);
		midSearch(root3);

	}

}
