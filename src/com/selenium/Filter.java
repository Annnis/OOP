package com.selenium;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static List<Device> filtrateByArchitecture(Device[] devices, String arch) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getProcessor().getArchitecture().equals(arch)) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filtrateByCash(Device[] devices, double cash) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getProcessor().getCache() == cash) {
                res.add(devices[i]);
            }
        }
        return res;
    }
    public static List<Device> filtrateByFrequency(Device[] devices, double frequency) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getProcessor().getFrequency() == frequency) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filtrateByBitCapacity(Device[] devices, double bitCapacity) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getProcessor().getBitCapacity() == bitCapacity) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filtrateByTotalMemory(Device[] devices, int totalMemory) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getTotalMemory() == totalMemory) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filtrateByOccupiedMemory(Device[] devices, int occupiedMemory) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getOccupiedMemory() == occupiedMemory) {
                res.add(devices[i]);
            }
        }
        return res;
    }
    public static List<Device> filtrateByMoreTotalMemory(Device[] devices, int value) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getTotalMemory() > value) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filtrateByLessTotalMemory(Device[] devices, int value) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getTotalMemory() < value) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filtrateByMoreOccupiedMemory(Device[] devices, double value) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getOccupiedMemory() > value) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filtrateByLessOccupiedMemory(Device[] devices, double value) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getOccupiedMemory() < value) {
                res.add(devices[i]);
            }
        }
        return res;
    }
}