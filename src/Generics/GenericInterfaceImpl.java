package Generics;

public class GenericInterfaceImpl<T> implements GenericInterface<T> {

	@Override
	public T doSomeThing(T t) {
		
		return t;
	}

}
