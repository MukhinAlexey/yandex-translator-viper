package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.R;

public class SelectLanguageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
    }
}
