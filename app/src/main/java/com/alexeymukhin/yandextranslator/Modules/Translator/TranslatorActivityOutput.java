package com.alexeymukhin.yandextranslator.Modules.Translator;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.Map;

interface TranslatorActivityOutput {

    void getSelectedLanguages();
    void swapSelectedLanguages();

    void addToFavorites();

    void getTranslationHistory();
    void clearTranslationHistory();

    void translate(String text, Map<String, Language> fromToLanguages);

    // ===== Navigation =====
    void showSelectLanguageActivity(Boolean isFromLanguage);
    void showFavoritesActivity();
}
