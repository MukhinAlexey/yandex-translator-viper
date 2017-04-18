package com.alexeymukhin.yandextranslator.Services.Datastore;

import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;

public interface TranslationsDatabase {

    void getTranslationHistory(Escaping<List<LocalTranslationEntity>> escaping);
    void saveIntoTranslationHistory(LocalTranslationEntity translation);
    void clearTranslationHistory();

    void getFavorites(Escaping<List<LocalTranslationEntity>> escaping);
    void addToFavorites(LocalTranslationEntity translation);
    void clearFavorites();
}
