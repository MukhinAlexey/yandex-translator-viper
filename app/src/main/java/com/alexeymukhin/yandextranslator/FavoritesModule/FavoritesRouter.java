package com.alexeymukhin.yandextranslator.FavoritesModule;

import android.app.Activity;
import android.content.Intent;

public class FavoritesRouter implements FavoritesRouterInput {

    @Override
    public void showLanguageSelectActivityOver(Activity parentActivity) {
        Intent intent = new Intent(parentActivity, FavoritesActivity.class);
        parentActivity.startActivity(intent);
    }
}
