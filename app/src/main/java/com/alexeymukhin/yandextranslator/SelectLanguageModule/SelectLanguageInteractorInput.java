package com.alexeymukhin.yandextranslator.SelectLanguageModule;

interface SelectLanguageInteractorInput {

    void getLanguages();

    void selectLanguage(String language, Boolean isFromLanguage);

}
