package com.alexeymukhin.yandextranslator.Modules.SelectLanguage;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.ArrayList;

interface SelectLanguageInteractorOutput {

    void didGetLanguages(ArrayList<Language> languages);

    void didSelectLanguage();

    void didGetError();

}
