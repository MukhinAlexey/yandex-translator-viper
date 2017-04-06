package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;
import com.alexeymukhin.yandextranslator.Entities.ServerTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.Datastore.Database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TranslatorInteractor
        extends BaseInteractor<TranslatorPresenterInput>
        implements TranslatorInteractorInput {

    private Database database;

    private APIService server;

    private Map<String, LanguageEntity> fromToLanguageMap;

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
                fromToLanguageMap = response;
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
    public void swapSelectedLanguages() {
        this.database.swapSelectedLanguages(fromToLanguageMap,
                new Escaping<Map<String, LanguageEntity>>() {
            @Override
            public void onSuccess(Map<String, LanguageEntity> response) {
                fromToLanguageMap = response;
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
    public void translate(final String text,
                          final Map<String, Language> fromToLanguages) {

        String direction =
                fromToLanguages.get("fromLanguage").getShortName()
                .concat("-")
                .concat(fromToLanguages.get("toLanguage").getShortName());

        server.getTranslation(text, direction, new Escaping<ServerTranslationEntity>() {
            @Override
            public void onSuccess(ServerTranslationEntity response) {

                if (response != null) {
                    database.saveIntoTranslationHistory(
                            new LocalTranslationEntity(
                                    System.currentTimeMillis(),
                                    text,
                                    response.getText().toString(),
                                    fromToLanguages.get("fromLanguage").getFullName(),
                                    fromToLanguages.get("toLanguage").getFullName()));

                    getPresenter().didTranslate(response.getText().get(0));
                }
            }
            @Override
            public void onFailure(Throwable error) {

            }
        });
    }

    @Override
    public void getTranslationHistory() {
        database.getTranslationHistory(new Escaping<List<LocalTranslationEntity>>() {
            @Override
            public void onSuccess(List<LocalTranslationEntity> response) {
                List<Translation> translations = new ArrayList<Translation>();
                for (LocalTranslationEntity localTranslationEntity : response){
                    translations.add(new Translation(localTranslationEntity));
                }
                getPresenter().didGetTranslationHistory(translations);
            }

            @Override
            public void onFailure(Throwable error) {

            }
        });
    }
}
