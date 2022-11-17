package mainisjustamethod;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyMain {
  public static void main(String[] args) {
    System.out.println("Hello, this is MyMain.main!");
//    ProgOne.main(new String[0]);
//    ProgTwo.main(new String[0]);

    try (BufferedReader input =
             new BufferedReader(new FileReader("CodeToRun.txt"))) {
      String classname;
      while ((classname = input.readLine()) != null) {
        Class<?> cl = Class.forName(classname);
        System.out.println("loaded class " + cl);
        Object obj = cl.getConstructor().newInstance();
        System.out.println("object is " + obj);
        Method m = cl.getMethod("main", String[].class);
        System.out.println(m);
        String [] argValues = new String[]{"Hello"};
        m.invoke(null, (Object)argValues);
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("couldn't find " + fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("oops, IO problem!");
    } catch (ClassNotFoundException cnfe) {
      System.out.println("uh oh, that class didn't exist! "
          + cnfe.getMessage());
    } catch (NoSuchMethodException e) {
      System.out.println("no main method found in that class!");
    } catch (InvocationTargetException e) {
      System.out.println("oops, invocation target problem " + e.getMessage());
    } catch (IllegalAccessException e) {
      System.out.println("access problem with main method");;
    } catch (InstantiationException e) {
      System.out.println("Failed to instantiate object");
    }
    System.out.println("Wasn't that cool :)");
  }
}
