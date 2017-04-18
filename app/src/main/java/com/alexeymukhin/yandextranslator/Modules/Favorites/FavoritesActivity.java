package com.alexeymukhin.yandextranslator.Modules.Favorites;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Modules.Favorites.RecycleView.FavoritesAdapter;
import com.alexeymukhin.yandextranslator.Objects.Translation;
import com.alexeymukhin.yandextranslator.R;

import java.util.ArrayList;

public class FavoritesActivity
        extends BaseActivity<FavoritesPresenter>
        implements FavoritesActivityInput {

    FavoritesAdapter favoritesAdapter;

    private ArrayList<Translation> translations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        this.configureVIPER();
        this.configureButtons();
        this.configureRecycleView();
    }

    void configureVIPER() {
        FavoritesAssembly.INSTANCE.configure(this);
    }

    void configureButtons() {
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button clearButton = (Button) findViewById(R.id.clearFavoritesButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().clearFavorites();
            }
        });
    }

    void configureRecycleView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.favorites_recycle_view);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        this.favoritesAdapter =
                new FavoritesAdapter(this.translations, new Escaping<String>() {
                    @Override
                    public void onSuccess(String response) {

                    }

                    @Override
                    public void onFailure(Throwable error) {

                    }
                });
        recyclerView.setAdapter(this.favoritesAdapter);
        getPresenter().getFavorites();
    }

    @Override
    public void didGet(ArrayList<Translation> translations) {
        this.translations = translations;
        favoritesAdapter.setTranslations(translations);
    }

    @Override
    public void didClearFavorites() {
        this.translations.clear();
        favoritesAdapter.clear();
    }
}
