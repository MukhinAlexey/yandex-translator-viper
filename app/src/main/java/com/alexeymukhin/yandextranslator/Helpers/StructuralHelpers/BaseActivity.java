package com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers;

import android.app.Activity;
import android.os.Bundle;

import lombok.Getter;
import lombok.Setter;

public class BaseActivity<Presenter> extends Activity {

    @Getter
    @Setter
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}

