package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Entities.RecognizedLanguage;
import com.alexeymukhin.yandextranslator.Entities.SupportedLanguages;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseInteractor;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Services.API.APIServiceImpl;
import com.alexeymukhin.yandextranslator.Services.API.APIService;

import java.util.ArrayList;

public class TranslatorInteractor
        extends BaseInteractor<TranslatorPresenterInput>
        implements TranslatorInteractorInput {

    private APIService server;

    public APIService getServer() {
        return server;
    }

    public void setServer(APIService server) {
        this.server = server;
    }

    @Override
    public void checkLanguage(String textToCheck) {
        this.server.checkLanguage(textToCheck, new ArrayList<String>(), new Escaping<RecognizedLanguage>() {
            @Override
            public void onSuccess(RecognizedLanguage response) {
                getPresenter().didCheckLanguage("");
            }

            @Override
            public void onFailure(Throwable error) {
                getPresenter().didGetError();
            }
        });
    }

    @Override
    public void getTranslation(String textToTranslate) {
        //this.server.checkLanguage();
    }
}
