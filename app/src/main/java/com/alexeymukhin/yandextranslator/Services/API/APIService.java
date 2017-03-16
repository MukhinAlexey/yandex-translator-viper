package com.alexeymukhin.yandextranslator.Services.API;

import com.alexeymukhin.yandextranslator.Entities.RecognizedLanguage;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;

public interface APIService {

    void getSupportedLanguages();

    void checkLanguage(String text, List<String> possibleLanguages, Escaping<RecognizedLanguage> escaping);

    void getTranslation(String textToTranslate);

}
