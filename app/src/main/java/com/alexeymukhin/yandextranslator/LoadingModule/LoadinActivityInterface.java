package com.alexeymukhin.yandextranslator.LoadingModule;

import android.app.Activity;

interface LoadingActivityOutput {

    void getSupportedLanguages(String uiLanguage);

    void showTranslatorActivity();
}

interface LoadingActivityInput {

    void didGetSupportedLanguages();
}