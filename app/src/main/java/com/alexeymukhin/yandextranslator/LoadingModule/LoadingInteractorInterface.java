package com.alexeymukhin.yandextranslator.LoadingModule;

interface LoadingInteractorInput {

    void getSupportedLanguages(String uiLanguage);

}

interface LoadingInteractorOutput {

    void didGetSupportedLanguages();

    void didGetError();

}
