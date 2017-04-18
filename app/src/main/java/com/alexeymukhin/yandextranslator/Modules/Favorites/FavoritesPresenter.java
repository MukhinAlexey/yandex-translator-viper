package com.alexeymukhin.yandextranslator.Modules.Favorites;

import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BasePresenter;
import com.alexeymukhin.yandextranslator.Objects.Translation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class FavoritesPresenter
        extends BasePresenter<FavoritesActivityInput, FavoritesRouterInput, FavoritesInteractorInput>
        implements FavoritesPresenterInput {


    // ===== Input Interface =====

    @Override
    public void getFavorites() {
        getInteractor().getFavorites();
    }

    @Override
    public void clearFavorites() {
        getInteractor().clearFavorites();
    }

    // ===== Output Interface =====

    @Override
    public void didGetTranslations(ArrayList<Translation> translations) {
        Comparator<Translation> comparator = new Comparator<Translation>() {
            @Override
            public int compare(Translation o1, Translation o2) {
                if (o1.getTime() < o2.getTime()) {
                    return 1;
                } else if (o1.getTime() > o2.getTime()) {
                    return -1;
                }
                return 0;
            }
        };
        Collections.sort(translations, comparator);
        getView().didGet(translations);
    }

    @Override
    public void didClearFavorites() {
        getView().didClearFavorites();
    }

    @Override
    public void didGetError() {

    }

}
