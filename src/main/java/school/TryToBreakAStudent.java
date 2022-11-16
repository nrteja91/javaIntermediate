package school;

import static school.Student.asText;

public class TryToBreakAStudent {
  public static void main(String[] args) {
    Student s = new Student("Fred", 3.2);
    System.out.println(asText(s));
//    s.name = "";
//    s.gpa = 400;

//    System.out.println("Student's name is: " + Student.getName(s));
//    Student.setName(s, "");
    System.out.println("Student's name is: " + s.getName());
    s.setName("");
    System.out.println(asText(s));

  }
}
