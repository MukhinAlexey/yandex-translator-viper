package com.alexeymukhin.yandextranslator.Modules.Translator;

import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;

import java.util.List;
import java.util.Map;

interface TranslatorActivityInput {

    void didGetSelectedLanguages(Map<String, Language> fromToLanguages);

    void didTranslate(String text);

    void didGetTranslationHistory(List<Translation> translations);

    void didCleanTranslationHistory();

}