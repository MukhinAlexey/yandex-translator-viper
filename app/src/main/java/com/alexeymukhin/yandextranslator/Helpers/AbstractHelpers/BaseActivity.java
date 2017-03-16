package com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers;

import android.app.Activity;

public class BaseActivity<Presenter> extends Activity {

    Presenter presenter;

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}

