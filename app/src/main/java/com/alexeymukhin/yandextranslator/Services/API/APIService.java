package com.alexeymukhin.yandextranslator.Services.API;

import com.alexeymukhin.yandextranslator.Entities.LanguageConfigEntity;
import com.alexeymukhin.yandextranslator.Entities.TranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

public interface APIService {

    void getSupportedLanguages(String uiLanguage,
                               Escaping<LanguageConfigEntity> escaping);


    void getTranslation(String text,
                        String direction,
                        Escaping<TranslationEntity> escaping);

}
