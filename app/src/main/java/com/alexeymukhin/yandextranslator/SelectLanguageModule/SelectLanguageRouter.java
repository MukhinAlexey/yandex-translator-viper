package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import android.app.Activity;
import android.content.Intent;

public class SelectLanguageRouter implements SelectLanguageRouterInput {

    @Override
    public void showLanguageSelectActivityOver(Activity parentActivity) {
        Intent intent = new Intent(parentActivity, SelectLanguageActivity.class);
        parentActivity.startActivity(intent);
    }
}
