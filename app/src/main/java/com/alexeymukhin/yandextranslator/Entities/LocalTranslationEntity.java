package com.alexeymukhin.yandextranslator.Entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;


public class LocalTranslationEntity
        extends RealmObject {

    @Getter
    @Setter
    private long time;

    @PrimaryKey
    private String compoundPrimaryKey;

    @Getter
    @Setter
    private String fromText;

    @Getter
    @Setter
    private String toText;

    @Getter
    @Setter
    private String fromLanguage;

    @Getter
    @Setter
    private String toLanguage;

    @Getter
    @Setter
    private Boolean isFavorite;


    public LocalTranslationEntity() {}

    public LocalTranslationEntity(long time,
                                  String fromText,
                                  String toText,
                                  String fromLanguage,
                                  String toLanguage,
                                  Boolean isFavourite) {
        this.compoundPrimaryKey =
                fromText + " " +
                fromLanguage + " " +
                toLanguage + " " + isFavourite;
        this.time = time;
        this.fromLanguage = fromLanguage;
        this.toLanguage = toLanguage;
        this.fromText = fromText;
        this.toText = toText;
        this.isFavorite = isFavourite;
    }

}