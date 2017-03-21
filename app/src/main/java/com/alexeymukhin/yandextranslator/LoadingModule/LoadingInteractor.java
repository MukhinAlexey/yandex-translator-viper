package com.alexeymukhin.yandextranslator.LoadingModule;

import com.alexeymukhin.yandextranslator.Entities.SupportedLanguages;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Services.API.APIService;


class LoadingInteractor
        extends BaseInteractor<LoadingPresenterInput>
        implements LoadingInteractorInput {

    private APIService server;

    public APIService getServer() {
        return server;
    }

    void setServer(APIService server) {
        this.server = server;
    }

    @Override
    public void getSupportedLanguages(String uiLanguage) {
        this.server.getSupportedLanguages(uiLanguage, new Escaping<SupportedLanguages>() {
            @Override
            public void onSuccess(SupportedLanguages response) {
                getPresenter().didGetSupportedLanguages();
            }
            @Override
            public void onFailure(Throwable error) {

            }
        });
    }
}
