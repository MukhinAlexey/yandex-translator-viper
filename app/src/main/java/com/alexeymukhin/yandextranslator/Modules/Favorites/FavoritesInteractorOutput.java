package com.alexeymukhin.yandextranslator.Modules.Favorites;

import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;

import java.util.ArrayList;

interface FavoritesInteractorOutput {

    void didGetTranslations(ArrayList<Translation> translations);

    void didClearFavorites();

    void didGetError();
}
