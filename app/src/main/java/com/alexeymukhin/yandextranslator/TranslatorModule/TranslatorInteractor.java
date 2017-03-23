package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Entities.TranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Services.API.APIService;

class TranslatorInteractor
        extends BaseInteractor<TranslatorPresenterInput>
        implements TranslatorInteractorInput {

    private APIService server;

    void setServer(APIService server) {
        this.server = server;
    }

    @Override
    public void getSelectedLanguages() {
        getPresenter().didGetSelectedLanguages("Русский", "Английский");
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
