package NestedClasses;

public class AnonymousClass {

	public static void main(String[] args) {
		AnInterface anInterface = new AnInterface() {
			
			@Override
			public void doSomethingMore(String s, Integer i) {
				System.out.println("AnonymousClass.main(...).new AnInterface() {...}.doSomethingMore()");
				
			}
			
			@Override
			public void doSomething(String s, Integer i) {
				System.out.println("AnonymousClass.main(...).new AnInterface() {...}.doSomething()");
				
			}
		};
		anInterface.doSomething("yell", 2);
	}
}
