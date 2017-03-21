package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.R;

public class SelectLanguageActivity extends BaseActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        this.configureButtons();
    }

    void configureButtons() {
        this.backButton = (Button) findViewById(R.id.backButton);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //getPresenter().showSelectLanguageActivityOver(thisActivity);
            }
        });
    }
}
