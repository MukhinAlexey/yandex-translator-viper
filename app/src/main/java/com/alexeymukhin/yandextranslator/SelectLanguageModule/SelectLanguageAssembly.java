package com.alexeymukhin.yandextranslator.SelectLanguageModule;


import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.API.APIServiceImpl;
import com.alexeymukhin.yandextranslator.Services.Datastore.Database;
import com.alexeymukhin.yandextranslator.Services.Datastore.RealmDatabase;
import com.alexeymukhin.yandextranslator.TranslatorModule.TranslatorActivity;
import com.alexeymukhin.yandextranslator.TranslatorModule.TranslatorPresenter;
import com.alexeymukhin.yandextranslator.TranslatorModule.TranslatorRouter;

public class SelectLanguageAssembly {
    public static final SelectLanguageAssembly INSTANCE = new SelectLanguageAssembly();

    public void configure(SelectLanguageActivity selectLanguageActivity) {
        SelectLanguagePresenter selectLanguagePresenter = new SelectLanguagePresenter();
        SelectLanguageInteractor selectLanguageInteractor = new SelectLanguageInteractor();
        SelectLanguageRouterInput selectLanguageRouter = new SelectLanguageRouter();
        Database realmDatabase = new RealmDatabase();

        selectLanguageInteractor.setPresenter(selectLanguagePresenter);
        selectLanguageInteractor.setDatabase(realmDatabase);
        selectLanguagePresenter.setInteractor(selectLanguageInteractor);
        selectLanguagePresenter.setRouter(selectLanguageRouter);
        selectLanguagePresenter.setView(selectLanguageActivity);
        selectLanguageActivity.setPresenter(selectLanguagePresenter);
    }
}
