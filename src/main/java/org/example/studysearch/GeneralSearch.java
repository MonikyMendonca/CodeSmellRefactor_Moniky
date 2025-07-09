package org.example.studysearch;

import org.example.studycards.CardManager;
import org.example.studyplanner.HabitTracker;
import org.example.studyplanner.TodoTracker;
import org.example.studyregistry.StudyTaskManager;
import org.example.studyregistry.StudyMaterial;
import java.util.ArrayList;
import java.util.List;

public class GeneralSearch implements Search<String> {

    private SearchLog searchLog = new SearchLog("General Search");

    public GeneralSearch() {}

    @Override
    public List<String> search(String text) {
        return handleSearch(text);
    }

    public SearchLog getSearchLog() {
        return searchLog;
    }

    private List<String> handleSearch(String text) {
        List<String> results = new ArrayList<>();
        results.addAll(CardManager.getCardManager().searchInCards(text));
        results.addAll(HabitTracker.getHabitTracker().searchInHabits(text));
        results.addAll(TodoTracker.getInstance().searchInTodos(text));
        results.addAll(StudyMaterial.getStudyMaterial().searchInMaterials(text));
        results.addAll(StudyTaskManager.getStudyTaskManager().searchInRegistries(text));

        // Registra o texto pesquisado no histórico da busca
        this.searchLog.addSearchHistory(text);

        // Incrementa o contador de usos
        this.searchLog.setNumUsages(this.searchLog.getNumUsages() + 1);

        // Adiciona mensagem com o nome do log para exibição
        results.add("\nLogged in: " + this.searchLog.getLogName());

        return results;
    }
}
