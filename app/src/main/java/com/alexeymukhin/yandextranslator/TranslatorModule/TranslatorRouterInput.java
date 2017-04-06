package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;

interface TranslatorRouterInput {
    void showLanguageSelectActivity(Boolean isFromLanguage);
    void showFavoritesActivity();

}
