package com.alexeymukhin.yandextranslator.Modules.Favorites;

import com.alexeymukhin.yandextranslator.Objects.Translation;

import java.util.ArrayList;

interface FavoritesActivityInput {

    void didGet(ArrayList<Translation> translations);

    void didClearFavorites();

}