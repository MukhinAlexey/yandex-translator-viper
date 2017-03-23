package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.ArrayList;

interface SelectLanguageActivityInput {

    void didGet(ArrayList<Language> languages);
}