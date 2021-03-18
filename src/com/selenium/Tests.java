package com.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Tests {


    @Test
    public void test_dataProcess_String_ProcessorX86() {
        ProcessorX86 processorX86 = new ProcessorX86(3.7, 8, 64);
        String actual = processorX86.dataProcess("12345");
        String expected = "processor is using on architecture x86 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_Long_ProcessorX86() {
        ProcessorX86 processorX86 = new ProcessorX86(3.7, 8, 64);
        String actual = processorX86.dataProcess(12345);
        String expected = "processor is using on architecture x86 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_getDetails_ProcessorX86() {
        ProcessorX86 processorX86 = new ProcessorX86(3.7, 8, 64);
        String actual = processorX86.getDetails();
        String expected = "Частота процессора: 3.7 GHz, кеш: 8.0 Mb, разрядность: 64-bit, architecture: X86";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_String_ProcessorARM() {
        ProcessorArm processorArm = new ProcessorArm(3.7, 8, 64);
        String actual = processorArm.dataProcess("545");
        String expected = "PROCESSOR IS USING ON ARCHITECTURE ARM 545";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_Long_ProcessorARM() {
        ProcessorArm processorArm = new ProcessorArm(3.7, 8, 64);
        String actual = processorArm.dataProcess(545);
        String expected = "processor is using on architecture arm 545";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_getDetails_ProcessorARM() {
        ProcessorArm processorArm = new ProcessorArm(3.7, 8, 64);
        String actual = processorArm.getDetails();
        String expected = "Частота процессора: 3.7 GHz, кеш: 8.0 Mb, разрядность: 64-bit, architecture: ARM";
        Assertions.assertEquals(actual, expected);
    }

    //    @Test
//    public void test_clearMemoryCell_Memory(){
//        String[] memory = new String[]{"hg 4","fgrgr"};
//        String actual = Memory.clearMemoryCell(memory);
//        String expected = "Частота процессора: 3.7 GHz, кеш: 8.0 Mb, разрядность: 64-bit, architecture: ARM";
//        Assertions.assertEquals(actual, expected);
//    }
    @Test
    public void test_readLast_Memory() {
        String[] nemory = new String[]{"hg 4","fgrgr"};
        Memory memory = new Memory(nemory);
        String actual = memory.readLast();
        String expected = "fgrgr";
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void test_removeLast_Memory() {
        String[] nemory = new String[]{"hg 4","fgrgr"};
        Memory memory = new Memory(nemory);
        String actual = memory.removeLast();
        String expected = "fgrgr";
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void test_save_false_Memory() {
        String[] nemory = new String[]{"hg 4","fgrgr"};
        Memory memory = new Memory(nemory);
        boolean actual = memory.save("jhu");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void test_save_true_Memory() {
        String[] nemory = new String[]{"hg 4",null};
        Memory memory = new Memory(nemory);
        boolean actual = memory.save("jhu");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }
//    @Test
//    public void test_toString_Memory() {
//        String[] nemory = new String[]{"hg 4",null};
//        Memory memory = new Memory(nemory);
//        String actual = memory.toString();
//        boolean expected = true;
//        Assertions.assertEquals(actual, expected);
//    }
@Test
public void test_save_true_Device() {
    Device device = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[2]));
    String[] nemory = new String[]{"hg 4",null};
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
       // Device.save(nemory);
        device.save(nemory);
        String expected = "We are out of bounds";
        String actual = outputStreamCaptor.toString();
        Assertions.assertEquals(expected, actual);
        Assertions.assertArrayEquals(nemory, device.getMemory().getMemoryCell());
    }






    private List<Device> devicesList = new ArrayList<>();
    private String[] testData = {"qwe", "rty", "uio"};
    Device myComputer1 = new Device(new ProcessorX86(3.7,8,64), new Memory(new String[7]));
    Device samsungS20 = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[5]));
    Device samsungA8 = new Device(new ProcessorArm(2.24,3,32), new Memory(new String[5]));
    Device myComputer2 = new Device(new ProcessorX86(3.9,8,64), new Memory(new String[9]));
    Device iphone10 = new Device(new ProcessorArm(2.34,3,64), new Memory(new String[5]));
    Device myComputer3 = new Device(new ProcessorX86(3.7,8,64), new Memory(new String[7]));
    Device samsungS10 = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[5]));
    Device samsungA7 = new Device(new ProcessorArm(2.24,3,32), new Memory(new String[5]));
    Device myComputer4 = new Device(new ProcessorX86(3.9,8,64), new Memory(new String[9]));
    Device iphone11 = new Device(new ProcessorArm(2.34,3,64), new Memory(new String[5]));

    Device [] devices = new Device[]{myComputer1, samsungS20, samsungA8, myComputer2, iphone10, myComputer3, samsungS10, samsungA7, myComputer4, iphone11};



    @Test
    public void test_filterByCash(){
        List<Device> expected = new ArrayList<>();
        expected.add(myComputer1);
        expected.add(myComputer2);
        expected.add(myComputer3);
        expected.add(myComputer4);
        List<Device> actual = Filter.filtrateByCash(devices, 8);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void test_filtrateByMoreOccupiedMemory(){
        List<Device> expected = new ArrayList<>();
        expected.add(samsungS20);
        expected.add(samsungA8);
        expected.add(iphone10);
        expected.add(samsungS10);
        expected.add(samsungA7);
        expected.add(iphone11);
        List<Device> actual = Filter.filtrateByMoreOccupiedMemory(devices, 1);
        Assertions.assertEquals(expected, actual);
    }
}