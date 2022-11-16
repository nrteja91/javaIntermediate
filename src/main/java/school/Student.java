package school;

//import java.util.*; // not considered good style

//import java.lang.System;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

public class Student {
  private String name;
  private double gpa;
  ArrayList<String> courses;

  // code here has access to name, gpa, and something

  class Helper {
    private String something;
    // code here has access to name, gpa, and something
  }

//  public Student(String name, double gpa, ArrayList<String> courses) {
  public Student(String name, double gpa, String ... courses) {
//    if (!isValid(name, gpa)) // logical inverse
    if (isValid(name, gpa)) {
      this.name = name;
      this.gpa = gpa;
      this.courses = new ArrayList<String>(Arrays.asList(courses));
    } else {
//      this.name = "unknown";
//      this.gpa = 0.0; // unnecessary!
      throw new IllegalArgumentException("Bad name or gpa for Student");
    }
  }

  // expressions of Object type (anything except the
  // 8 primitives:
  // boolean byte short char int long float double
  // are ALWAYS "references" (very similar to pointers)
  // they tell you where to find the data
  // we have the special "where" value null -- which
  // indicates "there is no value"
  public static boolean isValid(String name, double gpa) {
    return gpa >= 0.0 && gpa <= 5.0
        && name != null && name.length() > 0;
  }

  // Non-OO "procedural" approach: call this method
  // in a "verb, object" grammar
  public static String asText(Student s) {
    return "Student: name=" + s.name + ", gpa=" + s.gpa;
  }

  // OO version, call this method in a subject, verb, possbibly object grammar
  // remove word static.
  // first argument then is and must be:
  //  - of the enclosing class type
  //  - called "this"
  public String asText(Student this) {
    return "Student: name=" + this.name + ", gpa=" + this.gpa;
  }

//  public static void setName(Student s, String n) {
//  public void setName(@Interesting Student this, String n) {
//  public void setName(/*Student this, */String n) {
  public void setName(String n) {
//    if (isValid(n, s.gpa)) {
    if (isValid(n, this.gpa)) {
//      s.name = n;
      this.name = n;
    } else {
      throw new IllegalArgumentException("Bad name for Student");
    }
  }

//  public static String getName(Student s) {
  public String getName(Student this) {
//    return s.name;
    return this.name;
  }

/*  public static void main(String[] args) {
    Student fred = new Student();
    fred.name = "Fred"; // double quotes makes a String literal
    fred.gpa = 3.2; // numbers with decimals etc. 1E+6 are double literals

    out.println(fred.name); // because of import static java.lang.System.out;
    System.out.println(fred.gpa);

  }*/
}

/*
class Oddball {
  public static void main(String[] args) {
    System.out.println("Hello ");
  }
}*/

/*
1) create validity check for your student
2) create a constructor that checks validity
3) build enough code to verify that a valid student is made,
   and is initialized with good contents
4) build more code, so as to verify that an INVALID student
   blows up.
For those more comfortable.
5) add a try/catch structure to print a polite message about
   the invalid student and then carry on with execution
6) add methods to update the name, and the gpa (separate methods)
   and similarly validate the proposed change.
 */