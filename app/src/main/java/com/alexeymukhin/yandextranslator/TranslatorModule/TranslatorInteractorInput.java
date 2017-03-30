package com.alexeymukhin.yandextranslator.TranslatorModule;

interface TranslatorInteractorInput {

    void getSelectedLanguages();

    void swapSelectedLanguages();

    void translate(String text, String fromLanguage, String toLanguage);

    void getTranslationHistory();

}
