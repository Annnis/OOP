package com.selenium;

import org.junit.jupiter.api.*;
import java.util.List;
import java.util.ArrayList;
public class TestFilt {

    private List<Device> devicesList = new ArrayList<>();
    private String[] testData = {"qwe", "rty", "uio"};
    Device myComputer1 = new Device(new ProcessorX86(3.7, 8, 64), new Memory(new String[7]));
    Device samsungS20 = new Device(new ProcessorArm(2.84, 3, 32), new Memory(new String[5]));
    Device samsungA8 = new Device(new ProcessorArm(2.24, 3, 32), new Memory(new String[5]));
    Device myComputer2 = new Device(new ProcessorX86(3.9, 8, 64), new Memory(new String[9]));
    Device iphone10 = new Device(new ProcessorArm(2.34, 3, 64), new Memory(new String[5]));
    Device myComputer3 = new Device(new ProcessorX86(3.7, 8, 64), new Memory(new String[7]));
    Device samsungS10 = new Device(new ProcessorArm(2.84, 3, 32), new Memory(new String[5]));
    Device samsungA7 = new Device(new ProcessorArm(2.24, 3, 32), new Memory(new String[5]));
    Device myComputer4 = new Device(new ProcessorX86(3.9, 8, 64), new Memory(new String[9]));
    Device iphone11 = new Device(new ProcessorArm(2.34, 3, 64), new Memory(new String[5]));

    public void setUp() {
        myComputer1.save(testData);
        samsungS20.save(testData);
        samsungA8.save(testData);
        myComputer2.save(testData);
        iphone10.save(testData);
        myComputer3.save(testData);
        samsungS10.save(testData);
        samsungA7.save(testData);
        myComputer4.save(testData);
        iphone11.save(testData);
    }

    Device[] devices = new Device[]{myComputer1, samsungS20, samsungA8, myComputer2, iphone10, myComputer3, samsungS10, samsungA7, myComputer4, iphone11};


    @Test
    public void test_filterByArchitecture() {
        List<Device> expected = new ArrayList<>();
        expected.add(samsungS20);
        expected.add(samsungA8);
        expected.add(iphone10);
        expected.add(samsungS10);
        expected.add(samsungA7);
        expected.add(iphone11);
        List<Device> actual = Filter.filtrateByArchitecture(devices, "ARM");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_filterByCash() {
        List<Device> expected = new ArrayList<>();
        expected.add(myComputer1);
        expected.add(myComputer2);
        expected.add(myComputer3);
        expected.add(myComputer4);
        List<Device> actual = Filter.filtrateByCash(devices, 8);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void test_filterByBitCapacity() {
        List<Device> expected = new ArrayList<>();
        expected.add(samsungS20);
        expected.add(samsungA8);
        expected.add(samsungS10);
        expected.add(samsungA7);
        List<Device> actual = Filter.filtrateByBitCapacity(devices, 32);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_filter_TotalMemory_MoreThan_Value() {
        List<Device> expected = new ArrayList<>();
        expected.add(myComputer1);
        expected.add(myComputer2);
        expected.add(myComputer3);
        expected.add(myComputer4);
        List<Device> actual = Filter.filtrateByMoreTotalMemory(devices, 5);
        Assertions.assertEquals(expected, actual);
    }
}
//
////        @Test
////        public void test_filter_TotalMemory_LessThan_Value(){
////            List<Device> expected = new ArrayList<>();
////            expected.add(samsungS20);
////            expected.add(samsungA8);
////            expected.add(iphone10);
////            expected.add(samsungS10);
////            expected.add(samsungA7);
////            expected.add(iphone11);
////            List<Device> actual = Filter.filtrateByTotalMemory(devices, 7);
////            Assertions.assertEquals(expected, actual);
//        }
//
////    @Test
////    public void test_filter_OccupiedMemory_MoreThan_Value(){
////        List<Device> expected = new ArrayList<>();
////        expected.add(samsungS20);
////        expected.add(samsungA8);
////        expected.add(iphone10);
////        expected.add(samsungS10);
////        expected.add(samsungA7);
////        expected.add(iphone11);
////        List<Device> actual = Filter.filtrateByMoreOccupiedMemory(devices, 1);
////        Assertions.assertEquals(expected, actual);
//    }
//
////    @Test
////    public void test_filter_OccupiedMemory_LessThan_Value(){
////        List<Device> expected = new ArrayList<>();
////        expected.add(samsungS20);
////        expected.add(samsungA8);
////        expected.add(iphone10);
////        expected.add(samsungS10);
////        expected.add(samsungA7);
////        expected.add(iphone11);
////        List<Device> actual = Filter.filtrateByLessOccupiedMemory(devices, 0);
////        Assertions.assertEquals(expected, actual);
//    }
////    @Test
////    public void test_filterByFrequency(){
////        List<Device> expected = new ArrayList<>();
////        expected.add(iphone10);
////        expected.add(samsungA7);
////        List<Device> actual = Filter.filtrateByFrequency(devices, 3.7);
////        Assertions.assertEquals(actual, expected);
////    }
//    }
//
