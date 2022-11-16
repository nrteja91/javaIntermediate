package org.example;

public class Main {
  public static void main(String[] args) {
    Object obj = "Hello world!";
    switch (obj) {
      case String s when s.length() > 3 ->
        System.out.println(s);
      default -> throw new IllegalArgumentException();
    }
  }
}