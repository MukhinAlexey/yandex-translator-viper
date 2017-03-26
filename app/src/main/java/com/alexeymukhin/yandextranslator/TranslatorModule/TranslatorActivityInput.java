package com.alexeymukhin.yandextranslator.TranslatorModule;

import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.Map;

interface TranslatorActivityInput {

    void didGetSelectedLanguages(Map<String, Language> fromToLanguages);

    void didTranslate(String text);

}