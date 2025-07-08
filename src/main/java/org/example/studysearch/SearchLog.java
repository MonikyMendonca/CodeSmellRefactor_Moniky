package org.example.studysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchLog {
    private final List<String> searchHistory;
    private final Map<String, Integer> searchCount;
    private boolean isLocked;
    private int numUsages;
    private String logName;

    public SearchLog(String logName) {
        this.searchHistory = new ArrayList<>();
        this.searchCount = new HashMap<>();
        this.logName = logName;
        this.numUsages = 0;
        this.isLocked = false;
    }

    // ✅ NOVO método centralizado
    public String logSearch(String query) {
        if (isLocked) {
            return "[Log está bloqueado: não foi possível registrar query]";
        }
        this.searchHistory.add(query);
        this.numUsages++;
        this.searchCount.merge(query, 1, Integer::sum);
        return getLogEntry();
    }

    // ✅ MÉTODOS LEGADOS (manter por enquanto)
    public void addSearchHistory(String query) {
        this.searchHistory.add(query);
    }

    public void recordSearch(String query) {
        addSearchHistory(query);
        this.numUsages++;
    }

    public void setNumUsages(int numUsages) {
        this.numUsages = numUsages;
    }

    // Getters
    public List<String> getSearchHistory() {
        return searchHistory;
    }

    public Map<String, Integer> getSearchCount() {
        return searchCount;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public int getNumUsages() {
        return numUsages;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogEntry() {
        return "\nLogged in: " + this.logName;
    }
}
