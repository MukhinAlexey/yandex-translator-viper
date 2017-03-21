package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;

interface TranslatorActivityOutput {

    void getTranslation(String textToTranslate);

    void showSelectLanguageActivityOver(Activity parentActivity);

}

interface TranslatorActivityInput {

    void didGetSupportedLanguages();
}