package com.alexeymukhin.yandextranslator.TranslatorModule.RecycleView;

import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Translation;
import com.alexeymukhin.yandextranslator.R;

import java.util.ArrayList;
import java.util.List;

public class TranslationAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int OFFSET = 4;

    private List<Translation> translations = new ArrayList<Translation>();
    private String translatedText;

    private Escaping translationEscaping;

    public TranslationAdapter() {

    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
        notifyItemRangeChanged(OFFSET - 1, translations.size() + OFFSET);
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
        notifyItemChanged(2);
    }

    public void setOnTranslateAction(Escaping<String> translationEscaping) {
        this.translationEscaping = translationEscaping;
    }

    private class TranslatorViewHolder extends RecyclerView.ViewHolder {

        EditText editText;

        TranslatorViewHolder(View view) {
            super(view);
            editText = (EditText) view.findViewById(R.id.editText);
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        translationEscaping.onSuccess(editText.getText().toString());
                    }
                    return false;
                }
            });
        }

        String getText() {
            return editText.getText().toString();
        }
    }

    private class TranslationHeaderViewHolder extends RecyclerView.ViewHolder {

        TranslationHeaderViewHolder(View view) {
            super(view);
        }
    }

    private class TranslationViewHolder extends RecyclerView.ViewHolder {

        TextView translationTextView;

        TranslationViewHolder(View view) {
            super(view);
            translationTextView = (TextView) view.findViewById(R.id.translationTextView);
        }
    }

    private class TranslationHistoryHeaderViewHolder extends RecyclerView.ViewHolder {

        TranslationHistoryHeaderViewHolder(View view) {
            super(view);
        }
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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View translatorView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translator_list_row, parent, false);

        View translationHeaderView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translation_header_list_row, parent, false);

        View translationView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translation_list_row, parent, false);

        View translationHistoryHeaderView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translation_history_header_list_row, parent, false);

        View translationHistoryView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.translation_history_list_row, parent, false);

        switch (viewType) {
            case 0:
                return new TranslatorViewHolder(translatorView);
            case 1:
                return new TranslationHeaderViewHolder(translationHeaderView);
            case 2:
                return new TranslationViewHolder(translationView);
            case 3:
                return new TranslationHistoryHeaderViewHolder(translationHistoryHeaderView);
            case 4:
                return new TranslationHistoryViewHolder(translationHistoryView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                TranslatorViewHolder translatorViewHolder =
                        (TranslatorViewHolder) holder;
                break;
            case 1:
                TranslationHeaderViewHolder translationHeaderViewHolder =
                        (TranslationHeaderViewHolder) holder;
                break;
            case 2:
                TranslationViewHolder translationViewHolder = (TranslationViewHolder) holder;
                translationViewHolder.translationTextView.setText(this.translatedText);
                break;
            case 3:
                TranslationHistoryHeaderViewHolder translationHistoryHeaderViewHolder =
                        (TranslationHistoryHeaderViewHolder) holder;
                break;
            case 4:
                TranslationHistoryViewHolder translationHistoryViewHolder =
                        (TranslationHistoryViewHolder) holder;
                translationHistoryViewHolder.fromTextTextView
                        .setText(translations.get(position - OFFSET).getFromText());
                translationHistoryViewHolder.toTextTextView
                        .setText(translations.get(position - OFFSET).getToText());
                translationHistoryViewHolder.fromLanguageTextView
                        .setText(translations.get(position - OFFSET).getFromLanguage());
                translationHistoryViewHolder.toLanguageTextView
                        .setText(translations.get(position - OFFSET).getToLanguage());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= OFFSET) {
            return OFFSET;
        }
        return position;
    }

    @Override
    public int getItemCount() {
        return this.translations.size() + OFFSET;
    }

}

