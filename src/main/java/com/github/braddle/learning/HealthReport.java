package com.github.braddle.learning;

public class HealthReport {

    private String version;

    public HealthReport(String version) {
        this.version = version;
    }

    public String getStatus() {
        return "OK";
    }

    public String getVersion() {
        return version;
    }
}
