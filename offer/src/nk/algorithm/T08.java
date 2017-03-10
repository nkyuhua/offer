package nk.algorithm;

import java.util.Arrays;

public class T08 {

	/**
	 * 旋转数字最小值
	 */
	public static int min(int[] in) {
		if (in == null || in.length == 0)
			throw new IllegalArgumentException("in is empty");
		return getMin2(in, 0, in.length - 1);
	}

	/**
	 * 递归方式
	 * 
	 * @param in
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getMin(int[] in, int start, int end) {

		int mid = (start + end) / 2;
		if (in[mid] > in[start])
			return getMin(in, mid + 1, end);
		else if (in[mid] < in[start])
			return getMin(in, start + 1, mid);
		else
			return minInOrder(in, start, end);
	}

	/**
	 * 循环方式
	 * 
	 * @param in
	 * @param start
	 * @param end
	 * @return
	 */
	private static int getMin2(int[] in, int start, int end) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (in[mid] > in[start])
				start = mid + 1;
			else if (in[mid] < in[start])
				end = mid;
			else
				return minInOrder(in, start, end);
		}
		return in[start];
	}

	private static int minInOrder(int[] in, int start, int end) {
		int min = in[start];
		for (int i = start; i <= end; i++) {
			if (in[i] < min)
				min = in[i];
		}
		return min;

	}

	/**
	 * 年龄排序
	 * 
	 * @param ages
	 * @param length
	 */
	static void sortAges(int[] ages, int length) {
		if (ages == null || length <= 0)
			return;
		int oldesdAge = 99;
		int[] timesOfAge = new int[oldesdAge + 1];
		for (int i = 0; i < oldesdAge; i++) {
			timesOfAge[i] = 0;
		}

		for (int i = 0; i < length; ++i) {
			int age = ages[i];
			++timesOfAge[age];
		}
		int index = 0;
		for (int age = 0; age < oldesdAge; ++age) {
			int curAgeTimes = timesOfAge[age];
			for (int j = 0; j < curAgeTimes; ++j) {
				ages[index] = age;
				++index;
			}
		}

	}

	public static void main(String[] args) {
		int[] ages = { 18, 19, 20, 21, 21, 17, 54, 12, 44, 57, 51, 24, 14, 18,
				18, 19, 21, 21, 17 };
		int[] in = { 3, 4, 5, 1, 2 };
		int[] in2 = { 1, 0, 1, 1, 1 };
		int[] in3 = { 1, 1, 1, 0, 1 };
		sortAges(ages, ages.length);
		System.out.println(Arrays.toString(ages));
		System.out.println(min(in));
		System.out.println(min(in2));
		System.out.println(min(in3));
	}

}
