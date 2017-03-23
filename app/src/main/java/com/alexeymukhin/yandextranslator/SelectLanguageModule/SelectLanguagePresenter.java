package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import android.app.Activity;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BasePresenter;
import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.ArrayList;


public class SelectLanguagePresenter
        extends BasePresenter<SelectLanguageActivityInput, SelectLanguageRouterInput, SelectLanguageInteractorInput>
        implements SelectLanguagePresenterInput {


    // ============================= Input Interface =========================

    @Override
    public void getLanguages() {
        getInteractor().getLanguages();
    }

    @Override
    public void selectLanguage(String language){

    }

    // ============================= Output Interface ========================


    @Override
    public void didGetLanguages(ArrayList<Language> languages) {
        getView().didGet(languages);
    }

    @Override
    public void didGetError() {

    }

}
