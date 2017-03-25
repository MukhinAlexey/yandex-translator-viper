package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.R;
import com.alexeymukhin.yandextranslator.SelectLanguageModule.RecycleView.SelectLanguageAdapter;

import java.util.ArrayList;

public class SelectLanguageActivity
        extends BaseActivity<SelectLanguagePresenter>
        implements SelectLanguageActivityInput {

    private Boolean isFromLanguage;

    private ArrayList<Language> languages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);

        this.configureVIPER();
        this.configureButtons();
        this.configureData();
        this.configureRecycleView();
    }

    void configureVIPER() {
        SelectLanguageAssembly.INSTANCE.configure(this);
    }

    void configureData(){
        this.isFromLanguage = getIntent().getBooleanExtra("isFromLanguage", false);
        getPresenter().getLanguages();
    }

    void configureButtons() {
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void configureRecycleView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.select_languages_recycle_view);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter =
                new SelectLanguageAdapter(this.languages, new Escaping<String>() {
            @Override
            public void onSuccess(String response) {
                getPresenter().selectLanguage(response, isFromLanguage);
            }

            @Override
            public void onFailure(Throwable error) {

            }
        });
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void didGet(ArrayList<Language> languages) {
        this.languages = languages;
    }

    @Override
    public void didSelectLanguage() {
        finish();
    }
}
