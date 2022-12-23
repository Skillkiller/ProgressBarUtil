package de.skillkiller.v2;

import lombok.AccessLevel;
import lombok.Setter;

public class Progressbar implements ProgressBarProgress {

    private final static long MAX_VALUE = 100;
    private long currentValue = 0;

    @Setter(AccessLevel.PACKAGE)
    private StagedProgressbar partFrom;

    public void incrementByOne() {
        currentValue++;
        if (partFrom != null) partFrom.reCalculate();
    }

    public void setValue(long value) {
        this.currentValue = value;
        if (partFrom != null) partFrom.reCalculate();
    }

    public long getValue() {
        return currentValue;
    }

    public float getProgress() {
        return ((float) currentValue) / MAX_VALUE ;
    }
}
