package com.lab5.junit;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;

public abstract class DevEnvironment {

    @BeforeEach
    public void assumeDevEnvironment() {
        String env = System.getProperty("env", "dev");
        Assumptions.assumeTrue("dev".equals(env), () -> "Not a dev environment");
    }
}
