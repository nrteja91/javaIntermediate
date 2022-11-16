package many;

import java.util.Arrays;

public class UseArrays {
//  public static void showAllElements(String[] sa) {
/*
    int idx = 0;
    while (idx < sa.length) {
      System.out.println("> " + sa[idx++]);
//      idx = idx + 1;
//      idx += 1;
//      idx++; // ++x x++ --x x--
    }
*/
//    int idx = 0;
//    while (idx < sa.length) {
//      System.out.println("> " + sa[idx]);
//      idx++;
//    }

//    for (int idx = 0; idx < sa.length; idx++) {
//      System.out.println("> " + sa[idx]);
//    }

//  public static void showAllElements(String[] sa) {
  public static void showAllElements(String ... sa) {
    System.out.println(sa.getClass().getName());
    for (String s : sa) {
      System.out.println("> " + s);
    }
  }

  public static void main(String[] args) {
    // variable decl:
    // "type" variable name [ = initialization ];
    // arrays are objects, create with new...
    String[] names = new String[3];
    // subscripts are always zero-based, int type
    // arrays are totally contiguous
    // once created, length is FIXED
    System.out.println("names[0] = " + names[0]);
    names[0] = "Fred";
    names[2] = "Sheila";
    System.out.println("names is " + Arrays.toString(names));
    showAllElements(names);
    System.out.println("-------------------");
    String s1 = "William";
    String s2 = "Bert";
//    String [] moreNames = new String[2];
//    moreNames[0] = s1;
//    moreNames[1] = s2;
//    String [] moreNames = new String[]{s1, s2};
    String [] moreNames = {s1, s2};
    showAllElements(moreNames);
    showAllElements(new String[]{s1, s2});
// NOPE, only use the short form for initializing an array *variable*
//    showAllElements({s1, s2});
    showAllElements(s1, s2);
    System.out.println("-------------------");
    showAllElements("Alice", "Bob", "Charles");
    // no "multi-dimensional arrays" But, arrays of arrays
  }
}
