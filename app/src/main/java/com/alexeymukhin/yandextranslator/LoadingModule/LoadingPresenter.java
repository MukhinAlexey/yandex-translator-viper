package com.alexeymukhin.yandextranslator.LoadingModule;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BasePresenter;


class LoadingPresenter
        extends BasePresenter<LoadingActivityInput, LoadingRouter, LoadingInteractorInput>
        implements LoadingPresenterInput {

    @Override
    public void getSupportedLanguages(String uiLanguage) {
        getInteractor().getSupportedLanguages(uiLanguage);
    }

    @Override
    public void showTranslatorActivity() {
        this.getRouter().showTranslatorActivity();
    }

    @Override
    public void didGetSupportedLanguages() {
        this.getView().didGetSupportedLanguages();
    }

    @Override
    public void didGetError() {

    }
}

