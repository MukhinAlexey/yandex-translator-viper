package com.alexeymukhin.yandextranslator.Modules.Translator;

import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;
import com.alexeymukhin.yandextranslator.Entities.ServerTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabase;
import com.alexeymukhin.yandextranslator.Services.Datastore.TranslationsDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Setter;

class TranslatorInteractor
        extends BaseInteractor<TranslatorPresenterInput>
        implements TranslatorInteractorInput {

    @Setter
    private LanguagesDatabase languagesDatabase;

    @Setter
    private TranslationsDatabase translationsDatabase;

    @Setter
    private APIService server;

    private LocalTranslationEntity currentTranslation;

    private Map<String, LanguageEntity> fromToLanguageMap;

    @Override
    public void getSelectedLanguages() {
        languagesDatabase.getSelectedLanguages(new Escaping<Map<String, LanguageEntity>>() {
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
        languagesDatabase.swapSelectedLanguages(fromToLanguageMap,
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
                    currentTranslation = new LocalTranslationEntity(
                            System.currentTimeMillis(),
                            text,
                            response.getTranslatedText(),
                            fromToLanguages.get("fromLanguage").getFullName(),
                            fromToLanguages.get("toLanguage").getFullName(),
                            false);
                    translationsDatabase.saveIntoTranslationHistory(currentTranslation);
                    getPresenter().didTranslate(response.getTranslatedText());
                }
            }
            @Override
            public void onFailure(Throwable error) {

            }
        });
    }

    @Override
    public void addToFavorites() {
        translationsDatabase.addToFavorites(currentTranslation);
    }

    @Override
    public void getTranslationHistory() {
        translationsDatabase.getTranslationHistory(new Escaping<List<LocalTranslationEntity>>() {
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

    @Override
    public void clearTranslationHistory() {
        translationsDatabase.clearTranslationHistory();
        getPresenter().didCleanTranslationHistory();
    }
}
