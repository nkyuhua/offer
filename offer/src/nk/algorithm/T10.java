package nk.algorithm;

/**
 * 输出二进制数中1的格式
 * 
 * @author nk
 * 
 */
public class T10 {

	public static boolean isPowOf2(int in) {
		return (in & (in-1)) == 0;
	}

	public static int getNumOf1(int in) {
		int count = 0;
		while (in != 0) {
			count += in & 1;
			in >>>= 1;
		}
		return count;
	}

	/**
	 * 
	 * @param excelIn
	 * @return
	 */
	public static long getExcelRow(String excelIn) {
		if (excelIn == null || excelIn.isEmpty())
			throw new IllegalArgumentException();
		excelIn = excelIn.toUpperCase();
		char[] chars = excelIn.toCharArray();
		long result = 0;
		long curPow = 1;
		int curIndex = chars.length - 1;
		long curValue = 0;
		while (curIndex >= 0) {
			curValue = (int) chars[curIndex] - 64;
			curValue *= curPow;
			curIndex--;
			curPow *= 26;
			result += curValue;
		}

		return result;
	}

	public static void main(String[] args) {
		// System.out.println(getExcelRow("A"));
		// System.out.println(getExcelRow("C"));
		// System.out.println(getExcelRow("AB"));
		// System.out.println(getExcelRow("AD"));
		// System.out.println(getExcelRow("ABD"));
		//
		// System.out.println(getNumOf1(1));
		// System.out.println(getNumOf1(12));
		// System.out.println(getNumOf1(0x80000000));

		System.out.println(isPowOf2(0));
		System.out.println(isPowOf2(1));
		System.out.println(isPowOf2(2));
		System.out.println(isPowOf2(4));
		System.out.println(isPowOf2(64));
		System.out.println(isPowOf2(63));
	}
}
