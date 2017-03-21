package com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity<Presenter> extends Activity {

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}

