package interfaces;

import school.Student;

import java.time.LocalDateTime;
import java.util.*;

public class UsingLists {
  // code to the most general generalization (usually an interface)
  // that supports the actions you require (but no more general)
  public static void showAll(Iterable<?> als) {
    for (Object s : als) {
      System.out.println("> " + s/*.toString()*/);
    }
  }

  public static void main(String[] args) {
//    LinkedList<String> names =
    List<String> names =
        new LinkedList<>(Arrays.asList("Fred", "Jim", "Sheila"));
    showAll(names);

//    ArrayList<String> moreNames =
    List<String> moreNames =
        // Arrays.asList (use with Java 8 and older) creates a "view"
        // on an existing array. You cannot change the length!!!!
//        new ArrayList<>(Arrays.asList("Albert", "Francis", "Bill"));

        // List.of (Java 9+) creates an unmodifiable List
        new ArrayList<>(List.of("Albert", "Francis", "Bill"));

//        new LinkedList<>(Arrays.asList("Albert", "Francis", "Bill"));
    showAll(moreNames);

    Set<String> coursesBeingTaken = new HashSet<>();
    coursesBeingTaken.add("Math");
    coursesBeingTaken.add("Physics");
    coursesBeingTaken.add("Chemistry");
    coursesBeingTaken.add("Math");
    System.out.println(coursesBeingTaken);

    showAll(coursesBeingTaken);

    System.out.println("--------------------");
//    names.remove(1);
//    names.remove("Sheila");
    boolean removed = names.remove("Albert");
    System.out.println("removed? " + removed);
//    removed = names.remove("Sheila");
//    System.out.println("removed? " + removed);
    System.out.println(names);
    System.out.println(names.indexOf("Jim"));
    System.out.println(names.lastIndexOf("Jim"));

    Student st1 = new Student("Fred", 3.2);
    Student st2 = new Student("Jim", 2.2);
    System.out.println(st1.asText());
    st1.setName("Frederick");
    System.out.println(st1.asText());

    List<String> ls = List.of("Fred", "Jim");
    System.out.println(ls);
//    ls.add("Nope");
//    ls.set(0, "Albert");
//    ls.remove("Albert");
    System.out.println(ls.get(0));

    List<Student> ls2 = List.of(st1, st2);
    System.out.println(ls2);
    ls2.get(0).setName("Achibald");
    System.out.println(ls2);


    showAll(List.of(99, 100, 101));
    System.out.println("-------------------");
    showAll(List.of(
        LocalDateTime.now(),
        LocalDateTime.now().plusDays(1),
        LocalDateTime.now().minusHours(36)
        ));
  }
}
