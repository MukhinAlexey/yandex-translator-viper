package com.alexeymukhin.yandextranslator.Modules.Loading;

import com.alexeymukhin.yandextranslator.Entities.LanguageConfigEntity;
import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.Datastore.DirectionsDatabase;
import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabase;

import lombok.Setter;

class LoadingInteractor
        extends BaseInteractor<LoadingPresenterInput>
        implements LoadingInteractorInput {

    @Setter
    private APIService server;

    @Setter
    private LanguagesDatabase languagesDatabase;

    @Setter
    private DirectionsDatabase directionsDatabase;

    @Override
    public void getSupportedLanguages(String uiLanguage) {
        this.server.getSupportedLanguages(uiLanguage, new Escaping<LanguageConfigEntity>() {
            @Override
            public void onSuccess(LanguageConfigEntity response) {
                directionsDatabase.saveDirections(response.getDirections());
                languagesDatabase.saveLanguages(response.getLanguages());
                getPresenter().didGetSupportedLanguages();
            }
            @Override
            public void onFailure(Throwable error) {

            }
        });
    }
}
