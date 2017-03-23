package com.alexeymukhin.yandextranslator.Objects;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;

import io.realm.annotations.PrimaryKey;

public class Language {

    @PrimaryKey
    private String shortName;
    private String fullName;

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
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

    private Boolean isSelected;

    public Language(LanguageEntity languageEntity) {
        this.shortName = languageEntity.getShortName();
        this.fullName = languageEntity.getFullName();
    }

}

