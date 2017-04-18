package com.alexeymukhin.yandextranslator.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ServerTranslationEntity {

    @Getter
    @Setter
    @SerializedName("code")
    @Expose
    private Integer code;

    @Getter
    @Setter
    @SerializedName("lang")
    @Expose
    private String lang;

    @Setter
    @SerializedName("text")
    @Expose
    private List<String> text = null;

    public String getTranslatedText() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(text.get(0));
        return strBuilder.toString();
    }

}
