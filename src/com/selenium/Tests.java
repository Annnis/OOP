package com.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class Tests {
    private static String [] memoryCell;
    private static Device device;
    private static String actual;
    private static String expected;

    @Test
    public void test_getDetails_ProcessorX86(){
        actual = new ProcessorX86(3.7,8,64).getDetails();
        expected = "Частота процессора: 3.7 GHz, кеш: 8.0 Mb, разрядность: 64-bit, architecture: X86";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_String_ProcessorX86(){
        actual = new ProcessorX86(3.7,8,64).dataProcess("12345");
        expected = "processor is using on architecture x86 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_Long_ProcessorX86(){
        actual = new ProcessorX86(3.7,8,64).dataProcess(12345);
        expected = "processor is using on architecture x86 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_getDetails_ProcessorArm(){
        actual = new ProcessorArm(3.7,8,64).getDetails();
        expected = "Частота процессора: 3.7 GHz, кеш: 8.0 Mb, разрядность: 64-bit, architecture: ARM";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_String_ProcessorArm(){
        actual = new ProcessorArm(3.7,8,64).dataProcess("12345");
        expected = "PROCESSOR IS USING ON ARCHITECTURE ARM 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_Long_ProcessorArm(){
        actual = (new ProcessorArm(3.7,8,64)).dataProcess(12345);
        expected = "PROCESSOR IS USING ON ARCHITECTURE ARM 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_readLast_Memory(){
        actual = new Memory(new String[]{"qwe", "rty", "uio"}).readLast();
        expected = "uio";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_removeLast_Memory() {
        actual = new Memory(new String[]{"qwe", "rty", "uio"}).removeLast();
        expected = "uio";
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void test_save_false_Memory() {
        boolean actual = new Memory(new String[]{"qwe", "rty", "uio"}).save("asd");
        Assertions.assertFalse(actual);
    }
    @Test
    public void test_save_true_Memory() {
        boolean actual = new Memory(new String[]{"qwe", "rty", null}).save("uio");
        Assertions.assertTrue(actual);
    }

    @Test
    public void test_save_Device() {
        device = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[5]));
        device.save(new String[]{"qwe", "rty", "asd"});
        String [] memoryCell = new String[]{null, null, "asd", "rty","qwe"};
        Assertions.assertArrayEquals(memoryCell, device.getMemory().getMemoryCell());
    }

    @Test
    public void test_readAll_Device() {
        device = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[5]));
        device.save(new String[]{"qwe", "rty", "asd"});
        memoryCell = new String[]{null, null, "asd", "rty","qwe"};
        String[] expected = memoryCell;
        String[] actual = device.readAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_dataProcessing_Device() {
        device = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[3]));
        device.save(new String[]{"qwe", "rty", "asd"});
        device.dataProcessing();
        memoryCell = new String[]{"asd__TTTTT", "rty__TTTTT", "qwe__TTTTT"};
        Assertions.assertArrayEquals(memoryCell, device.getMemory().getMemoryCell());
    }

    @Test
    public void test_getSystemInfo_Device() {
        expected = "MemoryInfo{totalMemory=3, occupiedMemory=0.0} Частота процессора: 2.84 GHz, кеш: 3.0 Mb, разрядность: 32-bit, architecture: ARM";
        actual = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[3])).getSystemInfo();
        Assertions.assertEquals(actual, expected);
    }

}