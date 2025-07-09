package org.example.studyregistry;

public class WeekSetupData {
    private final String planName;
    private final String objectiveTitle;
    private final String objectiveDescription;
    private final String materialTopic;
    private final String materialFormat;
    private final String goal;
    private final String reminderTitle;
    private final String reminderDescription;
    private final String mainTaskTitle;
    private final String mainHabit;
    private final String mainCardStudy;

    public WeekSetupData(String planName, String objectiveTitle, String objectiveDescription, String materialTopic,
                         String materialFormat, String goal, String reminderTitle, String reminderDescription,
                         String mainTaskTitle, String mainHabit, String mainCardStudy) {
        this.planName = planName;
        this.objectiveTitle = objectiveTitle;
        this.objectiveDescription = objectiveDescription;
        this.materialTopic = materialTopic;
        this.materialFormat = materialFormat;
        this.goal = goal;
        this.reminderTitle = reminderTitle;
        this.reminderDescription = reminderDescription;
        this.mainTaskTitle = mainTaskTitle;
        this.mainHabit = mainHabit;
        this.mainCardStudy = mainCardStudy;
    }

    public String getPlanName() {
        return planName;
    }

    public String getObjectiveTitle() {
        return objectiveTitle;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public String getMaterialTopic() {
        return materialTopic;
    }

    public String getMaterialFormat() {
        return materialFormat;
    }

    public String getGoal() {
        return goal;
    }

    public String getReminderTitle() {
        return reminderTitle;
    }

    public String getReminderDescription() {
        return reminderDescription;
    }

    public String getMainTaskTitle() {
        return mainTaskTitle;
    }

    public String getMainHabit() {
        return mainHabit;
    }

    public String getMainCardStudy() {
        return mainCardStudy;
    }
}
