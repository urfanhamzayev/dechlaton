package com.urfan.project.decathlon.data;

public enum MeasurementType {
    Meters(1, ""), Centimeters(100, ""), Seconds(1, "ss.SS"), MinutesAndSeconds(1000, "mm.ss.SS");

    private final String format;
    private final int multiplier;

    MeasurementType(int multiplier, String format) {
        this.format = format;
        this.multiplier = multiplier;
    }

    int getMultiplier() {
        return multiplier;
    }

    String getFormat () {
        return format;
    }

}
