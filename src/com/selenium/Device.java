package com.selenium;

public class Device {
    private Processor processor;
    private Memory memory;

    public Processor getProcessor() {
        return processor;
    }
    public Memory getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "Device{" +
                "processor=" + processor.getDetails() +
                ", memory=" + memory.getMemoryInfo() +
                '}';
    }

    public Device(Processor processor, Memory memory){
        this.processor = processor;
        this.memory = memory;
    }

    public void save(String[] data){
        String[] currentMemoryCell = this.memory.getMemoryCell();
        if (data.length < currentMemoryCell.length){
            throw new IllegalArgumentException("We are out of bounds");
        }
        for (int i = 0; i < data.length && i < currentMemoryCell.length; i++) {
            this.memory.save(data[i]);
        }
    }

    public String[] readAll() {
        String[] temp = new String[this.memory.getMemoryCell().length];
        String[] currentMemoryCell = this.memory.getMemoryCell();
        for (int i = 0; i <= currentMemoryCell.length - 1; i++) {
            temp[i] = currentMemoryCell[i];

        } this.memory.clearMemoryCell();
        return temp;
    }

    public void dataProcessing() {
        String[] currentMemoryCell = this.memory.getMemoryCell();
        for (int i = 0; i <= currentMemoryCell.length - 1; i++) {
            if (currentMemoryCell[i] != null) {
                currentMemoryCell[i] = currentMemoryCell[i].concat("__TTTTT");
            }
        } this.memory.setMemoryCell(currentMemoryCell);
    }

    int getTotalMemory() { return this.memory.getMemoryInfo().getTotalMemory(); }
    double getOccupiedMemory() { return this.memory.getMemoryInfo().getOccupiedMemory(); }
    String getSystemInfo() {
        return String.format("%s %s", this.memory.getMemoryInfo(), this.processor.getDetails());
    }
}