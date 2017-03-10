package nk.algorithm;

import java.util.Stack;

/**
 * 2个栈实现队列
 * 
 * @author nk
 * 
 * @param <E>
 */
public class T07<E> {
	private Stack<E> stack1, stack2;

	public T07() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public void add(E e) {
		stack1.add(e);
	}

	public E pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
		}
		return stack2.pop();

	}

	public static void main(String[] args) {
		T07<Integer> t = new T07<>();
		for (int i = 0; i < 10; i++) {
			t.add(i);
		}
		while (!t.isEmpty()) {
			System.out.println(t.pop());
		}

	}
}
