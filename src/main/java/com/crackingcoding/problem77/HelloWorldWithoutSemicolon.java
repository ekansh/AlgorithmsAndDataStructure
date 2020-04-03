/*

 *



 *

 *
 




 */
package com.crackingcoding.problem77;

/**
 * Can you write a method to print a hello world without use a semicolon?.
 *

 */
public class HelloWorldWithoutSemicolon {

  public void printHelloWorld() {
    if ((System.out.append("Hello world")) != null) {
    }
  }

  public static void main(String[] args) {
    HelloWorldWithoutSemicolon helloWorldWithoutSemicolon = new HelloWorldWithoutSemicolon();
    helloWorldWithoutSemicolon.printHelloWorld();
  }
}
