package nk.algorithm;

/**
 * 从外向内打印矩阵
 * 
 * @author nk
 * 
 */
public class T20 {

	public static void printArray(int[][] numbers) {
		if (numbers == null || numbers.length == 0 || numbers[0].length == 0) {
			System.out.println(numbers);
			return;
		}
		int row = numbers.length;
		int col = numbers[0].length;
		int min = Math.min(row, col);
		int circles = min % 2 == 0 ? min / 2 : (min / 2 + 1);
		int curCircle = 1;
		while (curCircle <= circles) {
			pOutCircle(numbers, curCircle - 1, curCircle - 1, row - curCircle, col
					- curCircle);
			curCircle++;
		}
	}

	private static void pOutCircle(int[][] numbers, int ai, int aj, int bi, int bj) {
		/**
		 * 仅当打印元素右移且下移，才是环路，此时才允许反移动打印
		 */
		boolean hasRight = ai != bi, hasDown = aj != bj;
		int curRow = ai, curCol = aj;
		while (curCol < bj) {
			int temp = numbers[curRow][curCol];
			curCol++;
			System.out.println(temp);
		}
		while (curRow < bi) {
			int temp = numbers[curRow][curCol];
			curRow++;
			System.out.println(temp);
		}
		while (curCol > aj && hasRight && hasDown) {
			int temp = numbers[curRow][curCol];
			curCol--;
			System.out.println(temp);
		}
		while (curRow > ai && hasRight && hasDown) {
			int temp = numbers[curRow][curCol];
			curRow--;
			System.out.println(temp);
		}
		/**
		 * 当输入数组仅1行或1列时，最后一元素因while判断原因，未打印，补打
		 */
		if (!hasRight || !hasDown)
			System.out.println(numbers[bi][bj]);

	}

	public static void main(String[] args) {
		int[][] numbers = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };

		int[][] numbers2 = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 },
				{ 8 } };
		int[][] numbers3 = { { 0, 1 }, { 15, 2 }, { 14, 3 }, { 13, 4 },
				{ 12, 5 }, { 11, 6 }, { 10, 7 }, { 9, 8 } };
		int[][] numbers4 = { { 1, 2, 3, 4, 5 }, };
		int[][] numbers5 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, };
		printArray(numbers);
		System.out.println("---------");
		printArray(numbers2);
		System.out.println("---------");
		printArray(numbers3);
		System.out.println("---------");
		printArray(numbers4);
		System.out.println("---------");
		printArray(numbers5);
	}
}
