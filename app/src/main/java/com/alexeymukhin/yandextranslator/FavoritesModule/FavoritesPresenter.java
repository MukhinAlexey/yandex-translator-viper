package com.alexeymukhin.yandextranslator.FavoritesModule;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BasePresenter;
import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class FavoritesPresenter
        extends BasePresenter<FavoritesActivityInput, FavoritesRouterInput, FavoritesInteractorInput>
        implements FavoritesPresenterInput {


    // ============================= Input Interface =========================

    @Override
    public void getLanguages() {
        getInteractor().getLanguages();
    }

    @Override
    public void selectLanguage(String language, Boolean isLanguageFrom){
        getInteractor().selectLanguage(language, isLanguageFrom);
    }

    // ============================= Output Interface ========================

    @Override
    public void didGetLanguages(ArrayList<Language> languages) {
        Comparator<Language> comparator = new Comparator<Language>() {
            @Override
            public int compare(Language o1, Language o2) {
                if (o1.getFullName().compareTo(o2.getFullName()) > 0) {
                    return 1;
                } else if (o1.getFullName().compareTo(o2.getFullName()) < 0) {
                    return -1;
                }
                return 0;
            }
        };
        Collections.sort(languages, comparator);
        getView().didGet(languages);
    }

    @Override
    public void didSelectLanguage() {
        getView().didSelectLanguage();
    }

    @Override
    public void didGetError() {

    }

}