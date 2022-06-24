

public class Program {
  public static void main(String[] args) {
    Point a = new Point(2, 3);
    Point b = new Point(4, 7);
    distance(a, b);
    System.out.println("distance = " + a.distance(b));
  }
  public static void distance(Point a, Point b) {
    System.out.println("distance = " + Math.sqrt((Math.pow((b.x-a.x),2)) + (Math.pow((b.y-a.y),2))));
  }
}
