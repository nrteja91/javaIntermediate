package morestudents;

import java.util.ArrayList;
import java.util.List;

// Java has a package full of 43 different pre-defined
// generally useful interfaces

// this one below would be a Predicate<Student>
interface StudentCriterion {
  boolean test(Student s);
}

class SmartStudentCriterion implements StudentCriterion {
  @Override
  public boolean test(Student s) {
    return s.getGpa() > 3;
  }
}

// we are creating an OBJECT (i.e. instance) that implements an interface
// the interface declares EXACTLY ONE abstract method
// that is the ONLY method we actually want to implement
class EnthusiasticStudentCriterion implements StudentCriterion {
  @Override
  public boolean test(Student s) {
    return s.getCourses().size() > 3;
  }
}

public class School {

  public static void showAllStudents(Iterable<Student> is) {
    for (Student s : is) {
      System.out.println(s);
    }
  }

  // passing an object primarily for its BEHAVIOR rather than state
  // in OO is called a "Command" pattern
  // in fuctional design is simply a "higher order function"
  public static List<Student> getStudentsByCriterion(
      Iterable<Student> is, StudentCriterion crit) {
    List<Student> results = new ArrayList<>();
    for (Student s : is) {
      if (crit.test(s)) {
        results.add(s);
      }
    }
    return results;
  }

//  public static List<Student> getSmartStudents(
//      Iterable<Student> is, double threshold) {
//    List<Student> results = new ArrayList<>();
//    for (Student s : is) {
//      if (s.getGpa() > threshold) {
//        results.add(s);
//      }
//    }
//    return results;
//  }
//
//  public static void showAllSmartStudents(
//      Iterable<Student> is, double threshold) {
//    for (Student s : is) {
//      if (s.getGpa() > threshold) {
//        System.out.println(s);
//      }
//    }
//  }
//
//  public static void showAllEnthusiasticStudents(
//      Iterable<Student> is, int threshold) {
//    for (Student s : is) {
//      if (s.getCourses().size() > threshold) {
//        System.out.println(s);
//      }
//    }
//  }

  public static void main(String[] args) {
    List<Student> roster = List.of(
      Student.of("Fred", 3.2, "Math", "Physics"),
      Student.of("Jim", 2.2, "Journalism"),
      Student.of("Sheila", 3.9,
          "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    showAllStudents(roster);
//    System.out.println("smart ---------------------");
//    showAllSmartStudents(roster, 3.0);
//    System.out.println("very smart---------------------");
//    showAllSmartStudents(roster, 3.5);
//    System.out.println("enthusiastic---------------------");
//    showAllSmartStudents(roster, 3);

//    System.out.println("smart ---------------------");
//    showAllStudents(getSmartStudents(roster, 3.0));
//    System.out.println("very smart---------------------");
//    showAllStudents(getSmartStudents(roster, 3.5));
//    System.out.println("enthusiastic---------------------");
//    showAllStudents(getEnthusiastic....(roster, 3);

//    System.out.println("smart ---------------------");
//    showAllStudents(
//        getStudentsByCriterion(roster, new SmartStudentCriterion()));
//    System.out.println("enthusiastic---------------------");
//    showAllStudents(
//        getStudentsByCriterion(roster, new EnthusiasticStudentCriterion()));

    System.out.println("smart ---------------------");
    showAllStudents(
        // at the point ??? the compiler KNOWS the ONLY valid
        // argument would be an object implementing StudentCriterion
//        getStudentsByCriterion(roster, ???));
        getStudentsByCriterion(roster,
            (Student s) -> {
              return s.getGpa() > 3;
            }

            ));
//    System.out.println("enthusiastic---------------------");
//    showAllStudents(
//        getStudentsByCriterion(roster,
//            (Student s) -> {
//              return s.getCourses().size() > 2;
//            }
//            ));
    System.out.println("enthusiastic---------------------");
    showAllStudents(
        getStudentsByCriterion(roster, s -> s.getCourses().size() > 2));
  }
}
