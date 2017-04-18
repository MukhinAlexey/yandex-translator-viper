package com.alexeymukhin.yandextranslator.Entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class LanguageEntity
        extends RealmObject {

    @Getter
    @Setter
    @PrimaryKey
    private String shortName;

    @Getter
    @Setter
    private String fullName;

    @Getter
    @Setter
    private Boolean isFromSelected;

    @Getter
    @Setter
    private Boolean isToSelected;

    public LanguageEntity() {}

    public LanguageEntity(String shortName, String fullName) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.isFromSelected = false;
        this.isToSelected = false;
    }
}