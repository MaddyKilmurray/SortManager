package com.sparta.maddy.controllers.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortTimerTest {

    SortTimer timer;

    @BeforeEach
    public void setup() {
        timer = new SortTimer();
    }

    @Test
    public void sortTimeInNano_Result() {
        long time = 0;
        time = timer.sortTimeInNano();
        Assertions.assertTrue(time > 0);
    }
}
