package org.example.studyplanner;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDo implements PlannerMaterial {
    private Integer id;
    private String title;
    private String description;
    private int priority;

    // Coleção encapsulada
    private final List<String> subTasks = new ArrayList<>();

    public ToDo(Integer id, String title, String description, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return MessageFormat.format("[(Priority:{3}) ToDo {0}: {1}, {2}]", id, title, description, priority);
    }

    // Comportamento adicional útil (ex: urgência)
    public boolean isHighPriority() {
        return this.priority >= 4;
    }

    public void promotePriority() {
        if (this.priority < 5) {
            this.priority++;
        }
    }

    public void demotePriority() {
        if (this.priority > 1) {
            this.priority--;
        }
    }

    // Subtasks (coleção encapsulada)
    public void addSubTask(String subTask) {
        this.subTasks.add(subTask);
    }

    public void removeSubTask(String subTask) {
        this.subTasks.remove(subTask);
    }

    public List<String> getSubTasks() {
        return Collections.unmodifiableList(this.subTasks);
    }

    // Getters/Setters conforme exigido pelos testes (não podem ser removidos)
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
