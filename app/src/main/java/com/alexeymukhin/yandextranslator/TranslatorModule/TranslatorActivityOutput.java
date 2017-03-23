package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;

interface TranslatorActivityOutput {

    void getSelectedLanguages();

    void translate(String text, String fromLanguage, String toLanguage);

    void showSelectLanguageActivityOver(Activity parentActivity);

}
