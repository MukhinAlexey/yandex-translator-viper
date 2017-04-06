package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;
import android.content.Intent;

import com.alexeymukhin.yandextranslator.FavoritesModule.FavoritesActivity;
import com.alexeymukhin.yandextranslator.SelectLanguageModule.SelectLanguageActivity;

public class TranslatorRouter
        implements TranslatorRouterInput {

    private Activity translatorActivity;

    public Activity getTranslatorActivity() {
        return translatorActivity;
    }

    public void setTranslatorActivity(Activity translatorActivity) {
        this.translatorActivity = translatorActivity;
    }

    @Override
    public void showLanguageSelectActivity(Boolean isFromLanguage) {
        Intent intent = new Intent(this.translatorActivity, SelectLanguageActivity.class);
        intent.putExtra("isFromLanguage", isFromLanguage);
        this.translatorActivity.startActivity(intent);
    }

    @Override
    public void showFavoritesActivity() {
        Intent intent = new Intent(this.translatorActivity, FavoritesActivity.class);
        this.translatorActivity.startActivity(intent);
    }


}
