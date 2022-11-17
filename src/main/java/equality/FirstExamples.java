package equality;

import school.Student;

import java.util.List;

public class FirstExamples {
  public static void main(String[] args) {
    int x = 100;
    int y = 200;
    int z = 100;
    System.out.println("x == y " + (x == y));
    System.out.println("x == z " + (x == z));

//    String s1 = new String("Hello");
//    String s2 = new String("Bonjour");
//    String s3 = new String("Hello");
//    System.out.println("s1 == s2 " + (s1 == s2));
//    System.out.println("s1 == s3 " + (s1 == s3));
//
//    System.out.println("s1.equals(s2) " + (s1.equals(s2)));
//    System.out.println("s1.equals(s3) " + (s1.equals(s3)));

    System.out.println("length of string hello is " + ("hello".length()));

    String t1 = "Hello";
    String t2 = "Bonjour";
    String t3 = "Hello";
    System.out.println("t1 == t2 " + (t1 == t2));
    System.out.println("t1 == t3 " + (t1 == t3));

    System.out.println("t1.equals(t2) " + (t1.equals(t2)));
    System.out.println("t1.equals(t3) " + (t1.equals(t3)));

    System.out.println(t1);
    String t4 = t1.toUpperCase(); // String in Java is "immutable"
    System.out.println(t1);
    System.out.println(t4);
    t4 = t4.toLowerCase();
    System.out.println(t4);

    System.out.println((t4 + "more text").length());

    StringBuilder sb1 = new StringBuilder("Hello");
    StringBuilder sb2 = new StringBuilder("He");
    StringBuilder sb3 = new StringBuilder("Hello");

    StringBuilder sb4 = sb2;
    System.out.println("sb2 = " + sb2);
    System.out.println("sb4 = " + sb4);

    sb2.append("llo"); // mutates the ORIGINAL OBJECT
    System.out.println("sb2 = " + sb2);
    System.out.println("sb4 = " + sb4);


    System.out.println("------------");
    System.out.println("sb1 = " + sb1);
    System.out.println("sb2 = " + sb2);
    System.out.println("sb1 == sb2 " + (sb1 == sb2));
    System.out.println("sb1.equals(sb2) " + (sb1.equals(sb2)));

    System.out.println("------------");
    Student fred = new Student("Fred", 3.2);
    Student fred2 = new Student("Fred", 3.2);
    System.out.println("fred is " + fred);
    System.out.println("fred2 is " + fred2);
    System.out.println("fred == fred2 " + (fred == fred2));
    System.out.println("fred.equals(fred2) " + (fred.equals(fred2)));

    List<String> names = List.of("Fred", "Jim", "Sheila");
    String searchForThis = new String("Fred");
    System.out.println(names.indexOf(searchForThis));

//    List<StringBuilder> names2 = List.of(
//        new StringBuilder("Fred"),
//        new StringBuilder("Jim"),
//        new StringBuilder("Sheila"));
//    StringBuilder searchForThis2 = new StringBuilder("Fred");
//    System.out.println(names2.indexOf(searchForThis2));
//
    StringBuilder f = new StringBuilder("Fred");
    StringBuilder f2 = f;
    List<StringBuilder> names2 = List.of(
        f,
        new StringBuilder("Jim"),
        new StringBuilder("Sheila"));
    System.out.println(names2.indexOf(f2));

  }
}

