package school;

public class School {
  public static void main(String[] args) {
    Student fred = null;
//    System.out.println(fred.gpa);
//    new Student();
    fred = new Student("Fred", 3.2);
//    fred.name = "";
//    fred.gpa = 100; // changes creating invalid state!!!

    try {
      Student jim = new Student("", 0.1);
    } catch (IllegalArgumentException ie) {
      System.out.println("Ooops, that doesn't seem to work");
    }
    System.out.println("Program still running!");

    Student sheila = null;
    try {
      System.out.println("about to make Sheila");
      sheila = new Student("Sheila", 3.9);
//      System.out.println("Sheila created");
//      System.out.println("Sheila's name is " + sheila.name);
      System.out.println("Created: " + Student.asText(sheila));
    } catch (IllegalArgumentException ie) {
      System.out.println(ie);
//      System.out.println(sheila.name);
    }
//    System.out.println(sheila.name);

  }
}
