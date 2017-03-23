package com.alexeymukhin.yandextranslator.TranslatorModule;

interface TranslatorInteractorInput {

    void getSelectedLanguages();

    void translate(String text, String fromLanguage, String toLanguage);

}
