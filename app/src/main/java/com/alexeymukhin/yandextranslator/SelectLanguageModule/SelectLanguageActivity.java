package com.alexeymukhin.yandextranslator.SelectLanguageModule;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.R;
import com.alexeymukhin.yandextranslator.SelectLanguageModule.RecycleView.SelectLanguageAdapter;

import java.util.ArrayList;

public class SelectLanguageActivity extends BaseActivity<SelectLanguagePresenter> implements SelectLanguageActivityInput {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button backButton;

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
        getPresenter().getLanguages();
    }

    void configureButtons() {
        this.backButton = (Button) findViewById(R.id.backButton);
        this.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    void configureRecycleView() {
        recyclerView = (RecyclerView) findViewById(R.id.select_languages_recycle_view);
        recyclerView.hasFixedSize();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SelectLanguageAdapter(languages);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void didGet(ArrayList<Language> languages) {
        this.languages = languages;
    }
}
