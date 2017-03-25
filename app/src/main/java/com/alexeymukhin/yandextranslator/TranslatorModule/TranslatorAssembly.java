package com.alexeymukhin.yandextranslator.TranslatorModule;


import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.API.APIServiceImpl;
import com.alexeymukhin.yandextranslator.Services.Datastore.Database;
import com.alexeymukhin.yandextranslator.Services.Datastore.RealmDatabase;

public class TranslatorAssembly {
    public static final TranslatorAssembly INSTANCE = new TranslatorAssembly();

    public void configure(TranslatorActivity translatorActivity) {
        TranslatorPresenter translatorPresenter = new TranslatorPresenter();
        TranslatorInteractor translatorInteractor = new TranslatorInteractor();
        TranslatorRouter translatorRouter = new TranslatorRouter();
        APIService server = new APIServiceImpl();
        Database realmDatabase = new RealmDatabase();


        translatorRouter.setTranslatorActivity(translatorActivity);
        translatorInteractor.setPresenter(translatorPresenter);
        translatorInteractor.setServer(server);
        translatorInteractor.setDatabase(realmDatabase);
        translatorPresenter.setInteractor(translatorInteractor);
        translatorPresenter.setRouter(translatorRouter);
        translatorPresenter.setView(translatorActivity);
        translatorActivity.setPresenter(translatorPresenter);
    }
}
