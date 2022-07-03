package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

    Point a = new Point(-30, 0);
    Point b = new Point(0, -4);

    @Test
    public void testDistance_1() {
        Assert.assertTrue(a.distance(b)>=0, "Расстояние не может быть меньше нуля");
    }

    @Test
    public void testDistance_2() {
        a.x = -5;
        a.y = -3;
        b.x = -2;
        b.y = -7;
        Assert.assertEquals(a.distance(b),5.0);
    }

    @Test
    public void testDistance_3() {
        a.x = 0;
        a.y = 0;
        b.x = 0;
        b.y = 0;
        Assert.assertEquals(a.distance(b), 0);
    }

    @Test
    public void testDistance_4() {
        a.x = 0;
        a.y = 12;
        b.x = 16;
        b.y = 0;
        Assert.assertEquals(a.distance(b),20.0);
    }



}
