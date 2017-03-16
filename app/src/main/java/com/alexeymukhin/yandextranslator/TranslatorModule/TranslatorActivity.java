package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.R;

public class TranslatorActivity extends BaseActivity<TranslatorActivityOutput> implements TranslatorActivityInput {

    EditText editText;
    Button fromLanguageButton;
    Button swapLanguagesButton;
    Button toLanguageButton;
    Activity thisActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        this.configureViper();
        this.configureButtons();
        this.configureEditText();
    }

    void configureButtons(){
        this.fromLanguageButton = (Button) findViewById(R.id.fromLanguageButton);
        this.fromLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().showSelectLanguageActivityOver(thisActivity);
            }
        });
        this.toLanguageButton = (Button) findViewById(R.id.toLanguageButton);
        this.toLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().showSelectLanguageActivityOver(thisActivity);
            }
        });
        this.swapLanguagesButton = (Button) findViewById(R.id.swapLanguagesButton);
        this.swapLanguagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = fromLanguageButton.getText().toString();
                fromLanguageButton.setText(toLanguageButton.getText());
                toLanguageButton.setText(temp);
            }
        });
    }



    void configureViper(){
        TranslatorAssembly.INSTANCE.configure(this);
    }

    void configureEditText() {
        this.editText = (EditText) findViewById(R.id.editText);
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    getPresenter().getTranslation(editText.getText().toString());
                }
                return false;
            }
        });
    }




}