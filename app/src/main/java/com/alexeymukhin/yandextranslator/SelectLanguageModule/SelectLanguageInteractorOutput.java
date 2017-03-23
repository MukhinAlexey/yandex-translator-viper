package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.ArrayList;

interface SelectLanguageInteractorOutput {

    void didGetLanguages(ArrayList<Language> languages);

    void didGetError();

}
