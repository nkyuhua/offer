package nk.algorithm;

import java.util.LinkedList;
import java.util.Queue;

import nk.algorithm.T06.BinaryTreeNode;

/**
 * 层次遍历二叉树
 * 
 * @author nk
 * 
 */
public class T23 {

	public static <E> void printBinaryTreeByHierarchy(BinaryTreeNode<E> tree) {
		if (tree != null) {
			Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
			queue.add(tree);
			while (!queue.isEmpty()) {
				BinaryTreeNode<E> node = queue.remove();
				System.out.println(node.value);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		Integer[] left = { 1, 2, 4, 7, 3, 5, 6, 8 };
		Integer[] mid = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode<Integer> root = T06.getTreeFromPreMidOrder(left, mid);

		printBinaryTreeByHierarchy(root);
	}
}
