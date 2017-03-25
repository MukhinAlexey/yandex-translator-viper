package com.alexeymukhin.yandextranslator.LoadingModule;

import com.alexeymukhin.yandextranslator.Entities.DirectionEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageConfigEntity;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.Datastore.Database;

import java.util.Map;


class LoadingInteractor
        extends BaseInteractor<LoadingPresenterInput>
        implements LoadingInteractorInput {

    private APIService server;
    private Database database;

    public APIService getServer() {
        return server;
    }

    void setServer(APIService server) {
        this.server = server;
    }

    public Database getDatabase() {
        return database;
    }

    void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void getSupportedLanguages(String uiLanguage) {
        this.server.getSupportedLanguages(uiLanguage, new Escaping<LanguageConfigEntity>() {
            @Override
            public void onSuccess(LanguageConfigEntity response) {
                database.saveDirections(response.getDirections());
                database.saveLanguages(response.getLanguages());
                getPresenter().didGetSupportedLanguages();
            }
            @Override
            public void onFailure(Throwable error) {

            }
        });
    }
}
