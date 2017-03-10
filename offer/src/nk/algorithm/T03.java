package nk.algorithm;

/**
 * 查找二维数组
 * @author nk
 *
 */
public class T03 {

	/*
	 * 1、基础查找 利用给定数组特点，每个顶点组成的横竖折线都是特殊点（横线中其最大，竖线中其最小） 时间复杂度O(n+m)；
	 * 缺点：只利用了折线内部的特点，没有利用到折线与折线之间的大小关系
	 */
	public static boolean find1(int[][] src, int target) {
		if (src == null || src.length == 0 || src[0] == null
				|| src[0].length == 0)
			return false;
		int rows = src.length - 1;
		int columns = src[0].length - 1;
		if (target < src[0][0] || target > src[rows][columns])
			return false;
		int curValue, curRow = 0;
		int curColumn = columns;
		while (curRow <= rows && curColumn >= 0) {
			curValue = src[curRow][curColumn];
			if (curValue == target)
				return true;
			else if (curValue > target)
				curColumn--;
			else
				curRow++;
		}
		return false;

	}

	public static void main(String[] args) {
		int[][] src = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		System.out.println(find1(src, 100));
		System.out.println(find1(src, 3));
		System.out.println(find1(src, 2));
		System.out.println(find1(src, 7));
		System.out.println(find1(src, 13));
	}
}
