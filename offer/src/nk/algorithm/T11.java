package nk.algorithm;

import java.util.Random;

public class T11 {

	public static double power(double base, int exponent) {
		if (base == 0 || exponent == 0)
			return 0;
		return exponent > 0 ? powerPositive2(base, exponent)
				: 1 / powerPositive2(base, -exponent);

	}

	/**
	 * 循坏方式
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	private static double powerPositive(double base, int exponent) {
		double result = base;
		while (--exponent > 0) {
			result *= base;
		}
		return result;
	}

	/**
	 * 公式方式
	 * 
	 * @param base
	 * @param exponent
	 * @return
	 */
	private static double powerPositive2(double base, int exponent) {
		double result = powerPositive2(base, exponent >> 1);
		result *= result;
		if ((exponent & 1) == 1)
			result *= base;
		return result;
	}

	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			double base = random.nextDouble() + random.nextInt(100);
			int exponent = random.nextInt(20);
			double d1 = Math.pow(base, exponent);
			System.out.println(d1);

		}
	}
}
