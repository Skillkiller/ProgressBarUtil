package de.skillkiller.v2;

import java.util.ArrayList;
import java.util.List;

public class StagedProgressbarBuilder {
    List<Pair<Long, Progressbar>> bars = new ArrayList<>();
    
    public StagedProgressbarBuilder addStage(long weight) {
        Progressbar progressbar = new Progressbar();
        bars.add(new Pair<>(weight, progressbar));
        return this;
    }

    public StagedProgressbar build() {
        StagedProgressbar stagedProgressbar = new StagedProgressbar(bars);
        bars.stream().map(Pair::getValue).forEach(progressbar -> progressbar.setPartFrom(stagedProgressbar));
        return stagedProgressbar;
    }
}
