package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BasePresenter;
import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.Map;


public class TranslatorPresenter
        extends BasePresenter<TranslatorActivityInput, TranslatorRouterInput, TranslatorInteractorInput>
        implements TranslatorPresenterInput {


    // ============================= Input Interface =========================

    @Override
    public void getSelectedLanguages() {
        getInteractor().getSelectedLanguages();
    }

    @Override
    public void translate(String text, String fromLanguage, String toLanguage) {
        getInteractor().translate(text, fromLanguage, toLanguage);
    }

    @Override
    public void showSelectLanguageActivity(Boolean isFromLanguage) {
        getRouter().showLanguageSelectActivity(isFromLanguage);

    }

    // ============================= Output Interface ========================

    @Override
    public void didGetSelectedLanguages(Map<String, Language> fromToLanguages) {
        getView().didGetSelectedLanguages(fromToLanguages);
    }

    @Override
    public void didTranslate(String text) {
        getView().didTranslate(text);
    }

    @Override
    public void didCheckLanguage(String translatedText) {

    }

    @Override
    public void didGetError() {

    }
}
