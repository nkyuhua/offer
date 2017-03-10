package nk.algorithm;

/**
 * 斐波那契数列
 * 
 * @author nk
 * 
 */
public class T09 {

	/**
	 * 递归
	 * 
	 * @param n
	 * @return
	 */
	public static long F(int n) {
		return n <= 1 ? n : F(n - 1) + F(n - 2);
	}

	public static long F3(int n) {
		double d = Math.pow(5, 0.5);
		return (long) ((1/d)*(Math.pow((1+d)/2,n) -Math.pow((1-d)/2, n)));
	}

	/**
	 * 循环
	 * 
	 * @param n
	 * @return
	 */
	public static long F2(int n) {
		long[] result = { 0, 1 };
		if (n <= 1)
			return result[n];
		long f1 = result[0], f2 = result[1], fn = 0;
		for (int i = 2; i <= n; i++) {
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
		}
		return fn;

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(F(i));
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(F2(i));
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(F3(i));
		}
	}

}
