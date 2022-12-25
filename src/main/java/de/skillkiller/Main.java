package de.skillkiller;

import de.skillkiller.v2.Progressbar;
import de.skillkiller.v2.StagedProgressbar;
import de.skillkiller.v2.StagedProgressbarBuilder;

public class Main {
    public static void main(String[] args) {
        StagedProgressbarBuilder builder = new StagedProgressbarBuilder();
        builder.addStage(1);
        builder.addStage(9, new StagedProgressbarBuilder().addStage(1).addStage(1).build());
        builder.updateConsumer(aFloat -> System.out.println("UPDATE = " + aFloat));

        StagedProgressbar stagedProgressbar = builder.build();
        stagedProgressbar.getStageAsStagedProgressBar(1).getStageAsProgressBar(0).setValue(100);
        stagedProgressbar.getStageAsStagedProgressBar(1).getStageAsProgressBar(1).setValue(100);
        stagedProgressbar.getStageAsProgressBar(0).setValue(100);


        Progressbar progressbar = new Progressbar();

        progressbar.setValue(99);
        progressbar.finished();
        progressbar.setMaxValue(100);

        System.out.println("progressbar = " + progressbar.getProgress());
    }
}