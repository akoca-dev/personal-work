/*package com.akoca.exercise.init;

import com.google.common.base.Preconditions;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class EmailSenderQuartz implements CommandLineRunner {

    private Scheduler scheduler;

    @Autowired //In Case another constructor created
    public EmailSenderQuartz(Scheduler scheduler) {
        Preconditions.checkNotNull(scheduler);

        this.scheduler = scheduler;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}*/