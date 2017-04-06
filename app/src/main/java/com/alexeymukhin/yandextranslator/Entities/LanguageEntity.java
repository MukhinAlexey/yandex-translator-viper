package com.alexeymukhin.yandextranslator.Entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LanguageEntity
        extends RealmObject {

    @PrimaryKey
    private String shortName;
    private String fullName;

    private Boolean isFromSelected;
    private Boolean isToSelected;

    public LanguageEntity() {

    }

    public LanguageEntity(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.isFromSelected = false;
        this.isToSelected = false;
    }

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

    public Boolean getFromSelected() {
        return isFromSelected;
    }

    public void setFromSelected(Boolean fromSelected) {
        isFromSelected = fromSelected;
    }

    public Boolean getToSelected() {
        return isToSelected;
    }

    public void setToSelected(Boolean toSelected) {
        isToSelected = toSelected;
    }

}