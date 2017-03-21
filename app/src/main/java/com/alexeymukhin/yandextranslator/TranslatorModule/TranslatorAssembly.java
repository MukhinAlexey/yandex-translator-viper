package com.alexeymukhin.yandextranslator.TranslatorModule;


import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.API.APIServiceImpl;

public class TranslatorAssembly {
    public static final TranslatorAssembly INSTANCE = new TranslatorAssembly();

    public void configure(TranslatorActivity translatorActivity) {
        TranslatorPresenter translatorPresenter = new TranslatorPresenter();
        TranslatorInteractor translatorInteractor = new TranslatorInteractor();
        TranslatorRouterInput translatorRouter = new TranslatorRouter();
        APIService server = new APIServiceImpl();

        translatorInteractor.setPresenter(translatorPresenter);
        translatorInteractor.setServer(server);
        translatorPresenter.setInteractor(translatorInteractor);
        translatorPresenter.setRouter(translatorRouter);
        translatorPresenter.setView(translatorActivity);
        translatorActivity.setPresenter(translatorPresenter);
    }
}
