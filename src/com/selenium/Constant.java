package com.selenium;

public class Constant {
    public final static String PROCESSOR_INFO = "Частота процессора: %s GHz, кеш: %s Mb, разрядность: %s-bit";
    public final static String PROCESSOR_USING = "Processor is using on architecture %s %s";
    public final static String NULL_MEMORY_EXCEPTION = "Memory should't be null";
    public final static String NO_SUCH_ELEMENTS = "No such elements in memory";
    public final static Device myComputer1 = new Device(new ProcessorX86(3.7,8,64), new Memory(new String[7]));
    public final static Device samsungS20 = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[5]));
    public final static Device samsungA8 = new Device(new ProcessorArm(2.24,3,32), new Memory(new String[5]));
    public final static Device myComputer2 = new Device(new ProcessorX86(3.9,8,64), new Memory(new String[9]));
    public final static Device iphone10 = new Device(new ProcessorArm(2.34,3,64), new Memory(new String[5]));
    public final static Device myComputer3 = new Device(new ProcessorX86(3.7,8,64), new Memory(new String[7]));
    public final static Device samsungS10 = new Device(new ProcessorArm(2.84,3,32), new Memory(new String[5]));
    public final static Device samsungA7 = new Device(new ProcessorArm(2.24,3,32), new Memory(new String[5]));
    public final static Device myComputer4 = new Device(new ProcessorX86(3.9,8,64), new Memory(new String[9]));
    public final static Device iphone11 = new Device(new ProcessorArm(2.34,3,64), new Memory(new String[5]));

    public final static Device [] devices = new Device[]{myComputer1, samsungS20, samsungA8, myComputer2, iphone10, myComputer3, samsungS10, samsungA7, myComputer4, iphone11};

}