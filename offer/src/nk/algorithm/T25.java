package nk.algorithm;

import java.util.Stack;

import nk.algorithm.T06.BinaryTreeNode;

/**
 * 二叉树中和为某一值的路径
 * 
 * @author nk
 * 
 */
public class T25 {

	public static void printTrack(BinaryTreeNode<Integer> tree, int num) {
		if (tree != null) {
			Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
			printTrack(tree, stack, num, 0);
		}

	}

	private static void printTrack(BinaryTreeNode<Integer> tree,
			Stack<BinaryTreeNode<Integer>> stack, int targetNum, int curNum) {
		stack.push(tree);
		curNum += tree.value;
		if (isLeaf(tree) && curNum == targetNum) {
			System.out.print("\n found path \t");
			for (int i = 0; i < stack.size(); i++) {
				System.out.print(stack.elementAt(i).value + "\t");
			}
		} else {
			if (curNum >= targetNum)
				return;
			if (tree.left != null)
				printTrack(tree.left, stack, targetNum, curNum);
			if (tree.right != null)
				printTrack(tree.right, stack, targetNum, curNum);
		}
		stack.pop();

	}

	private static <E> boolean isLeaf(BinaryTreeNode<E> tree) {
		return tree.left == null && tree.right == null;
	}

	public static void main(String[] args) {
		Integer[] left = { 10, 5, 4, 7, 12 };
		Integer[] mid = { 4, 5, 7, 10, 12 };
		BinaryTreeNode<Integer> root = T06.getTreeFromPreMidOrder(left, mid);
		printTrack(root, 22);
	}

}
