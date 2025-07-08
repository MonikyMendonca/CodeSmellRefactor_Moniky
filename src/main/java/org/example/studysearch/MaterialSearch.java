package org.example.studysearch;

import org.example.studyregistry.StudyMaterial;
import java.util.ArrayList;
import java.util.List;

public class MaterialSearch implements Search<String> {

    private final SearchLog searchLog = new SearchLog("Material Search");

    public MaterialSearch() {}

    @Override
    public List<String> search(String text) {
        List<String> results = new ArrayList<>();

        // Buscar nos materiais
        results.addAll(StudyMaterial.getStudyMaterial().searchInMaterials(text));

        // Registrar a busca no log (sem tentar usar retorno)
        searchLog.logSearch(text);

        // Adicionar informação do log nos resultados (opcional)
        results.add("\nLogged in: " + searchLog.getLogName());

        return results;
    }

    public SearchLog getSearchLog() {
        return searchLog;
    }
}
