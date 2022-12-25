package de.skillkiller.v2;

import lombok.Setter;

public class Progressbar extends ProgressBarProgress {

    @Setter
    private long maxValue = 100;
    private long currentValue = 0;

    public void incrementByOne() {
        if (currentValue + 1 > maxValue) return;
        currentValue++;
        if (partFrom != null) partFrom.reCalculate();
    }

    public void setValue(long value) {
        if (currentValue > maxValue)
            throw new RuntimeException("Cannot set value to " + value + " when max value is " + maxValue);
        this.currentValue = value;
        if (partFrom != null) partFrom.reCalculate();
    }

    public long getValue() {
        return currentValue;
    }

    public void finished() {
        this.currentValue = maxValue;
    }

    public float getProgress() {
        return ((float) currentValue) / maxValue;
    }
}
