package PassByValue;

public class Main
{
     public static void main(String[] args){
          Foo f = new Foo("f");
          changeReference(f); // It won't change the reference!
          System.out.println("Main.main()"+f.getAttribute());
          modifyReference(f); // It will change the object that the reference variable "f" refers to!
          System.out.println("Main.main()"+f.getAttribute());
     }
     public static void changeReference(Foo a) {
          Foo b = new Foo("b");
          a = b;
     }
     public static void modifyReference(Foo c) {
          c.setAttribute("c");
     }
}