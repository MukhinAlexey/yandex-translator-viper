package com.alexeymukhin.yandextranslator.Entities;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

public class LanguageConfigEntity {

    @SerializedName("dirs")
    @Expose
    @Getter
    @Setter
    private List<String> directions;

    @SerializedName("langs")
    @Expose
    @Getter
    @Setter
    private Map<String, String> languages;

}
