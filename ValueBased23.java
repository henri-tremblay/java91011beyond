public class ValueBased23 {

  public static void main(String[] args) {
    Double d = 20.0;
    synchronized (d) {  // javac warning & HotSpot warning
      System.out.println(d);
    }
    Object o = d;
    synchronized (o) { // HotSpot warning
      System.out.println(o);
    }

    Integer i = new Integer(1);
  }
}


//  @jdk.internal.ValueBased
