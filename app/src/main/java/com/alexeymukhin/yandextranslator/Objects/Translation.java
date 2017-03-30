package com.alexeymukhin.yandextranslator.Objects;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;

import io.realm.annotations.PrimaryKey;


public class Translation {

    private long time;

    private String fromLanguage;

    private String toLanguage;

    private String fromText;
    private String toText;

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

    public Translation() {

    }

    public Translation(LocalTranslationEntity localTranslationEntity) {
        this.time = localTranslationEntity.getTime();
        this.fromLanguage = localTranslationEntity.getFromLanguage();
        this.toLanguage = localTranslationEntity.getToLanguage();
        this.fromText = localTranslationEntity.getFromText();
        this.toText = localTranslationEntity.getToText();
    }
}
