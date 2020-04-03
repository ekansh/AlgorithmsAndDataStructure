package Scribbling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tests {
	private static final ArrayList<Integer> i = new ArrayList<>();
	public static void main(String[] args) {
		i.add(0,1);
	}

}
interface I1{
	public  void method1() throws IOException;
}
class A implements I1{

	@Override
	public void method1() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
class B extends A{
	
}
class C extends A{
	
}
