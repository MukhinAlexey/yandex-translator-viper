package com.alexeymukhin.yandextranslator.Entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class DirectionEntity
        extends RealmObject {

    @Getter
    @Setter
    @PrimaryKey
    private String fromLanguage;

    @Getter
    @Setter
    private String toLanguage;

    public DirectionEntity() {}

    public DirectionEntity(String fromLanguageToLanguage) {
        String[] fromLanguageToLanguageArray = fromLanguageToLanguage.split("-");
        this.fromLanguage = fromLanguageToLanguageArray[0];
        this.toLanguage = fromLanguageToLanguageArray[1];
    }
}
