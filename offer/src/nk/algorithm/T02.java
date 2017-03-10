package nk.algorithm;

import java.util.Observable;
import java.util.Observer;
/**
 * 单例
 *
 */
public class T02 {

	// 1、赖汉式 双重校验锁
	public static class Singleton1 {
		private static Singleton1 singleton;

		private Singleton1() {

		}

		public static Singleton1 newInstance() {
			if (singleton == null) {
				synchronized (Singleton1.class) {
					if (singleton == null) {
						singleton = new Singleton1();
					}
				}
			}
			return singleton;

		}
	}

	// 2、饿汉式
	public static class Singleton2 {
		private static Singleton2 singleton = new Singleton2();

		private Singleton2() {

		}

		public static Singleton2 newInstance() {

			return singleton;

		}
	}

	// 3、饿汉式 静态内部类 需时初始化
	public static class Singleton3 {

		private static final class Holder {
			private static final Singleton3 instance = new Singleton3();
		}

		private Singleton3() {

		}

		public static Singleton3 newInstance() {

			return Holder.instance;

		}
	}

	// 4、枚举实现
	public static enum Singleton4 implements Observer {
		INSTANCE {

			@Override
			public void update(Observable arg0, java.lang.Object arg1) {

			}
		};

		public void f() {
			System.out.println("f called");
		}

	}

	public static void main(String[] args) {
		System.out.println(Singleton1.newInstance() == Singleton1.newInstance());
		System.out.println(Singleton2.newInstance() == Singleton2.newInstance());
		System.out.println(Singleton3.newInstance() == Singleton3.newInstance());
		System.out.println(Singleton4.INSTANCE == Singleton4.INSTANCE);
	}

}
