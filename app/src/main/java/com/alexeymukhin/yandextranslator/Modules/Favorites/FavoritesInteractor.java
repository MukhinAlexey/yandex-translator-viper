package com.alexeymukhin.yandextranslator.Modules.Favorites;

import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Translation;
import com.alexeymukhin.yandextranslator.Services.Datastore.TranslationsDatabase;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

class FavoritesInteractor
        extends BaseInteractor<FavoritesPresenterInput>
        implements FavoritesInteractorInput {

    @Setter
    private TranslationsDatabase translationsDatabase;

    private ArrayList<LocalTranslationEntity> translations;

    @Override
    public void getFavorites() {
        translationsDatabase.getFavorites(new Escaping<List<LocalTranslationEntity>>() {
            @Override
            public void onSuccess(List<LocalTranslationEntity> response) {
                translations = (ArrayList<LocalTranslationEntity>) response;
                getPresenter().didGetTranslations(transformToPOJO(translations));
            }
            @Override
            public void onFailure(Throwable error) {

            }
        });
    }

    @Override
    public void clearFavorites() {
        translationsDatabase.clearFavorites();
        getPresenter().didClearFavorites();
    }

    private ArrayList<Translation> transformToPOJO(ArrayList<LocalTranslationEntity> languageEntities) {
        ArrayList<Translation> languages = new ArrayList<Translation>();
        for (LocalTranslationEntity languageEntity : languageEntities) {
            languages.add(new Translation(languageEntity));
        }
        return languages;
    }
}
