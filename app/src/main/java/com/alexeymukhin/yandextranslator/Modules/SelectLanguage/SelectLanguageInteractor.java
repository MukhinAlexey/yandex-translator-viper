package com.alexeymukhin.yandextranslator.Modules.SelectLanguage;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabase;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

class SelectLanguageInteractor
        extends BaseInteractor<SelectLanguagePresenterInput>
        implements SelectLanguageInteractorInput {

    @Setter
    private LanguagesDatabase languagesDatabase;

    private ArrayList<LanguageEntity> languages;

    @Override
    public void getLanguages() {
        languagesDatabase.getLanguages(new Escaping<List<LanguageEntity>>() {
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

    @Override
    public void selectLanguage(String language, Boolean isFromLanguage) {
        this.languagesDatabase.selectLanguage(language, isFromLanguage);
        getPresenter().didSelectLanguage();
    }

    private ArrayList<Language> transformToPOJO(ArrayList<LanguageEntity> languageEntities) {
        ArrayList<Language> languages = new ArrayList<Language>();
        for (LanguageEntity languageEntity : languageEntities) {
            languages.add(new Language(languageEntity));
        }
        return languages;
    }
}
