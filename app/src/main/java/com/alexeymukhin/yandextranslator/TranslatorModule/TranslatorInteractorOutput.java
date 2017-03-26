package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.Map;

interface TranslatorInteractorOutput {

    void didGetSelectedLanguages(Map<String, Language> fromToLanguages);

    void didTranslate(String text);

    void didCheckLanguage(String translatedText);

    void didGetError();


}
