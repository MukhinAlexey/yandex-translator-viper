package com.alexeymukhin.yandextranslator.Modules.Translator;


import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.API.APIServiceImpl;
import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabase;
import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabaseImpl;
import com.alexeymukhin.yandextranslator.Services.Datastore.TranslationsDatabase;
import com.alexeymukhin.yandextranslator.Services.Datastore.TranslationsDatabaseImpl;

class TranslatorAssembly {
    static final TranslatorAssembly INSTANCE = new TranslatorAssembly();

    void configure(TranslatorActivity translatorActivity) {
        TranslatorPresenter translatorPresenter = new TranslatorPresenter();
        TranslatorInteractor translatorInteractor = new TranslatorInteractor();
        TranslatorRouter translatorRouter = new TranslatorRouter();

        APIService server = new APIServiceImpl();

        TranslationsDatabase translationsDatabase = new TranslationsDatabaseImpl();
        LanguagesDatabase languagesDatabase = new LanguagesDatabaseImpl();

        translatorRouter.setTranslatorActivity(translatorActivity);
        translatorInteractor.setPresenter(translatorPresenter);
        translatorInteractor.setServer(server);
        translatorInteractor.setTranslationsDatabase(translationsDatabase);
        translatorInteractor.setLanguagesDatabase(languagesDatabase);
        translatorPresenter.setInteractor(translatorInteractor);
        translatorPresenter.setRouter(translatorRouter);
        translatorPresenter.setView(translatorActivity);
        translatorActivity.setPresenter(translatorPresenter);
    }
}
