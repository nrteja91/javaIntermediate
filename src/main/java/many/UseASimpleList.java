package many;

import java.util.ArrayList;
import java.util.Arrays;

public class UseASimpleList {
  public static void main(String[] args) {
//    ArrayList names = new ArrayList();
    // <xxx> is "generics"
//    ArrayList<String> names = new ArrayList<String>(Arrays.asList(99, "Jimmy"));
    ArrayList<String> names = new ArrayList<>(Arrays.asList(/*99, */"Jimmy"));
//    names.banana(99); // NOPE :)
    System.out.println("element zero is " + names.get(0));
    names.add("Fred");
    names.add("Jim");
    System.out.println(names);
    System.out.println(names.size());
    names.add("Sheila");
    names.set(1, "James");
    names.remove(0);
    System.out.println(names);
    System.out.println(names.size());

    // autoboxing... (see also auto-un-boxing)
//    names.add(99); // this is identical in effect to the below
//    names.add(Integer.valueOf(99));

    // NOPE, it's 99!!! which is an Integer, not a String
    // (xxx) is called a "cast"
    // if it's not a string, it will throw a ClassCastException
    // during execution
//    String s = (String)names.get(0);
    String s = names.get(0);
  }
}
