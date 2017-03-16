package com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers;

/**
 * This is a helper for writing presenters with using less code
 * @param <View>
 * @param <Router>
 */
public abstract class BasePresenter<View, Router, Interactor> {

    private View view;
    private Router router;
    private Interactor interactor;


    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public Interactor getInteractor() {
        return interactor;
    }

    public void setInteractor(Interactor interactor) {
        this.interactor = interactor;
    }

}
