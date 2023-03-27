package ru.stqa.pft.sandbox;

import ru.stqa.pft.sandbox.Point;

import java.util.List;
import java.util.stream.Stream;

public class Program {
  public static void main(String[] args) {
//    Point a = new Point(0, 16);
//    Point b = new Point(12, 0);
//    distance(a, b);
//    System.out.println("distance = " + a.distance(b));

    List<Log> logs = List.of(
            new Log("Сибирская сосна", 10),
            new Log("Дуб монгольский", 30),
            new Log("Берёза Карликовая", 5));
    Stream <Log> logStream = logs.stream(); //link on stream
    Stream <Log> filteredStream = logStream
            .filter(x->x.getCount()>7)
            .filter(x-> !"Дуб монгольский".equalsIgnoreCase(x.getType()));
    logs.stream().map(x-> x.getType()).forEach(System.out::println);
//    filteredStream.forEach(x-> System.out.println(x.getType()));


    Stream<String>stringStream = Stream.of("asd", "aaa", "bbb");
//    Stream.builder().add("one").add("two").build().forEach(System.out::println);//new stream
    Stream.concat(Stream.of("aaa", "bbb", "ccc"), Stream.of("111","222","333")); //concat.. streams
    List.of("a", "b", "c").stream().forEach(System.out::println);//stream from collection


  }
  public static void distance(Point a, Point b) {
    System.out.println("distance = " + Math.sqrt((Math.pow((b.x-a.x),2)) + (Math.pow((b.y-a.y),2))));
  }
}
