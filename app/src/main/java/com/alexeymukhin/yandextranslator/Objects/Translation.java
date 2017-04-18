package com.alexeymukhin.yandextranslator.Objects;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;

import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;


public class Translation {

    @Getter
    @Setter
    private long time;

    @Getter
    @Setter
    private String fromLanguage;

    @Getter
    @Setter
    private String toLanguage;

    @Getter
    @Setter
    private String fromText;

    @Getter
    @Setter
    private String toText;

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
