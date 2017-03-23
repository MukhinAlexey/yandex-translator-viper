package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BasePresenter;


public class TranslatorPresenter
        extends BasePresenter<TranslatorActivityInput, TranslatorRouterInput, TranslatorInteractorInput>
        implements TranslatorPresenterInput {


    // ============================= Input Interface =========================

    @Override
    public void translate(String text, String fromLanguage, String toLanguage) {
        getInteractor().translate(text, fromLanguage, toLanguage);
    }


    @Override
    public void showSelectLanguageActivityOver(Activity parentActivity) {
        this.getRouter().showLanguageSelectActivityOver(parentActivity);
    }


    // ============================= Output Interface ========================

    @Override
    public void didGetSelectedLanguages(String fromLanguage, String toLanguage) {
        this.getView().didGetSelectedLanguages(fromLanguage, toLanguage);
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
