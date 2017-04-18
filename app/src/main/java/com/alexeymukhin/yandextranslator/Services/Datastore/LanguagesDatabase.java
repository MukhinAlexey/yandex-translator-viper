package com.alexeymukhin.yandextranslator.Services.Datastore;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;
import java.util.Map;

public interface LanguagesDatabase {

    void saveLanguage(LanguageEntity language);
    void saveLanguages(Map<String, String> languages);

    void getLanguages(Escaping<List<LanguageEntity>> escaping);
    void getSelectedLanguages(Escaping<Map<String, LanguageEntity>> escaping);
    void swapSelectedLanguages(Map<String, LanguageEntity> fromToLanguages,
                               Escaping<Map<String, LanguageEntity>> escaping);

    void selectLanguage(String language, Boolean isFromLanguage);

}
