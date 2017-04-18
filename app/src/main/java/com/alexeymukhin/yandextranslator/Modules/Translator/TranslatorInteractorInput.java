package com.alexeymukhin.yandextranslator.Modules.Translator;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.Map;

interface TranslatorInteractorInput {

    void getSelectedLanguages();

    void swapSelectedLanguages();

    void translate(String text, Map<String, Language> fromToLanguages);

    void addToFavorites();

    void getTranslationHistory();

    void clearTranslationHistory();
}
