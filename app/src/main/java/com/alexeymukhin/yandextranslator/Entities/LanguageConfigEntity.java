package com.alexeymukhin.yandextranslator.Entities;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LanguageConfigEntity {

    @SerializedName("dirs")
    @Expose
    private List<String> directions;
    @SerializedName("langs")
    @Expose
    private Map<String, String> languages;

    public List<String> getDirections() {
        return directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public Map<String, String> getLanguages() {
        return languages;
    }

    public void setLanguages(Map<String, String> languages) {
        this.languages = languages;
    }

}
