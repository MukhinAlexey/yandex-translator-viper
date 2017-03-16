package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BasePresenter;


public class TranslatorPresenter
        extends BasePresenter<TranslatorActivityInput, TranslatorRouter, TranslatorInteractorInput>
        implements TranslatorPresenterInput {

    @Override
    public void getTranslation(String textToTranslate) {
        this.getInteractor().getTranslation(textToTranslate);
    }

    @Override
    public void showSelectLanguageActivityOver(Activity parentActivity) {
        this.getRouter().showLanguageSelectActivityOver(parentActivity);
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
