package com.alexeymukhin.yandextranslator.TranslatorModule;

interface TranslatorInteractorOutput {

    void didGetSelectedLanguages(String fromLanguage, String toLanguage);

    void didGetTranslation(String translatedText);

    void didCheckLanguage(String translatedText);

    void didGetError();


}
