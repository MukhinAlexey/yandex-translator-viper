package com.alexeymukhin.yandextranslator.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Language {

    private String shortName;
    private String fullName;


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}