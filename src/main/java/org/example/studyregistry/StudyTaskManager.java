package org.example.studyregistry;

import org.example.studymaterial.Reference;

import java.util.ArrayList;
import java.util.List;

public class StudyTaskManager {
    private static StudyTaskManager instance;
    private StudyMaterial studyMaterial = StudyMaterial.getStudyMaterial();
    private List<Registry> registryList;
    private List<String> weekResponsibilities = List.of();

    private StudyTaskManager() {
        this.registryList = new ArrayList<>();
    }

    public static StudyTaskManager getStudyTaskManager() {
        if (instance == null) {
            instance = new StudyTaskManager();
        }
        return instance;
    }

    public List<String> getWeekResponsibilities() {
        return weekResponsibilities;
    }

    public void setUpWeek(WeekSetupData data) {
        this.weekResponsibilities = new ArrayList<>();
        this.weekResponsibilities.add(data.getPlanName());
        this.weekResponsibilities.add(data.getObjectiveTitle());
        this.weekResponsibilities.add(data.getObjectiveDescription());
        this.weekResponsibilities.add(data.getMaterialTopic());
        this.weekResponsibilities.add(data.getMaterialFormat());
        this.weekResponsibilities.add(data.getGoal());
        this.weekResponsibilities.add(data.getReminderTitle());
        this.weekResponsibilities.add(data.getReminderDescription());
        this.weekResponsibilities.add(data.getMainTaskTitle());
        this.weekResponsibilities.add(data.getMainHabit());
        this.weekResponsibilities.add(data.getMainCardStudy());
    }

    public void handleSetUpWeek(List<String> stringProperties) {
        WeekSetupData data = new WeekSetupData(
                stringProperties.get(0), stringProperties.get(1), stringProperties.get(2),
                stringProperties.get(3), stringProperties.get(4), stringProperties.get(5),
                stringProperties.get(6), stringProperties.get(7), stringProperties.get(8),
                stringProperties.get(9), stringProperties.get(10)
        );
        setUpWeek(data);
    }

    public void addRegistry(Registry registry) {
        registryList.add(registry);
    }

    public void removeRegistry(Registry registry) {
        registryList.remove(registry);
    }

    public List<Registry> getRegistryList() {
        return registryList;
    }

    public List<String> searchInRegistries(String text) {
        List<String> response = new ArrayList<>();
        for (Registry registry : registryList) {
            String mix = (registry.getName() != null ? registry.getName() : "");
            if (mix.toLowerCase().contains(text.toLowerCase())) {
                response.add(registry.getName());
            }
        }
        return response;
    }
}
