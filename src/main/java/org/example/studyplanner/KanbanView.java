package org.example.studyplanner;

import java.util.*;

public class KanbanView {
    public enum State {
        TODO, DOING, DONE;
    }

    private static final String NO_MATERIAL_FOUND = "No material found";
    private static final String HABIT_NOT_FOUND = "Habit not found with id: ";
    private static final String TODO_NOT_FOUND = "ToDo not found with id: ";
    private static final String NO_HABIT_FOUND = "No habit found with id: ";
    private static final String NO_TODO_FOUND = "No todo found with id: ";

    HabitTracker habitTracker = null;
    TodoTracker todoTracker = null;
    Map<State, List<PlannerMaterial>> kanban = null;

    public KanbanView(HabitTracker habitTracker, TodoTracker todoTracker) {
        this.habitTracker = habitTracker;
        this.todoTracker = todoTracker;
        this.kanban = new HashMap<>();
        this.kanban.put(State.TODO, new ArrayList<>());
        this.kanban.put(State.DOING, new ArrayList<>());
        this.kanban.put(State.DONE, new ArrayList<>());
    }

    public List<PlannerMaterial> getKanbanByState(State state) {
        return kanban.get(state);
    }

    public void addHabitToKanban(State state, Integer id) throws Exception {
        Habit toAdd = this.habitTracker.getHabitById(id);
        if (toAdd == null) {
            throw new Exception(HABIT_NOT_FOUND + id);
        }
        kanban.get(state).add(toAdd);
    }

    public void addToDoToKanban(State state, Integer id) throws Exception {
        ToDo toAdd = this.todoTracker.getToDoById(id);
        if (toAdd == null) {
            throw new Exception(TODO_NOT_FOUND + id);
        }
        kanban.get(state).add(toAdd);
    }

    public void removeHabitFromKanban(State state, Integer id) throws Exception {
        Habit toRemove = this.habitTracker.getHabitById(id);
        if (toRemove == null) {
            throw new Exception(NO_HABIT_FOUND + id);
        }
        kanban.get(state).remove(toRemove);
    }

    public void removeToDoFromKanban(State state, Integer id) throws Exception {
        ToDo toRemove = this.todoTracker.getToDoById(id);
        if (toRemove == null) {
            throw new Exception(NO_TODO_FOUND + id);
        }
        kanban.get(state).remove(toRemove);
    }

    public String kanbanView() throws Exception {
        if (kanban.isEmpty()) {
            throw new Exception(NO_MATERIAL_FOUND);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        appendSection(sb, "Material ToDo:", State.TODO);
        appendSection(sb, "Material in progress:", State.DOING);
        appendSection(sb, "Material completed:", State.DONE);

        sb.append("]");
        return sb.toString();
    }

    private void appendSection(StringBuilder sb, String title, State state) {
        sb.append(System.lineSeparator()).append(title).append(System.lineSeparator());
        appendMaterialsByState(sb, state);
    }

    private void appendMaterialsByState(StringBuilder sb, State state) {
        List<PlannerMaterial> materials = kanban.get(state);
        if (materials.isEmpty()) {
            sb.append(NO_MATERIAL_FOUND);
        } else {
            for (PlannerMaterial material : materials) {
                sb.append(", ").append(material.toString());
            }
        }
    }
}