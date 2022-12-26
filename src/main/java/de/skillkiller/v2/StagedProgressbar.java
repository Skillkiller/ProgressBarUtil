package de.skillkiller.v2;

import java.util.List;
import java.util.function.Consumer;

public class StagedProgressbar extends ProgressBarProgress {
    List<Pair<Long, ProgressBarProgress>> bars;

    Consumer<Float> consumer;

    public StagedProgressbar(List<Pair<Long, ProgressBarProgress>> bars, Consumer<Float> consumer) {
        this.bars = bars;
        this.consumer = consumer;
    }

    public StagedProgressbar(List<Pair<Long, ProgressBarProgress>> bars) {
        this.bars = bars;
    }

    public float getProgress() {
        return (float) bars.stream().mapToDouble(value -> value.getKey() * value.getValue().getProgress()).sum() / bars.stream().mapToLong(Pair::getKey).sum();
    }

    @Override
    public void reCalculate() {
        if (partFrom != null) partFrom.reCalculate();
        else if (consumer != null) consumer.accept(getProgress());
    }

    public Progressbar getStageAsProgressBar(int index) {
        return (Progressbar) bars.get(index).getValue();
    }

    public StagedProgressbar getStageAsStagedProgressBar(int index) {
        return (StagedProgressbar) bars.get(index).getValue();
    }
}
