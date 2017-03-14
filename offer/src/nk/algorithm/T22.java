package nk.algorithm;

import java.util.Stack;

/**
 * 判断b序列是不是a序列的弹出序列
 * 
 * @author nk
 * 
 */
public class T22 {

	public static <E> boolean isPopOrder(E[] e1, E[] e2) {
		if (e1 == null || e2 == null || e1.length == 0 || e2.length == 0
				|| e1.length != e2.length)
			return false;
		Stack<E> stack = new Stack<>();
		/** i j 分别为 e1[] e2[]下标 */
		int i = 0, j = 0;
		while (i < e1.length || !stack.isEmpty()) {
			if (stack.isEmpty())
				stack.push(e1[i++]);
			while (!stack.peek().equals(e2[j])) {
				if (i < e1.length) {
					stack.push(e1[i++]);
				} else
					return false;
			}
			stack.pop();
			j++;
		}
		return true;
	}

	public static void main(String[] args) {
		Integer[] e1 = { 1, 2, 3, 4, 5 }, e2 = { 4, 5, 3, 2, 1 }, e3 = { 4, 3,
				5, 1, 2 }, e4 = { 5, 4, 3, 2, 1 };
		System.out.println(isPopOrder(e1, e2));
		System.out.println(isPopOrder(e1, e3));
		System.out.println(isPopOrder(e1, e4));
	}
}
