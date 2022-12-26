package de.skillkiller.v2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Progressbar extends ProgressBarProgress {

    @Setter
    @Getter
    private long totalAmount = 100;

    @Getter
    private long value = 0;

    public Progressbar(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void increaseByOne() {
        if (value + 1 > totalAmount) return;
        value++;
        if (partFrom != null) partFrom.reCalculate();
    }

    public void setValue(long value) {
        if (value > totalAmount)
            throw new RuntimeException("Cannot set value to " + value + " when max value is " + totalAmount);
        if (value < 0) throw new RuntimeException("Progress cannot be negative");
        this.value = value;
        if (partFrom != null) partFrom.reCalculate();
    }

    public void setValue(double value) {
        setValue((long) Math.ceil(value * totalAmount));
    }

    public void finished() {
        this.setValue(totalAmount);
    }

    public float getProgress() {
        return ((float) value) / totalAmount;
    }
}
