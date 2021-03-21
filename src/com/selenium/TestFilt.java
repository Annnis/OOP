package com.selenium;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;

import static com.selenium.Constant.*;

public class TestFilt {
    private static List<Device> expected;
    private static List<Device> actual;
    private static String [] a;
    private static String [] b;


    @BeforeEach
    public void setUp(){
        expected = new ArrayList<>();
    }
    @Test
    public void test_filterByArchitecture(){
        expected.add(samsungS20);
        expected.add(samsungA8);
        expected.add(iphone10);
        expected.add(samsungS10);
        expected.add(samsungA7);
        expected.add(iphone11);
        actual = Filter.filterByArchitecture(devices, "ARM");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_filterByCash(){
        expected.add(myComputer1);
        expected.add(myComputer2);
        expected.add(myComputer3);
        expected.add(myComputer4);
        actual = Filter.filterByCash(devices, 8);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_filterByFrequency() {
        expected.add(myComputer1);
        expected.add(myComputer3);
        actual = Filter.filterByFrequency(devices, 3.7);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void test_filterByBitCapacity(){
        expected.add(samsungS20);
        expected.add(samsungA8);
        expected.add(samsungS10);
        expected.add(samsungA7);
        actual = Filter.filterByBitCapacity(devices, 32);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_filter_TotalMemory_MoreThan_Value(){
        expected.add(myComputer1);
        expected.add(myComputer2);
        expected.add(myComputer3);
        expected.add(myComputer4);
        actual = Filter.filter_TotalMemory_MoreThan_Value(devices, 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_filter_TotalMemory_LessThan_Value(){
        expected.add(samsungS20);
        expected.add(samsungA8);
        expected.add(iphone10);
        expected.add(samsungS10);
        expected.add(samsungA7);
        expected.add(iphone11);
        actual = Filter.filter_TotalMemory_LessThan_Value(devices, 7);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void test_filter_ByMoreOccupiedMemory() {
        a = new String[]{"Test", "Robot"};
        myComputer1.save(a);
        b = new String[]{"Test", "Robot", "Cash"};
        myComputer3.save(b);
        expected.add(myComputer1);
        expected.add(myComputer3);
        actual = Filter.filter_OccupiedMemory_MoreThan_Value(devices, 20.1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test20_filter_ByLessOccupiedMemory() {
        a = new String[]{"Test", "Robot"};
        myComputer1.save(a);
        b = new String[]{"Test", "Robot", "Cash"};
        myComputer3.save(b);
        expected.add(samsungS20);
        expected.add(samsungA8);
        expected.add(myComputer2);
        expected.add(iphone10);
        expected.add(samsungS10);
        expected.add(samsungA7);
        expected.add(myComputer4);
        expected.add(iphone11);
        actual = Filter.filter_OccupiedMemory_LessThan_Value(devices, 10.1);
        Assertions.assertEquals(expected, actual);
    }
}