package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testAppMain() {
        // Simple test to check if main method runs without exceptions
        try {
            App.main(new String[]{});
        } catch (Exception e) {
            fail("App.main threw an exception: " + e.getMessage());
        }
    }
}
