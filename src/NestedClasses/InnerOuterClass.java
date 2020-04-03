package NestedClasses;

public class InnerOuterClass {

	private String outerStr;
	private static String outerStaticStr = "outerStaticStr";

	public InnerOuterClass() {
		outerStr = "outerStr";

	}

	public void outerMethod() {
		System.out.println("InnerClassDemo.outerMethod()");
	}

	public void outerStaticMethod() {
		System.out.println("InnerClassDemo.outerStaticMethod()");
	}

	private class InnerPrivateClass {
		private String innerStr;
//		The field innerStaticStr cannot be declared static in a non-static
//		inner type, unless initialized with a constant expression
//		private static String innerStaticStr = "innerStaticStr";
		private static final String innerStaticStr = "innerStaticStr";
	}

	public class InnerPublicClass {
		private String innerStr;
//		The field innerStaticStr cannot be declared static in a non-static
//		inner type, unless initialized with a constant expression
//		private static String innerStaticStr = "innerStaticStr";
		private static final String innerStaticStr = "innerStaticStr";
	}

	private static class InnerPrivateStaticClass {
		private String innerStr;
		private static String innerStaticStr = "innerStaticStr";
	}

	public static class InnerPublicStaticClass {
		private String innerStr;
		private static String innerStaticStr = "innerStaticStr";
	}

}
