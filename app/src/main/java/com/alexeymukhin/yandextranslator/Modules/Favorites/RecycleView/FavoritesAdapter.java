package com.alexeymukhin.yandextranslator.Modules.Favorites.RecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Modules.Translator.RecycleView.TranslationAdapter;
import com.alexeymukhin.yandextranslator.Objects.Translation;
import com.alexeymukhin.yandextranslator.R;

import java.util.ArrayList;
import java.util.List;

public class FavoritesAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Translation> translations;
    private Escaping<String> escaping;

    public void clear() {
        this.translations.clear();
        notifyDataSetChanged();
    }

    public FavoritesAdapter(ArrayList<Translation> translations, Escaping<String> escaping) {
        this.translations = translations;
        this.escaping = escaping;
    }

    private class TranslationHistoryViewHolder extends RecyclerView.ViewHolder {

        TextView fromTextTextView;
        TextView toTextTextView;

        TextView fromLanguageTextView;
        TextView toLanguageTextView;

        TranslationHistoryViewHolder(View view) {
            super(view);
            fromTextTextView = (TextView) view.findViewById(R.id.fromTextTextView);
            toTextTextView = (TextView) view.findViewById(R.id.toTextTextView);
            fromLanguageTextView = (TextView) view.findViewById(R.id.fromLanguageTextView);
            toLanguageTextView = (TextView) view.findViewById(R.id.toLanguageTextView);
        }
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View translationHistoryView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translation_history_list_row, parent, false);
        return new FavoritesAdapter.TranslationHistoryViewHolder(translationHistoryView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FavoritesAdapter.TranslationHistoryViewHolder translationHistoryViewHolder =
                (FavoritesAdapter.TranslationHistoryViewHolder) holder;
        translationHistoryViewHolder.fromTextTextView
                .setText(translations.get(position).getFromText());
        translationHistoryViewHolder.toTextTextView
                .setText(translations.get(position).getToText());
        translationHistoryViewHolder.fromLanguageTextView
                .setText(translations.get(position).getFromLanguage());
        translationHistoryViewHolder.toLanguageTextView
                .setText(translations.get(position).getToLanguage());
    }

    @Override
    public int getItemCount() {
        return translations.size();
    }

}
