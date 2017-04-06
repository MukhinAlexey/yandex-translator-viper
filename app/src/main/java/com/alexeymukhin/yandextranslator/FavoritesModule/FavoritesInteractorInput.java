package com.alexeymukhin.yandextranslator.FavoritesModule;

interface FavoritesInteractorInput {

    void getLanguages();

    void selectLanguage(String language, Boolean isFromLanguage);

}
