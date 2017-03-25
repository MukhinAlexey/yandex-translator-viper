package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Entities.TranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.Datastore.Database;

import java.util.Map;

class TranslatorInteractor
        extends BaseInteractor<TranslatorPresenterInput>
        implements TranslatorInteractorInput {

    private Database database;

    private APIService server;

    void setServer(APIService server) {
        this.server = server;
    }

    void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void getSelectedLanguages() {
        this.database.getSelectedLanguages(new Escaping<Map<String, String>>() {
            @Override
            public void onSuccess(Map<String, String> response) {
                getPresenter().didGetSelectedLanguages(
                        response.get("fromLanguage"),
                        response.get("toLanguage")
                );
            }

            @Override
            public void onFailure(Throwable error) {

            }
        });
    }

    @Override
    public void translate(String text, String fromLanguage, String toLanguage) {
        server.getTranslation(text, "en-ru", new Escaping<TranslationEntity>() {
            @Override
            public void onSuccess(TranslationEntity response) {
                getPresenter().didTranslate(response.getText().get(0));
            }

            @Override
            public void onFailure(Throwable error) {

            }
        });
    }
}
