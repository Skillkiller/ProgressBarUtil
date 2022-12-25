package de.skillkiller.v2;

public abstract class ProgressBarProgress {
    protected ProgressBarProgress partFrom;

    abstract float getProgress();

    void setPartFrom(ProgressBarProgress bar) {
        this.partFrom = bar;
    }

    void reCalculate() {
    }
}
