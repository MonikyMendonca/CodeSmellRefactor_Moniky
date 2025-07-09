package org.example.studysearch;

import org.example.studyregistry.StudyMaterial;

import java.util.ArrayList;
import java.util.List;

public class MaterialSearch implements Search<String> {

    private SearchLog searchLog = new SearchLog(); // Usa o construtor sem argumentos

    public MaterialSearch() {}

    @Override
    public List<String> search(String text) {
        return handleMaterialSearch(text);
    }

    public SearchLog getSearchLog() {
        return searchLog;
    }

    private List<String> handleMaterialSearch(String text){
        List<String> results = new ArrayList<>();
        results.addAll(StudyMaterial.getStudyMaterial().searchInMaterials(text));

        // Usa apenas os métodos permitidos de SearchLog
        this.searchLog.addSearchHistory(text);
        results.add("\nSearch logged."); // Texto genérico, já que não há getLogName()

        return results;
    }
}
