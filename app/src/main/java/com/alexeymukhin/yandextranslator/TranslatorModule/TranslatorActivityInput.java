package com.alexeymukhin.yandextranslator.TranslatorModule;

interface TranslatorActivityInput {

    void didGetSelectedLanguages(String fromLanguage, String toLanguage);

    void didTranslate(String text);

}