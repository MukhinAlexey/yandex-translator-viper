package com.alexeymukhin.yandextranslator.Modules.Favorites;

import com.alexeymukhin.yandextranslator.Services.Datastore.TranslationsDatabase;
import com.alexeymukhin.yandextranslator.Services.Datastore.TranslationsDatabaseImpl;

class FavoritesAssembly {
    static final FavoritesAssembly INSTANCE = new FavoritesAssembly();

    void configure(FavoritesActivity favoritesActivity) {
        FavoritesPresenter selectLanguagePresenter = new FavoritesPresenter();
        FavoritesInteractor favoritesInteractor = new FavoritesInteractor();
        FavoritesRouterInput selectLanguageRouter = new FavoritesRouter();
        TranslationsDatabase translationsDatabase = new TranslationsDatabaseImpl();

        favoritesInteractor.setPresenter(selectLanguagePresenter);
        favoritesInteractor.setTranslationsDatabase(translationsDatabase);
        selectLanguagePresenter.setInteractor(favoritesInteractor);
        selectLanguagePresenter.setRouter(selectLanguageRouter);
        selectLanguagePresenter.setView(favoritesActivity);
        favoritesActivity.setPresenter(selectLanguagePresenter);
    }
}
