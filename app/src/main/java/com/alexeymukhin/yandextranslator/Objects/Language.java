package com.alexeymukhin.yandextranslator.Objects;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;

import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

public class Language {

    @Getter
    @Setter
    private String shortName;

    @Getter
    @Setter
    private String fullName;

    @Getter
    @Setter
    private Boolean isSelected;

    public Language(LanguageEntity languageEntity) {
        this.shortName = languageEntity.getShortName();
        this.fullName = languageEntity.getFullName();
    }

}

