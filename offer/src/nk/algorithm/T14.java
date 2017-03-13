package nk.algorithm;

import java.util.Arrays;

/**
 * 按规定重排数组
 * 
 * @author nk
 * 
 */
public class T14 {

	private static int[] reSort(int[] in) {
		if (in == null || in.length <= 1)
			return in;
		int i = 0, j = in.length - 1;
		while (i < j) {
			while (isSpecialNum(in[i]))
				i++;
			while (!isSpecialNum(in[j]))
				j--;
			if (i < j) {
				System.out.println(Arrays.toString(in));
				swap(in, i, j);
			}
		}
		return in;
	}
	private static void swap(int[] in, int l, int r) {
		int temp = in[l];
		in[l] = in[r];
		in[r] = temp;
	}

	private static boolean isSpecialNum(int i) {
		// return i % 2 == 1;
		return i % 3 != 0;
	}

	public static void main(String[] args) {
		int[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(reSort(in)));
	}
}
