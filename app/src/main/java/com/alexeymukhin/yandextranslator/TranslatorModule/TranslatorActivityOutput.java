package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;

interface TranslatorActivityOutput {

    void getSelectedLanguages();

    void getTranslationHistory();

    void swapSelectedLanguages();

    void translate(String text, String fromLanguage, String toLanguage);

    void showSelectLanguageActivity(Boolean isFromLanguage);

}
