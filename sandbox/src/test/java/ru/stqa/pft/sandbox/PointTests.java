package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

    @Test
    public void testDistance_1() {
        Point a = new Point(-30, 0);
        Point b = new Point(0, -4);
        Assert.assertTrue(a.distance(b)>=0, "Расстояние не может быть меньше нуля");
    }

    @Test
    public void testDistance_2() {
        Point a = new Point(-5, -3);
        Point b = new Point(-2, -7);
        Assert.assertEquals(a.distance(b),5.0);
    }

    @Test
    public void testDistance_3() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Assert.assertEquals(a.distance(b), 0);
    }

    @Test
    public void testDistance_4() {
        Point a = new Point(0, 12);
        Point b = new Point(16, 0);
        Assert.assertEquals(a.distance(b),20.0);
    }



}
