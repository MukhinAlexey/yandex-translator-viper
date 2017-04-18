package com.alexeymukhin.yandextranslator.Modules.SelectLanguage;


import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabase;
import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabaseImpl;

public class SelectLanguageAssembly {
    public static final SelectLanguageAssembly INSTANCE = new SelectLanguageAssembly();

    public void configure(SelectLanguageActivity selectLanguageActivity) {
        SelectLanguagePresenter selectLanguagePresenter = new SelectLanguagePresenter();
        SelectLanguageInteractor selectLanguageInteractor = new SelectLanguageInteractor();
        SelectLanguageRouterInput selectLanguageRouter = new SelectLanguageRouter();
        LanguagesDatabase languagesDatabase = new LanguagesDatabaseImpl();

        selectLanguageInteractor.setPresenter(selectLanguagePresenter);
        selectLanguageInteractor.setLanguagesDatabase(languagesDatabase);
        selectLanguagePresenter.setInteractor(selectLanguageInteractor);
        selectLanguagePresenter.setRouter(selectLanguageRouter);
        selectLanguagePresenter.setView(selectLanguageActivity);
        selectLanguageActivity.setPresenter(selectLanguagePresenter);
    }
}
