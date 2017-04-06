package com.alexeymukhin.yandextranslator.TranslatorModule;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
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

    Button fromLanguageButton;
    Button toLanguageButton;

    RecyclerView recyclerView;
    TranslationAdapter translationAdapter;

    List<Translation> translations;

    Map<String, Language> fromToLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);

        this.configureVIPER();
        this.configureButtons();
        this.configureRecycleView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getPresenter().getSelectedLanguages();
    }

    void configureButtons() {
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
        swapLanguagesButton.setBackgroundResource(R.drawable.swap_arrows);

        swapLanguagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = fromLanguageButton.getText().toString();
                fromLanguageButton.setText(toLanguageButton.getText());
                toLanguageButton.setText(temp);
                getPresenter().swapSelectedLanguages();
                /*temp = translationTextView.getText().toString();
                translationTextView.setText(editText.getText().toString());
                editText.setText(temp);
                */
            }
        });

        FloatingActionButton floatingButton = (FloatingActionButton) findViewById(R.id.favorites);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().showFavoritesActivity();
            }
        });
    }

    void configureVIPER() {
        TranslatorAssembly.INSTANCE.configure(this);
    }

    void configureRecycleView() {
        recyclerView = (RecyclerView) findViewById(R.id.translations_recycle_view);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        translationAdapter = new TranslationAdapter();
        translationAdapter.setOnTranslateAction(new Escaping<String>() {
            @Override
            public void onSuccess(String response) {
                getPresenter().translate(
                        response,
                        fromToLanguages
                );
            }

            @Override
            public void onFailure(Throwable error) {

            }
        });
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                return false;
            }
        });
        recyclerView.setAdapter(translationAdapter);
        getPresenter().getTranslationHistory();
    }

    @Override
    public void didGetSelectedLanguages(Map<String, Language> fromToLanguages) {
        this.fromToLanguages = fromToLanguages;
        this.fromLanguageButton.setText(fromToLanguages.get("fromLanguage").getFullName());
        this.toLanguageButton.setText(fromToLanguages.get("toLanguage").getFullName());
    }

    @Override
    public void didTranslate(String text) {
        translationAdapter.setTranslatedText(text);
        getPresenter().getTranslationHistory();
    }

    @Override
    public void didGetTranslationHistory(List<Translation> translations) {
        this.translations = translations;
        this.translationAdapter.setTranslations(translations);
    }

}
