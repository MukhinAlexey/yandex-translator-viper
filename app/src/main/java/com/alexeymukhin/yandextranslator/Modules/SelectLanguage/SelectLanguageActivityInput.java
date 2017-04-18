package com.alexeymukhin.yandextranslator.Modules.SelectLanguage;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.ArrayList;

interface SelectLanguageActivityInput {

    void didGet(ArrayList<Language> languages);

    void didSelectLanguage();

}