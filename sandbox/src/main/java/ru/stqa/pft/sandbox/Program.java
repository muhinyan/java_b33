package ru.stqa.pft.sandbox;

import ru.stqa.pft.sandbox.Point;

public class Program {
  public static void main(String[] args) {
    Point a = new Point(0, 16);
    Point b = new Point(12, 0);
    distance(a, b);
    System.out.println("distance = " + a.distance(b));
  }
  public static void distance(Point a, Point b) {
    System.out.println("distance = " + Math.sqrt((Math.pow((b.x-a.x),2)) + (Math.pow((b.y-a.y),2))));
  }
}
