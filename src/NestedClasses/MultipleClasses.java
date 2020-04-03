package NestedClasses;

public class MultipleClasses {

	public static void main(String[] args) {
		First f = new First();
		f.doSomeThing();
		
		Second.doSomeThing();
		
		
	}
}

class First{
	public void doSomeThing() {
		System.out.println("First.doSomeThing()");
	}
}
class Second{
	public static void doSomeThing() {
		System.out.println("Second.doSomeThing()");
	}
	
}
