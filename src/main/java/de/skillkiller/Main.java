package de.skillkiller;

import de.skillkiller.v2.Progressbar;
import de.skillkiller.v2.StagedProgressbar;
import de.skillkiller.v2.StagedProgressbarBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StagedProgressbarBuilder builder = new StagedProgressbarBuilder();
        builder.addStage(1);
        builder.addStage(9);

        StagedProgressbar stagedProgressbar = builder.build();
        stagedProgressbar.getStage(1).setValue(100);
        stagedProgressbar.getStage(0).setValue(50);
    }
}