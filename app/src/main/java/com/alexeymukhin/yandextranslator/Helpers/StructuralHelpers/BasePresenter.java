package com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers;

import lombok.Getter;
import lombok.Setter;

/**
 * This is a helper for writing presenters with using less code
 * @param <View>
 * @param <Router>
 */
public abstract class BasePresenter<View, Router, Interactor> {

    @Getter
    @Setter
    private View view;

    @Getter
    @Setter
    private Router router;

    @Getter
    @Setter
    private Interactor interactor;

}
