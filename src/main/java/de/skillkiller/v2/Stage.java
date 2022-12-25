package de.skillkiller.v2;

import lombok.Getter;

public class Stage {
    @Getter
    private Progressbar bar;
    @Getter
    private StagedProgressbar stagedBar;

    public Stage(Progressbar bar) {
        this.bar = bar;
    }

    public Stage(StagedProgressbar stagedBar) {
        this.stagedBar = stagedBar;
    }

    public boolean isStaged() {
        return this.stagedBar != null;
    }

    public ProgressBarProgress getInterface() {
        return this.bar;
    }
}
