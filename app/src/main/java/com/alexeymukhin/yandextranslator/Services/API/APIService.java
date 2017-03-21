package com.alexeymukhin.yandextranslator.Services.API;

import com.alexeymukhin.yandextranslator.Entities.SupportedLanguages;
import com.alexeymukhin.yandextranslator.Entities.RecognizedLanguage;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;

public interface APIService {

    void getSupportedLanguages(String uiLanguage,
                               Escaping<SupportedLanguages> escaping);

    void checkLanguage(String text,
                       List<String> possibleLanguages,
                       Escaping<RecognizedLanguage> escaping);

    void getTranslation(String textToTranslate);

}
