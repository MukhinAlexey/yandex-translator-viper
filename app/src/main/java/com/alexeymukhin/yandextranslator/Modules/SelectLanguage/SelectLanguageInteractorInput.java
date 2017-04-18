package com.alexeymukhin.yandextranslator.Modules.SelectLanguage;

interface SelectLanguageInteractorInput {

    void getLanguages();

    void selectLanguage(String language, Boolean isFromLanguage);

}
