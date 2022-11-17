package interfaces;

import java.util.ArrayList;

interface Photographer {
  String takePhotograph(String s);
}

class SpySatellite implements Photographer {
  public String takePhotograph(String subject) {
    return "Grainy photo of your license plate, big brother is watching you";
  }

  public void launch() {
    System.out.println("Lots of noise, and a smell of burning hydrazine!");
  }
}

class HumanPhotographer implements Photographer {
  public String takePhotograph(String subject) {
    return "Bright photo of someones kids pulling strange faces";
  }
}

class ProfessionalPhotographer implements Photographer {
  public String takePhotograph(String subject) {
    System.out.println("large bill to pay please");
    return "Tonaly delicious image of children looking angelic (despte not being!)";
  }
}

class PhotoCompany {
  ArrayList<Photographer> staff = new ArrayList<>();

  public PhotoCompany(Photographer ... staff) {
    for (Photographer p : staff) {
      this.staff.add(p);
    }
  }
}

public class Examples {
  public static void main(String[] args) {
//    String s = new String("Hello");
    Object s = new String("Hello");
    Object ss = new SpySatellite();
    Object hp = new HumanPhotographer();
    Object pp = new ProfessionalPhotographer();


    System.out.println(s.getClass().getName());
    System.out.println(ss.getClass().getName());
    System.out.println(hp.getClass().getName());
    System.out.println(pp.getClass().getName());

    // All FAIL, Object doesn't take photographs
//    s.takePhotograph("Target");
//    ss.takePhotograph("Target");
//    hp.takePhotograph("Target");
//    pp.takePhotograph("Target");

    // String can't take photograph ever...
//    s.takePhotograph();
// The "old" way (pre Java 16, so not that old!)
//    if (ss instanceof SpySatellite) {
//      System.out.println(((SpySatellite) ss).takePhotograph("Target"));
//      ((SpySatellite) ss).launch();
//    }

    // new way, Java 16 onwards, called "pattern matching for instanceof"
    if (ss instanceof SpySatellite theSpy) {
      System.out.println(theSpy.takePhotograph("Target"));
      theSpy.launch();
    }

    System.out.println(((HumanPhotographer)hp).takePhotograph("Target"));
    // this can't work, you can't launch a human!
//    ((HumanPhotographer)hp).launch();
//    pp.takePhotograph("Target");
    System.out.println(((ProfessionalPhotographer)pp).takePhotograph("Target"));
    System.out.println("all done");

//    Object [] things = {ss, hp, pp};
//    for (Object obj : things) {
//      // hard work!!!
//    }

    System.out.println("-------------------");
    Photographer [] things = {
        new SpySatellite(),
        new ProfessionalPhotographer(),
        new HumanPhotographer(), // can have trailing comma in array literal
    };
    for (Photographer p : things) {
      System.out.println(p.takePhotograph("Subject"));
    }
    System.out.println("-------------------");

    Photographer volunteer = new ProfessionalPhotographer();
    PhotoCompany pc = new PhotoCompany(
        volunteer,
        new HumanPhotographer(),
        new HumanPhotographer()
    );
  }
}
