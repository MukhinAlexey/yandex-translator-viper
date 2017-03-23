package com.alexeymukhin.yandextranslator.SelectLanguageModule.RecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.R;

import java.util.ArrayList;

public class SelectLanguageAdapter extends RecyclerView.Adapter<SelectLanguageAdapter.ViewHolder> {

    private ArrayList<Language> languages;

    public SelectLanguageAdapter(ArrayList<Language> languages) {
        this.languages = languages;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView languageTextView;
        public ViewHolder(View view) {
            super(view);
            languageTextView = (TextView) view.findViewById(R.id.language_text_view);
        }
    }

    @Override
    public SelectLanguageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_language_list_row, parent, false);

        return new ViewHolder(v);
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
