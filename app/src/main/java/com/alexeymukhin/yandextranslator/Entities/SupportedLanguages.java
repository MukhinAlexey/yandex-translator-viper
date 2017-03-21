package com.alexeymukhin.yandextranslator.Entities;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportedLanguages {

    @SerializedName("dirs")
    @Expose
    private List<String> directions = null;
    @SerializedName("langs")
    @Expose
    private Map<String, String> languages;

    public List<String> getDirs() {
        return directions;
    }

    public void setDirs(List<String> directions) {
        this.directions = directions;
    }

    public Map<String, String> getLanguage() {
        return languages;
    }

    public void setLanguage(Map<String, String> languages) {
        this.languages = languages;
    }

}
