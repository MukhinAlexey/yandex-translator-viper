package com.alexeymukhin.yandextranslator.FavoritesModule;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.alexeymukhin.yandextranslator.FavoritesModule.RecycleView.SelectLanguageAdapter;
import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.R;

import java.util.ArrayList;

public class FavoritesActivity
        extends BaseActivity<FavoritesPresenter>
        implements FavoritesActivityInput {

    private ArrayList<Language> languages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        this.configureVIPER();
    }

    void configureVIPER() {
        FavoritesAssembly.INSTANCE.configure(this);
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
