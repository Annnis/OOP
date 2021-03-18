package com.selenium;

import static com.selenium.Constant.*;

public class Memory {
    private String[] memoryCell;
    private final MemoryInfo MEMORY_INFO;
    private int size = 0;



    public String[] getMemoryCell() {
        return memoryCell;
    }
    public void setMemoryCell(String[] memoryCell) {
        this.memoryCell = memoryCell;
    }


    public void clearMemoryCell() {
        this.memoryCell = new String[this.memoryCell.length];
        this.size = 0;
        MEMORY_INFO.setOccupiedMemory(0);
    }

    public int getSize() {
        return size;
    }

    public Memory(String[] memoryCell) {
        if (memoryCell == null) {
            throw new IllegalArgumentException(NULL_MEMORY_EXCEPTION);
        }
        this.memoryCell = memoryCell;
        this.MEMORY_INFO = new MemoryInfo(memoryCell.length, 0);
    }


    public String readLast() {
        for (int i = memoryCell.length - 1; i >= 0; i--) {
            if (memoryCell[i] != null) {
                return memoryCell[i];
            }
        }
        return NO_SUCH_ELEMENTS;
    }

    public String removeLast() {
        for (int i = memoryCell.length - 1; i >= 0; i--) {
            if (memoryCell[i] != null) {
                String removingValue = memoryCell[i];
                memoryCell[i] = null;
                size--;
                MEMORY_INFO.setOccupiedMemory(100 * size / MEMORY_INFO.getTotalMemory());
                return removingValue;
            }
        }
        return NO_SUCH_ELEMENTS;
    }

    public boolean save(String value) {
        for (int i = memoryCell.length - 1; i >= 0; i--) {
            if (memoryCell[i] == null) {
                memoryCell[i] = value;
                size++;
                MEMORY_INFO.setOccupiedMemory(100 * size / MEMORY_INFO.getTotalMemory());
                return true;
            }
        }
        return false;
    }


    class MemoryInfo{

        private final int totalMemory;
        private double occupiedMemory;

        public MemoryInfo(int totalMemory, double occupiedMemory) {
            this.totalMemory = totalMemory;
            this.occupiedMemory = occupiedMemory;
        }

        public void setOccupiedMemory(double occupiedMemory) {
            this.occupiedMemory = occupiedMemory;
        }

        public int getTotalMemory() {
            return totalMemory;
        }

        @Override
        public String toString() {
            return "MemoryInfo{" +
                    "totalMemory=" + totalMemory +
                    ", occupiedMemory=" + occupiedMemory +
                    '}';
        }
        public double getOccupiedMemory() {
            return occupiedMemory;
        }
    }
    public MemoryInfo getMemoryInfo() {
        return this.MEMORY_INFO;
    }

}