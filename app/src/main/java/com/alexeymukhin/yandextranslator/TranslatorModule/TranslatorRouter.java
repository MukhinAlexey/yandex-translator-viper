package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;
import android.content.Intent;

import com.alexeymukhin.yandextranslator.SelectLanguageModule.SelectLanguageActivity;

public class TranslatorRouter implements TranslatorRouterInput {

    @Override
    public void showLanguageSelectActivityOver(Activity parentActivity) {
        Intent intent = new Intent(parentActivity, SelectLanguageActivity.class);
        parentActivity.startActivity(intent);
    }
}
