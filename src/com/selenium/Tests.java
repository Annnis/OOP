package com.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class Tests {
    @Test
    public void test_getDetails_ProcessorX86(){
        ProcessorX86 processorX86 = new ProcessorX86(3.7,8,64);
        String actual = processorX86.getDetails();
        String expected = "Частота процессора: 3.7 GHz, кеш: 8.0 Mb, разрядность: 64-bit, architecture: X86";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_String_ProcessorX86(){
        ProcessorX86 processorX86 = new ProcessorX86(3.7,8,64);
        String actual = processorX86.dataProcess("12345");
        String expected = "processor is using on architecture x86 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_Long_ProcessorX86(){
        ProcessorX86 processorX86 = new ProcessorX86(3.7,8,64);
        String actual = processorX86.dataProcess(12345);
        String expected = "processor is using on architecture x86 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_getDetails_ProcessorArm(){
        ProcessorArm processorArm = new ProcessorArm(3.7,8,64);
        String actual = processorArm.getDetails();
        String expected = "Частота процессора: 3.7 GHz, кеш: 8.0 Mb, разрядность: 64-bit, architecture: ARM";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_String_ProcessorArm(){
        ProcessorArm processorArm = new ProcessorArm(3.7,8,64);
        String actual = processorArm.dataProcess("12345");
        String expected = "PROCESSOR IS USING ON ARCHITECTURE ARM 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_dataProcess_Long_ProcessorArm(){
        ProcessorArm processorArm = new ProcessorArm(3.7,8,64);
        String actual = processorArm.dataProcess(12345);
        String expected = "PROCESSOR IS USING ON ARCHITECTURE ARM 12345";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_readLast_Memory(){
        String [] array = new String[]{"qwe", "rty", "uio"};
        Memory memory = new Memory(array);
        String actual = memory.readLast();
        String expected = "uio";
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_removeLast_Memory() {
        String[] array = new String[]{"qwe", "rty", "uio"};
        Memory memory = new Memory(array);
        String actual = memory.removeLast();
        String expected = "uio";
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void test_save_false_Memory() {
        String[] array = new String[]{"qwe", "rty", "uio"};
        Memory memory = new Memory(array);
        boolean actual = memory.save("asd");
        boolean expected = false;
        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void test_save_true_Memory() {
        String[] nemory = new String[]{"qwe", "rty", null};
        Memory memory = new Memory(nemory);
        boolean actual = memory.save("uio");
        boolean expected = true;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void test_save_Device() {
        Device device = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[5]));
        device.save(new String[]{"qwe", "rty", "asd"});
        String [] memoryCell = new String[]{null, null, "asd", "rty","qwe"};
        Assertions.assertArrayEquals(memoryCell, device.getMemory().getMemoryCell());
    }

    @Test
    public void test_readAll_Device() {
        Device device = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[5]));
        device.save(new String[]{"qwe", "rty", "asd"});
        String [] memoryCell = new String[]{null, null, "asd", "rty","qwe"};
        String[] expected = memoryCell;
        String[] actual = device.readAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_dataProcessing_Device() {
        Device device = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[3]));
        device.save(new String[]{"qwe", "rty", "asd"});
        device.dataProcessing();
        String [] memoryCell = new String[]{"asd__TTTTT", "rty__TTTTT", "qwe__TTTTT"};
        Assertions.assertArrayEquals(memoryCell, device.getMemory().getMemoryCell());
    }

    @Test
    public void test_getSystemInfo_Device() {
        Device device = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[3]));
        device.getSystemInfo();
        String  expected = "MemoryInfo{totalMemory=3, occupiedMemory=0.0} Частота процессора: 2.84 GHz, кеш: 3.0 Mb, разрядность: 32-bit, architecture: ARM";
        String actual = device.getSystemInfo();
        Assertions.assertEquals(actual, expected);
    }

}