package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;
import com.alexeymukhin.yandextranslator.R;
import com.alexeymukhin.yandextranslator.SelectLanguageModule.RecycleView.SelectLanguageAdapter;
import com.alexeymukhin.yandextranslator.TranslatorModule.RecycleView.TranslationAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TranslatorActivity
        extends BaseActivity<TranslatorActivityOutput>
        implements TranslatorActivityInput {

    TextView translationTextView;
    EditText editText;
    Button fromLanguageButton;
    Button toLanguageButton;

    Map<String, Language> fromToLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        this.configureVIPER();
        this.configureButtons();
        this.configureEditText();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getPresenter().getSelectedLanguages();
    }

    void configureButtons(){
        this.fromLanguageButton = (Button) findViewById(R.id.fromLanguageButton);
        this.fromLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().showSelectLanguageActivity(true);
            }
        });
        this.toLanguageButton = (Button) findViewById(R.id.toLanguageButton);
        this.toLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().showSelectLanguageActivity(false);
            }
        });
        Button swapLanguagesButton = (Button) findViewById(R.id.swapLanguagesButton);
        swapLanguagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = fromLanguageButton.getText().toString();
                fromLanguageButton.setText(toLanguageButton.getText());
                toLanguageButton.setText(temp);
                temp = translationTextView.getText().toString();
                translationTextView.setText(editText.getText().toString());
                editText.setText(temp);
                getPresenter().swapSelectedLanguages();
            }
        });
    }

    void configureVIPER(){
        TranslatorAssembly.INSTANCE.configure(this);
    }

    void configureEditText() {
        this.editText = (EditText) findViewById(R.id.editText);
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    getPresenter().translate(
                            editText.getText().toString(),
                            fromToLanguages.get("fromLanguage").getShortName(),
                            fromToLanguages.get("toLanguage").getShortName()
                    );
                }
                return false;
            }
        });
    }

    @Override
    public void didGetSelectedLanguages(Map<String, Language> fromToLanguages) {
        this.fromToLanguages = fromToLanguages;
        this.fromLanguageButton.setText(fromToLanguages.get("fromLanguage").getFullName());
        this.toLanguageButton.setText(fromToLanguages.get("toLanguage").getFullName());
    }

    @Override
    public void didTranslate(String text) {
        this.translationTextView = (TextView) findViewById(R.id.translationTextView);
        this.translationTextView.setText(text);
        getPresenter().getTranslationHistory();
    }

    @Override
    public void didGetTranslationHistory(List<Translation> translations) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.translations_recycle_view);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter =
                new TranslationAdapter(translations, new Escaping<String>() {
                    @Override
                    public void onSuccess(String response) {

                    }

                    @Override
                    public void onFailure(Throwable error) {

                    }
                });
        recyclerView.setAdapter(adapter);
    }

}
