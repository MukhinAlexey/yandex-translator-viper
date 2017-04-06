package com.alexeymukhin.yandextranslator.Services.Datastore;

import com.alexeymukhin.yandextranslator.Entities.DirectionEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;
import java.util.Map;

public interface Database {

    void saveDirection(DirectionEntity direction);
    void saveDirections(List<String> directions);

    void saveLanguage(LanguageEntity language);
    void saveLanguages(Map<String, String> languages);

    void getLanguages(Escaping<List<LanguageEntity>> escaping);
    void getSelectedLanguages(Escaping<Map<String, LanguageEntity>> escaping);
    void swapSelectedLanguages(Map<String, LanguageEntity> fromToLanguages,
                               Escaping<Map<String, LanguageEntity>> escaping);

    void selectLanguage(String language, Boolean isFromLanguage);
    void saveToHistory(String fromWord, String toWord);

    void getTranslationHistory(Escaping<List<LocalTranslationEntity>> escaping);
    void saveIntoTranslationHistory(LocalTranslationEntity translation);
    void clearTranslationHistory();

    boolean isFromLanguageSelected();
}
