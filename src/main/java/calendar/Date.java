package calendar;

public class Date {
  int day;
  int month;
  int year;

  // isThisALeapYear year
  public static boolean isLeapYear(int year) {
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  // howManyDaysInThisMonth month, year
  public static int daysInMonth(int month, int year) {
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("Bad month");
    }
//    if (month == 9 || month == 4 || month == 6 || month == 11)
/*
    switch (month) {
      case 9: case 4: case 6: case 11:
        return 30;
      case 2:
//        int days;
//        if (isLeapYear(year)) {
//          days = 29;
//        } else {
//          days = 28;
//        }
//        return days;
        return isLeapYear(year) ? 29 : 28;
      default:
        return 31;
    }
*/
/*
    int days;
    switch (month) {
      case 9: case 4: case 6: case 11:
        days = 30;
        break; // YUKKY!!!! DON'T FORGET THE BREAK
      case 2:
        days = isLeapYear(year) ? 29 : 28;
        break;
      default:
        days = 31;
        break;
    }
    return days;
*/
/*
    int days;
    switch (month) {
      // must follow arrow with a *single* expression/statement
      // use curlies to group multiple into one.
      case 9, 4, 6, 11 -> {
        int intermediate = 20;
        days = intermediate + 10;
      }
      case 2 -> days = isLeapYear(year) ? 29 : 28;
      default -> days = 31;
    }
    return days;
*/
    return switch (month) {
      case 9, 4, 6, 11 -> {
        int intermediate = 20;
        yield intermediate + 10; // yield NOT return!!!
      }
      case 2 -> isLeapYear(year) ? 29 : 28;
      default -> 31;
    };

  }


  // get this by default if ZERO coded "initializers"
  // called "constructors"
//  public Date() {}

  // "new" creates an object of this type, fills it with zeroes
  // then calls this initializer (constructor) and passes the
  // newly created object into the constructor as a hidden/implicit
  // argument called this.
  public Date(/*Date this, */int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
}

class BreakADate {
  public static void main(String[] args) {
//    Date d = new Date(); // INVALID 0, 0, 0
    Date d = new Date(28, 2, 2022);
//    d.day = 31;
//    d.month = 2;
//    d.year = 2020;
    System.out.println(d.day);
  }
}