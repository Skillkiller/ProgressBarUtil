package de.skillkiller.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StagedProgressbarBuilder {
    private final List<Pair<Long, ProgressBarProgress>> bars = new ArrayList<>();
    private Consumer<Float> updateConsumer;

    public StagedProgressbarBuilder updateConsumer(Consumer<Float> consumer) {
        this.updateConsumer = consumer;
        return this;
    }

    public StagedProgressbarBuilder addStage(long weight) {
        Progressbar progressbar = new Progressbar();
        bars.add(new Pair<>(weight, progressbar));
        return this;
    }

    public StagedProgressbarBuilder addStage(long weight, long totalAmount) {
        Progressbar progressbar = new Progressbar(totalAmount);
        bars.add(new Pair<>(weight, progressbar));
        return this;
    }

    public StagedProgressbarBuilder addStage(long weight, StagedProgressbar stagedProgressbar) {
        bars.add(new Pair<>(weight, stagedProgressbar));
        return this;
    }

    public StagedProgressbar build() {
        List<Pair<Long, ProgressBarProgress>> bars = new ArrayList<>();
        for (Pair<Long, ProgressBarProgress> bar : this.bars) {
            bars.add(new Pair<>(bar.getKey(), bar.getValue()));
        }
        StagedProgressbar stagedProgressbar = new StagedProgressbar(bars, updateConsumer);
        this.bars.stream().map(Pair::getValue).forEach(bar -> bar.setPartFrom(stagedProgressbar));

        return stagedProgressbar;
    }
}
