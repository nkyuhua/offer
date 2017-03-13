package nk.algorithm;

import java.math.BigInteger;

/**
 * 输入n，输出n位数字
 * 
 * @author nk
 * 
 */
public class T12 {

	public static void printNumber(int n) {
		if (n <= 0)
			return;
		BigInteger max = new BigInteger(getMaxStr(n));
		BigInteger one = BigInteger.ONE;
		BigInteger next = one;
		while (!max.equals(next)) {
			System.out.println(next);
			next = next.add(one);
		}

	}

	private static String getMaxStr(int n) {
		return Integer.toBinaryString(1 << n);
	}

	public static void main(String[] args) {
		printNumber(1);
		printNumber(6);
		printNumber(15);
	}

}
