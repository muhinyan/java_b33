package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

    Point a = new Point(0, 3);
    Point b = new Point(4, 0);

    @Test
    public void testDistance_1() {
        Assert.assertEquals(a.distance(b),5.0);
    }

    @Test
    public void testDistance_2() {
        Assert.assertTrue(a.distance(b)==6.0, "Расстояние неверное");
    }

    @Test
    public void testDistance_3() {
        Assert.assertFalse(a.distance(b)==15.0);
    }
}
