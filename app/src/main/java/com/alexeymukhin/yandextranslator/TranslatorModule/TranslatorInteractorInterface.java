package com.alexeymukhin.yandextranslator.TranslatorModule;

interface TranslatorInteractorInput {

    void checkLanguage(String textToCheck);

    void getTranslation(String textToTranslate);

}

interface TranslatorInteractorOutput {

    void didGetSupportedLanguages();

    void didGetTranslation(String translatedText);

    void didCheckLanguage(String translatedText);

    void didGetError();


}
