package com.alexeymukhin.yandextranslator.TranslatorModule;


public class TranslatorAssembly {
    public static final TranslatorAssembly INSTANCE = new TranslatorAssembly();

    public void configure(TranslatorActivity translatorActivity) {
        TranslatorPresenter translatorPresenter = new TranslatorPresenter();
        TranslatorInteractor translatorInteractor = new TranslatorInteractor();
        TranslatorRouter translatorRouter = new TranslatorRouterImpl();
        // APIService server = new APIServiceImpl();

        translatorInteractor.setPresenter(translatorPresenter);
        // TranslatorInteractor.setServer(server);
        translatorPresenter.setInteractor(translatorInteractor);
        translatorPresenter.setRouter(translatorRouter);
        translatorPresenter.setView(translatorActivity);
        translatorActivity.setPresenter(translatorPresenter);
    }
}
