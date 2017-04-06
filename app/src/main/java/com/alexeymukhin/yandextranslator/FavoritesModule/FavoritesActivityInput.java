package com.alexeymukhin.yandextranslator.FavoritesModule;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.ArrayList;

interface FavoritesActivityInput {

    void didGet(ArrayList<Language> languages);

    void didSelectLanguage();

}