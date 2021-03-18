package com.selenium;

import java.util.Locale;

import static com.selenium.Constant.PROCESSOR_USING;

    public class ProcessorArm extends Processor {

        private final String ARCHITECTURE = "ARM";

        public ProcessorArm(double frequency, double cache, int bitCapacity) {
            super(frequency, cache, bitCapacity);
        }

        @Override
        public String dataProcess(String data) {
            return String.format(PROCESSOR_USING, ARCHITECTURE, data).toUpperCase();
        }

        @Override
        public String dataProcess(long data) {
            return String.format(PROCESSOR_USING, ARCHITECTURE, data).toLowerCase();
        }

        @Override
        public String getDetails() {
            String result = super.getDetails();
            return result + ", architecture: " + ARCHITECTURE;
        }

        public String getArchitecture() {
            return ARCHITECTURE;
        }
    }
