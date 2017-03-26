package com.alexeymukhin.yandextranslator.Services.Datastore;

import com.alexeymukhin.yandextranslator.Entities.DirectionEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
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

    void selectLanguage(String language, Boolean isFromLanguage);

    void saveToHistory(String fromWord, String toWord);

    boolean isFromLanguageSelected();
}
