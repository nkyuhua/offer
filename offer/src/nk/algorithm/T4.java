package nk.algorithm;

public class T4 {

	public static String trim(String in) {
		if (in == null || in.isEmpty())
			return in;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			Character temp = in.charAt(i);
			sb.append(Character.isWhitespace(temp) ? "%20" : temp);
		}
		return sb.toString();
	}

	public static char[] trim2(char[] in, int usedLength) {
		if (in == null || in.length == 0 || in.length < usedLength)
			return in;
		int whiteSpaceCount = 0;
		for (int i = 0; i < usedLength; i++) {
			Character temp = in[i];
			if (Character.isWhitespace(temp))
				whiteSpaceCount++;
		}
		if (whiteSpaceCount == 0)
			return in;
		int targetCharsLength = usedLength + 2 * whiteSpaceCount;
		if (targetCharsLength > in.length)
			return in;
		for (int j = usedLength - 1; j >= 0; j--) {
			Character temp = in[j];
			if (Character.isWhitespace(temp)) {
				in[--targetCharsLength] = '0';
				in[--targetCharsLength] = '2';
				in[--targetCharsLength] = '%';
			} else {
				in[--targetCharsLength] = temp;
			}
		}

		return in;
	}

	public static void main(String[] args) {
//		System.out.println(trim("we are fai  .."));
//		System.out.println(trim("  we are "));
//		System.out.println(trim("   "));
//		System.out.println(trim("wa "));
		char[] src = "we are fai ..".toCharArray();
		char[] target = new char[50];
		System.arraycopy(src, 0, target, 0, src.length);
		System.out.println(trim2(target,13));
	}

}
