package com.alexeymukhin.yandextranslator.TranslatorModule;

interface TranslatorInteractorOutput {

    void didGetSelectedLanguages(String fromLanguage, String toLanguage);

    void didTranslate(String text);

    void didCheckLanguage(String translatedText);

    void didGetError();


}
