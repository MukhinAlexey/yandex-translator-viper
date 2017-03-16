package com.alexeymukhin.yandextranslator.Services.API;

import com.alexeymukhin.yandextranslator.Entities.RecognizedLanguage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YandexTranslatorAPI {

    @GET("detect")
    Call<RecognizedLanguage> checkLanguage(@Query("text") String text,
                                           @Query("hint") String hint,
                                           @Query("key") String token);

}

