package com.akoca.notesapp.controller;

import com.akoca.notesapp.services.impl.NoteServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Disabled(value = "Disabled until mocking is learned")
class NoteControllerTest {

    private NoteController noteController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    @EnabledOnOs(OS.LINUX)
    @DisabledForJreRange(max = JRE.JAVA_10)
    void composeNewNoteTimeout() {
        assumeTrue("Database connection established".isEmpty());
        assertTimeout(Duration.ofSeconds(2), () -> {
            TimeUnit.SECONDS.sleep(3);
            noteController.composeNewNote(null);
        });
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    @EnabledIf(
            expression = "${tests.enabled}",
            loadContext = true)
    @DisabledIf("#{systemProperties['java.version'].startsWith('1.8')}")
    void composeNewNoteTimeoutPreemtive() {
        String environment = null;
        assumingThat(environment.equals("prod"), () -> System.err.println("Profile is prod"));
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            TimeUnit.SECONDS.sleep(3);
            noteController.composeNewNote(null);
        });
    }
}