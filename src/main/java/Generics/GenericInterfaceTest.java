package Generics;

public class GenericInterfaceTest {
	public static void main(String[] args) {
		GenericInterface<String> i = new GenericInterfaceImpl<String>();
		System.out.println(i.doSomeThing("xyz"));
		
	}
}
