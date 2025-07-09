package org.example.studysearch;

import java.util.ArrayList;
import java.util.List;

public class SearchLog {
    private List<String> logs = new ArrayList<>();
    private int numUsages = 0;
    private String logName;

    public SearchLog() {
        this.logName = "Default SearchLog";
    }

    public SearchLog(String logName) {
        this.logName = logName;
    }

    public void addSearchHistory(String query) {
        logs.add(query);
    }

    public List<String> getSearchHistory() {
        return logs;
    }

    public int getNumUsages() {
        return numUsages;
    }

    public void setNumUsages(int numUsages) {
        this.numUsages = numUsages;
    }

    public String getLogName() {
        return logName;
    }

    // Novo método para imprimir o log
    public void printLog() {
        if (logs.isEmpty()) {
            System.out.println("No search logs available.");
        } else {
            System.out.println("Search logs:");
            for (String logEntry : logs) {
                System.out.println("- " + logEntry);
            }
        }
        System.out.println("Number of usages: " + numUsages);
        System.out.println("Log name: " + logName);
    }
}
