package nk.algorithm;

import java.util.Stack;

public class T21 {

	private Stack<Integer> stack;
	private Stack<Integer> stack2;
	private int curMin = Integer.MAX_VALUE;

	public T21() {
		stack = new Stack<>();
		stack2 = new Stack<>();
	}

	public void push(int in) {
		curMin = Math.min(curMin, in);
		stack.push(in);
		stack2.push(curMin);
	}

	public int pop() {
		if (stack.isEmpty())
			throw new ArrayIndexOutOfBoundsException("stack is empty");
		int top1 = stack.pop();
		stack2.pop();
		curMin = stack2.isEmpty() ? Integer.MAX_VALUE : stack2.peek();
		return top1;
	}

	public int min() {
		return curMin;
	}

	public static void main(String[] args) {
		T21 t21 = new T21();
		t21.testPush(3);
		t21.testPush(4);
		t21.testPush(2);
		t21.testPush(1);
		t21.testPop();
		t21.testPop();
		t21.push(0);
		t21.testPop();
		t21.testPop();
		t21.testPop();
	}

	private void testPush(int value) {
		push(value);
		System.out.println(stack.toString() + "当前最小值=" + curMin);
	}

	private void testPop() {
		pop();
		System.out.println(stack.toString() + "当前最小值=" + curMin);
	}

}
