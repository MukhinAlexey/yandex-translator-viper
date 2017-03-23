package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Services.Datastore.Database;

import java.util.ArrayList;
import java.util.List;

class SelectLanguageInteractor
        extends BaseInteractor<SelectLanguagePresenterInput>
        implements SelectLanguageInteractorInput {

    private Database database;
    private ArrayList<LanguageEntity> languages;

    public Database getDatabase() {
        return database;
    }

    void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void getLanguages() {
        database.getLanguages(new Escaping<List<LanguageEntity>>() {
            @Override
            public void onSuccess(List<LanguageEntity> response) {
                languages = (ArrayList<LanguageEntity>) response;
                getPresenter().didGetLanguages(transformToPOJO(languages));
            }

            @Override
            public void onFailure(Throwable error) {

            }
        });
    }

    private ArrayList<Language> transformToPOJO(ArrayList<LanguageEntity> languageEntities) {
        ArrayList<Language> languages = new ArrayList<Language>();
        for (LanguageEntity languageEntity : languageEntities) {
            languages.add(new Language(languageEntity));
        }
        return languages;
    }
}
