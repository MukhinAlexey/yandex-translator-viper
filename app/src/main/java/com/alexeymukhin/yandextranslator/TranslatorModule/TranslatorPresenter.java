package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BasePresenter;


public class TranslatorPresenter
        extends BasePresenter<TranslatorActivityInput, TranslatorRouterInput, TranslatorInteractorInput>
        implements TranslatorPresenterInput {


    // ============================= Input Interface =========================

    @Override
    public void getTranslation(String textToTranslate) {
        this.getInteractor().getTranslation(textToTranslate);
    }

    @Override
    public void showSelectLanguageActivityOver(Activity parentActivity) {
        this.getRouter().showLanguageSelectActivityOver(parentActivity);
    }


    // ============================= Output Interface ========================

    @Override
    public void didGetSupportedLanguages() {
        this.getView().didGetSupportedLanguages();
    }

    @Override
    public void didGetTranslation(String translatedText) {

    }

    @Override
    public void didCheckLanguage(String translatedText) {

    }

    @Override
    public void didGetError() {

    }
}
