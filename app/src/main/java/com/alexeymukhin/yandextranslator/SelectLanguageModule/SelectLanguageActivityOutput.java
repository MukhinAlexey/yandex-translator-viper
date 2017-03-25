package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import android.app.Activity;

interface SelectLanguageActivityOutput {

    void getLanguages();

    void selectLanguage(String language, Boolean isFrom);

}
