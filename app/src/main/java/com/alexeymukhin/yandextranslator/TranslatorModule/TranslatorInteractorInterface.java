package com.alexeymukhin.yandextranslator.TranslatorModule;

interface TranslatorInteractorInput {

    void getTranslation(String textToTranslate);

    void checkLanguage(String textToCheck);

}

interface TranslatorInteractorOutput {

    void didGetTranslation(String translatedText);

    void didCheckLanguage(String translatedText);

    void didGetError();


}
