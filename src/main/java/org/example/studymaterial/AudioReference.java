package org.example.studymaterial;

import java.util.List;

public class AudioReference extends Reference {

    public enum AudioQuality {
        LOW, MEDIUM, HIGH, VERY_HIGH;
    }

    private AudioQuality audioQuality;
    private boolean isDownloadable;
    private String title;
    private String description;
    private String link;
    private String accessRights;
    private String license;
    private String language;
    private int rating;
    private int viewCount;
    private int shareCount;

    public AudioReference(AudioQuality audioQuality) {
        this.audioQuality = audioQuality;
    }

    public static AudioQuality audioQualityAdapter(String quality) {
        if (quality == null) {
            throw new IllegalArgumentException("Audio quality cannot be null");
        }
        return switch (quality.toUpperCase()) {
            case "LOW" -> AudioQuality.LOW;
            case "MEDIUM" -> AudioQuality.MEDIUM;
            case "HIGH" -> AudioQuality.HIGH;
            case "VERY_HIGH" -> AudioQuality.VERY_HIGH;
            default -> throw new IllegalArgumentException("Unknown audio quality: " + quality);
        };
    }

    public void editAudioAdapter(List<String> stringProps, List<Integer> intProps, AudioQuality quality, boolean isDownloadable) {
        if (stringProps == null || stringProps.size() < 6) {
            throw new IllegalArgumentException("stringProps precisa ter pelo menos 6 elementos");
        }
        if (intProps == null || intProps.size() < 3) {
            throw new IllegalArgumentException("intProps precisa ter pelo menos 3 elementos");
        }

        this.audioQuality = quality;
        this.isDownloadable = isDownloadable;

        this.title = stringProps.get(0);
        this.description = stringProps.get(1);
        this.link = stringProps.get(2);
        this.accessRights = stringProps.get(3);
        this.license = stringProps.get(4);
        this.language = stringProps.get(5);

        this.rating = intProps.get(0);
        this.viewCount = intProps.get(1);
        this.shareCount = intProps.get(2);
    }

    public void editBasic(String title, String description, String link) {
        this.title = title;
        this.description = description;
        this.link = link;
    }

    public void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setAudioQuality(AudioQuality audioQuality) {
        this.audioQuality = audioQuality;
    }

    public void editCommonAttributes(int rating, String language, int viewCount, int shareCount, boolean isDownloadable) {
        this.rating = rating;
        this.language = language;
        this.viewCount = viewCount;
        this.shareCount = shareCount;
        this.isDownloadable = isDownloadable;
    }

    public void editAudio(AudioQuality audioQuality, boolean isDownloadable, String title, String description,
                          String link, String accessRights, String license, String language,
                          int rating, int viewCount, int shareCount) {
        setAudioQuality(audioQuality);
        this.isDownloadable = isDownloadable;
        editBasic(title, description, link);
        setAccessRights(accessRights);
        setLicense(license);
        editCommonAttributes(rating, language, viewCount, shareCount, isDownloadable);
    }

    // Getters usados nos testes

    public AudioQuality getAudioQuality() {
        return audioQuality;
    }

    public boolean getIsDownloadable() {
        return isDownloadable;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getAccessRights() {
        return accessRights;
    }

    public String getLicense() {
        return license;
    }

    public String getLanguage() {
        return language;
    }

    public int getRating() {
        return rating;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getShareCount() {
        return shareCount;
    }
}
