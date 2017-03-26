package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.TranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.Datastore.Database;

import java.util.HashMap;
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
        this.database.getSelectedLanguages(new Escaping<Map<String, LanguageEntity>>() {
            @Override
            public void onSuccess(Map<String, LanguageEntity> response) {
                Map<String, Language> fromToLanguage = new HashMap<String, Language>();
                fromToLanguage.put("fromLanguage", new Language(response.get("fromLanguage")));
                fromToLanguage.put("toLanguage", new Language(response.get("toLanguage")));
                getPresenter().didGetSelectedLanguages(fromToLanguage);
            }

            @Override
            public void onFailure(Throwable error) {

            }
        });
    }

    @Override
    public void translate(String text, String fromLanguage, String toLanguage) {
        String direction = fromLanguage.concat("-").concat(toLanguage);
        server.getTranslation(text, direction, new Escaping<TranslationEntity>() {
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
