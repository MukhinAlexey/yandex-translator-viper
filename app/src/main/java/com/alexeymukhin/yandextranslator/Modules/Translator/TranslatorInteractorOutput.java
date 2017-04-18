package com.alexeymukhin.yandextranslator.Modules.Translator;

import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;

import java.util.List;
import java.util.Map;

interface TranslatorInteractorOutput {

    void didGetSelectedLanguages(Map<String, Language> fromToLanguages);

    void didGetTranslationHistory(List<Translation> translations);

    void didCleanTranslationHistory();

    void didTranslate(String text);

    void didCheckLanguage(String translatedText);

    void didGetError();


}
