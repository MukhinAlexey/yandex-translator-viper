package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.Map;

interface TranslatorActivityOutput {

    void getSelectedLanguages();

    void getTranslationHistory();

    void swapSelectedLanguages();

    void translate(String text, Map<String, Language> fromToLanguages);

    void showSelectLanguageActivity(Boolean isFromLanguage);

    void showFavoritesActivity();

}
