package com.alexeymukhin.yandextranslator.Entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class LocalTranslationEntity
        extends RealmObject {

    private long time;

    @PrimaryKey
    private String compoundPrimaryKey;

    private String fromText;
    private String toText;

    private String fromLanguage;

    private String toLanguage;


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

    public String getFromText() {
        return fromText;
    }

    public void setFromText(String fromText) {
        this.fromText = fromText;
    }

    public String getToText() {
        return toText;
    }

    public void setToText(String toText) {
        this.toText = toText;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public LocalTranslationEntity() {

    }

    public LocalTranslationEntity(long time,
                                  String fromText,
                                  String toText,
                                  String fromLanguage,
                                  String toLanguage) {
        this.compoundPrimaryKey = fromText + " " + fromLanguage + " " + toLanguage;
        this.time = time;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
        this.fromText = fromText;
        this.toText = toText;
    }

}