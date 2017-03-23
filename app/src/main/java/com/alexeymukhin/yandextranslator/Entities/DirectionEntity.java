package com.alexeymukhin.yandextranslator.Entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DirectionEntity
        extends RealmObject {

    @PrimaryKey
    private String fromLanguage;
    private String toLanguage;

    public DirectionEntity() {

    }

    public DirectionEntity(String fromLanguageToLanguage) {
        String[] fromLanguageToLanguageArray = fromLanguageToLanguage.split("-");
        this.fromLanguage = fromLanguageToLanguageArray[0];
        this.toLanguage = fromLanguageToLanguageArray[1];
    }

    public String getFromLanguage() {
        return fromLanguage;
    }

    public void setFromLanguage(String fromLanguage) {
        this.fromLanguage = fromLanguage;
    }

    public String getToLanguage() {
        return toLanguage;
    }

    public void setToLanguage(String toLanguage) {
        this.toLanguage = toLanguage;
    }

}
