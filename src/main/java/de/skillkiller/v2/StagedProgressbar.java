package de.skillkiller.v2;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StagedProgressbar implements ProgressBarProgress {
    List<Pair<Long, de.skillkiller.v2.Progressbar>> bars;



    public float getProgress() {
        //Need test
        return (float) bars.stream().mapToDouble(value -> value.getKey() * value.getValue().getPercent()).sum() / bars.stream().mapToLong(Pair::getKey).sum();
    }

    public void reCalculate() {
        System.out.println("UPDATED: " + getProgress());
    }

    public Progressbar getStage(int index) {
        return bars.get(index).getValue();
    }
}
