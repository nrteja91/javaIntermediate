package morestudents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
  private String name;
  private double gpa;
  private List<String> courses;

  // exposed constructors are a maintenance problem avoid them
  private Student(String name, double gpa, List<String> courses) {
    this.name = name;
    this.gpa = gpa;
    this.courses = courses;
  }

  // for immutability:
  // - check you don't simply use caller-provided mutable objects
  // - avoid returning mutable objects to callers
  // - don't provide set methods that change your object
  //   consider "with" methods that create new objects reflecting the change

  // if initialization is "complex" e.g. many fields some of which
  // might be ignored in some situations, or too many combinations
  // for clean interface, might use a "builder" pattern
  public static class Builder {
    private String name;
    private double gpa;
    private List<String> courses = new ArrayList<>();

    private Builder() {}

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder gpa(double gpa) {
      this.gpa = gpa;
      return this;
    }

    public Builder course(String course) {
      courses.add(course);
      return this;
    }

    public Student build() {
      // VALIDATE!!!!
      return new Student(this.name, this.gpa,
          Collections.unmodifiableList(this.courses));
    }
  }

  public static Builder builder() {
    return new Builder();
  }

  // method can return a new object, or an old object
  // and can return the exact type, or an specialized type
  public static Student of(String name, double gpa, String... courses) {
    // validate
    return new Student(name, gpa, List.of(courses));
  }

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  // in our case, this is an immutable list!
  // if it were not the caller could now change it
  // investigate Collections.unmodifiableList(mylist) if
  // mylist is mutable :)
  public List<String> getCourses() {
    return courses;
  }

  public Student withGpa(double gpa) {
    // validate
    // can return an object containing shared fields
    // PROVIDED those fields are immutable!!!
    return new Student(this.name, gpa, this.courses);
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }
}

class TryTheBuilder {
  public static void main(String[] args) {
    Student.Builder b = Student.builder();

    Student s1 = b
        // set fields in the "template"
        .name("Fred")
        .course("Math")
        .gpa(3.2)
        .course("Physics")
    // build the real thing (which involves validation)
        .build();

    Student s2 = b
        .name("Albert")
        .build();
    System.out.println("s1 is " + s1);
    System.out.println("s2 is " + s2);
  }
}