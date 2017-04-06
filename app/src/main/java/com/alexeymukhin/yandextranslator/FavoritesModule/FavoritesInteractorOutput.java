package com.alexeymukhin.yandextranslator.FavoritesModule;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.ArrayList;

interface FavoritesInteractorOutput {

    void didGetLanguages(ArrayList<Language> languages);

    void didSelectLanguage();

    void didGetError();

}
