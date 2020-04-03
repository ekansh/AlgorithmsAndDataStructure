package Generics;

import java.util.ArrayList;
import java.util.List;

public class ExtendVsSuper {
	public static void main(String[] args) {
				
		method1(new ArrayList<B>());
		method2(new ArrayList<A>());
		method3(new ArrayList<A>());
	}
	public static void method1(List<? extends I1> l ){
		I1 i1 = l.get(0);
//		l.add(new C());  This statement is wrong because we dont know what kind of list we are getting
		// we cant write when it is extending
	}
	public static void method2(List<? super B> l ){
		Object object = l.get(0); // we get an object because we dont know if we retrieved an Object or B or I2 
		l.add(new B());  // we can write here
		
	}
	public static <T> void method3(T l ){
	}

}
interface I1{
	
}
interface I2{
	
}
class A implements I1{
	
}
class B extends A implements I2{
	
}
class C extends A{
	
}
class D implements I2{
	
}
