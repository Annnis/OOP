package com.selenium;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static List<Device> filterByArchitecture(Device[] devices, String arch) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getProcessor().getArchitecture().equals(arch)) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filterByCash(Device[] devices, double cash) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getProcessor().getCache() == cash) {
                res.add(devices[i]);
            }
        }
        return res;
    }
    public static List<Device> filterByFrequency(Device[] devices, double frequency) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getProcessor().getFrequency() == frequency) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filterByBitCapacity(Device[] devices, double bitCapacity) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getProcessor().getBitCapacity() == bitCapacity) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filter_TotalMemory_MoreThan_Value(Device[] devices, int value) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getTotalMemory() > value) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filter_TotalMemory_LessThan_Value(Device[] devices, int value) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getTotalMemory() < value) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filter_OccupiedMemory_MoreThan_Value(Device[] devices, double value) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getOccupiedMemory() > value) {
                res.add(devices[i]);
            }
        }
        return res;
    }

    public static List<Device> filter_OccupiedMemory_LessThan_Value(Device[] devices, double value) {
        List<Device> res = new ArrayList<>();
        for (int i = 0; i < devices.length; i++) {
            if (devices[i].getOccupiedMemory() < value) {
                res.add(devices[i]);
            }
        }
        return res;
    }
}