package com.alexeymukhin.yandextranslator.TranslatorModule.RecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;
import com.alexeymukhin.yandextranslator.R;
import com.alexeymukhin.yandextranslator.SelectLanguageModule.RecycleView.SelectLanguageAdapter;

import java.util.ArrayList;
import java.util.List;

public class TranslationAdapter
        extends RecyclerView.Adapter<TranslationAdapter.ViewHolder> {

    private List<Translation> translations;
    private Escaping<String> escaping;

    public TranslationAdapter(List<Translation> languages, Escaping<String> escaping) {
        this.translations = languages;
        this.escaping = escaping;
    }

    @Override
    public TranslationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translation_list_row, parent, false);

        return new TranslationAdapter.ViewHolder(v, this.escaping);
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView translationTextView;
        Escaping<String> click;

        ViewHolder(View view, Escaping<String> click) {
            super(view);
            view.setOnClickListener(this);
            this.click = click;
            translationTextView = (TextView) view.findViewById(R.id.translationHistoryTextView);
        }

        @Override
        public void onClick(View v) {
            click.onSuccess(translationTextView.getText().toString());
        }
    }

    @Override
    public void onBindViewHolder(TranslationAdapter.ViewHolder holder, int position) {
        holder.translationTextView.setText(translations.get(position).getFromText());

    }

    @Override
    public int getItemCount() {
        return this.translations.size();
    }

}

