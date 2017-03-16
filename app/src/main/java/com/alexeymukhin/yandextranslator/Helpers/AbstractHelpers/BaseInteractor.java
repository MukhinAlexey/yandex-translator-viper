package com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers;


public abstract class BaseInteractor<Presenter> {

    private Presenter presenter;

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
