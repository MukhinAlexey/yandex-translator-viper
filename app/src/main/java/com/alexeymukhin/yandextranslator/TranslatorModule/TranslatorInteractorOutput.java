package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;
import com.alexeymukhin.yandextranslator.Objects.Translation;

import java.util.List;
import java.util.Map;

interface TranslatorInteractorOutput {

    void didGetSelectedLanguages(Map<String, Language> fromToLanguages);

    void didGetTranslationHistory(List<Translation> translations);

    void didTranslate(String text);

    void didCheckLanguage(String translatedText);

    void didGetError();


}
