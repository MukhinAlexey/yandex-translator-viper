package com.alexeymukhin.yandextranslator.Modules.Translator;

import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BasePresenter;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class TranslatorPresenter
        extends BasePresenter<TranslatorActivityInput, TranslatorRouterInput, TranslatorInteractorInput>
        implements TranslatorPresenterInput {


    // ===== Input Interface =====
    @Override
    public void getSelectedLanguages() {
        getInteractor().getSelectedLanguages();
    }

    @Override
    public void getTranslationHistory() {
        getInteractor().getTranslationHistory();
    }

    @Override
    public void clearTranslationHistory() {
        getInteractor().clearTranslationHistory();
    }

    @Override
    public void swapSelectedLanguages() {
        getInteractor().swapSelectedLanguages();
    }

    @Override
    public void addToFavorites() {
        getInteractor().addToFavorites();
    }

    @Override
    public void translate(String text,  Map<String, Language> fromToLanguages) {
        getInteractor().translate(text, fromToLanguages);
    }

    @Override
    public void showSelectLanguageActivity(Boolean isFromLanguage) {
        getRouter().showLanguageSelectActivity(isFromLanguage);

    }

    @Override
    public void showFavoritesActivity() {
        getRouter().showFavoritesActivity();
    }


    // ===== Output Interface =====
    @Override
    public void didGetSelectedLanguages(Map<String, Language> fromToLanguages) {
        getView().didGetSelectedLanguages(fromToLanguages);
    }

    @Override
    public void didGetTranslationHistory(List<Translation> translations) {
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
        getView().didGetTranslationHistory(translations);
    }

    @Override
    public void didCleanTranslationHistory() {
        getView().didCleanTranslationHistory();
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
