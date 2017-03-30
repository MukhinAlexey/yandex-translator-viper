package com.alexeymukhin.yandextranslator.Services.API;

import com.alexeymukhin.yandextranslator.Entities.LanguageConfigEntity;
import com.alexeymukhin.yandextranslator.Entities.ServerTranslationEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YandexTranslatorAPI {

    @GET("translate")
    Call<ServerTranslationEntity> getTranslation(@Query("text") String text,
                                                 @Query("lang") String direction,
                                                 @Query("key") String token);

    @GET("getLangs")
    Call<LanguageConfigEntity> getSupportedLanguages(@Query("ui") String uiLanguage,
                                                     @Query("key") String token);

}

