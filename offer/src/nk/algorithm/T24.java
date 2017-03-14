package nk.algorithm;

/**
 * 二叉搜索树后序遍历
 * 
 * @author nk
 * 
 */
public class T24 {

	public static <E extends Comparable<E>> boolean isBackSearchOfBST(E[] values) {
		if (values == null || values.length == 0)
			return false;
		return isBackSearchBST(values, 0, values.length - 1);
	}

	private static <E extends Comparable<E>> boolean isBackSearchBST(
			E[] values, int start, int end) {
		if (start == end)
			return true;
		E root = values[end];
		int i, j;
		for (i = start; i <= end; i++) {
			E cur = values[i];
			if (cur.compareTo(root) > 0) {
				j = i;
				while (++j <= end) {
					if (values[j].compareTo(root) < 0)
						return false;
				}
				break;
			}
		}
		return isBackSearchBST(values, start, i - 1)
				&& isBackSearchBST(values, i, end - 1);
	}

	public static void main(String[] args) {
		Integer[] values = { 5, 7, 6, 9, 11, 10, 8 };
		Integer[] values2 = { 7, 4, 6, 5 };
		System.out.println(isBackSearchOfBST(values));
		System.out.println(isBackSearchOfBST(values2));
	}
}
