package implinherit;
//
//interface Date {
//  int getDay();
//  int getMonth();
//  int getYear();
//}

//class SimpleDate implements Date {
public class Date /*extends Object*/ {
  private int day;
  private int month;
  private int year;

//  public SimpleDate(int day, int month, int year) {
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public int getYear() {
    return year;
  }

  @Override
  public String toString() {
    return "Date{" +
        "day=" + day +
        ", month=" + month +
        ", year=" + year +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    // THE BAD FORM OF EQUALS!!!! for demo if I remember
    if (o instanceof Date other) { // Newer Java only!!!!
      return this.day == other.day
          && this.month == other.month
          && this.year == other.year;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    int result = day;
    result = 31 * result + month;
    result = 31 * result + year;
    return result;
  }
}

// "prefer composition over inheritance"
// investigate the "strategy" (and "command") patterns
final class Holiday extends Date {
//  int day, month, year, constructor to initialize, get..., toString
  // add this extra feature
  String name;

  public Holiday(int day, int month, int year, String name) {
    super(day, month, year);
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Holiday: " + name + " on " + super.toString();
  }
}

//class Weird extends Holiday {
//  public Weird(int day, int month, int year, String name) {
//    super(day, month, year, name);
//  }
//}

class UseADate {
  public static void announce(Date d, String message) {}

  public static void main(String[] args) {
    Date d = new Date(10, 3, 2023);
    Date d2 = new Date(10, 3, 2023);
    System.out.println(d);
    System.out.println(d.equals(d2));
    System.out.println("the day is " + d. getDay());
    Holiday d3 = new Holiday(1, 1, 2023, "New Year's Day");
    System.out.println("The holiday is " + d3/*.toString()*/);
    System.out.println("day of month of holiday is " + d3.getDay());
    System.out.println("Holiday's name is " + d3.getName());
    Date d4 = d3;
    if (d4 instanceof Holiday) {
      System.out.println("Holiday's name is " + ((Holiday)d4).getName());
    }
  }
}


