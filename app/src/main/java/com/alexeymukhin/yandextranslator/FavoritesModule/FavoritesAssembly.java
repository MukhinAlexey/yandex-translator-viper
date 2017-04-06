package com.alexeymukhin.yandextranslator.FavoritesModule;


import com.alexeymukhin.yandextranslator.Services.Datastore.Database;
import com.alexeymukhin.yandextranslator.Services.Datastore.RealmDatabase;

public class FavoritesAssembly {
    public static final FavoritesAssembly INSTANCE = new FavoritesAssembly();

    public void configure(FavoritesActivity favoritesActivity) {
        FavoritesPresenter selectLanguagePresenter = new FavoritesPresenter();
        FavoritesInteractor favoritesInteractor = new FavoritesInteractor();
        FavoritesRouterInput selectLanguageRouter = new FavoritesRouter();
        Database realmDatabase = new RealmDatabase();

        favoritesInteractor.setPresenter(selectLanguagePresenter);
        favoritesInteractor.setDatabase(realmDatabase);
        selectLanguagePresenter.setInteractor(favoritesInteractor);
        selectLanguagePresenter.setRouter(selectLanguageRouter);
        selectLanguagePresenter.setView(favoritesActivity);
        favoritesActivity.setPresenter(selectLanguagePresenter);
    }
}
