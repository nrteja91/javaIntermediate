package school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registration {
  public static String readALine(BufferedReader br) throws IOException {
    return br.readLine();
  }

  public static void main(String[] args) {
    BufferedReader input =
        new BufferedReader(new InputStreamReader(System.in));

    boolean success = false;
    while (!success) {
      try {
        System.out.print("Enter a name: ");
        String name = readALine(input);
        System.out.print("Enter a gpa: ");
        String gpaText = readALine(input);
        double gpa = Double.parseDouble(gpaText);
        Student s = new Student(name, gpa);
        System.out.println("Created: " + Student.asText(s));
        success = true;
      } catch (IllegalArgumentException e) {
//      e.printStackTrace();
        System.out.println(e);
      } catch (IOException ioe) {
        System.out.println("uh oh, bad stuff in the input-output");
      }
    }
    System.out.println("Continuing");



//    System.exit(3);
//    System.out.println("Really???");
  }
}
