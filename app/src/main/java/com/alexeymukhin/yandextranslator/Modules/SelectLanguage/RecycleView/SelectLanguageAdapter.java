package com.alexeymukhin.yandextranslator.Modules.SelectLanguage.RecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.R;

import java.util.ArrayList;

public class SelectLanguageAdapter
        extends RecyclerView.Adapter<SelectLanguageAdapter.ViewHolder> {

    private ArrayList<Language> languages;
    private Escaping<String> escaping;

    public SelectLanguageAdapter(ArrayList<Language> languages, Escaping<String> escaping) {
        this.languages = languages;
        this.escaping = escaping;
    }

    static class ViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener  {

        TextView languageTextView;
        Escaping<String> click;

        ViewHolder(View view, Escaping<String> click) {
            super(view);
            view.setOnClickListener(this);
            this.click = click;
            languageTextView = (TextView) view.findViewById(R.id.language_text_view);
        }

        @Override
        public void onClick(View v) {
            click.onSuccess(languageTextView.getText().toString());
        }
    }

    @Override
    public SelectLanguageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_language_list_row, parent, false);

        return new ViewHolder(v, this.escaping);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.languageTextView.setText(languages.get(position).getFullName());
    }

    @Override
    public int getItemCount() {
        return languages.size();
    }

}
