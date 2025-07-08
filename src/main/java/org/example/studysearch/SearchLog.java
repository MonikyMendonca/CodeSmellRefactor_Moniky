package org.example.studysearch;

import java.util.LinkedList;

public class SearchLog {
    private String logName;
    private int numUsages;
    private LinkedList<String> searchHistory = new LinkedList<>();

    public SearchLog(String logName) {
        this.logName = logName;
    }

    public void addSearchHistory(String text) {
        searchHistory.add(text);
        numUsages++;
    }

    public void logSearch(String text) {
        addSearchHistory(text);
    }

    public LinkedList<String> getSearchHistory() {
        return searchHistory;
    }

    public String getLogName() {
        return logName;
    }

    public int getNumUsages() {
        return numUsages;
    }

    // ✅ IMPORTANTE: retorno precisa ser String!
    public String getLogEntry() {
        return "\nLogged in: " + this.logName;
    }
}
