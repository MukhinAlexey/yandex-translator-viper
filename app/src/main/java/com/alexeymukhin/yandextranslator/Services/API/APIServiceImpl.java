package com.alexeymukhin.yandextranslator.Services.API;

import android.text.TextUtils;

import com.alexeymukhin.yandextranslator.Entities.LanguageConfigEntity;
import com.alexeymukhin.yandextranslator.Entities.ServerTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServiceImpl implements APIService {

    private YandexTranslatorAPI yandexTranslatorAPI;
    private String token = "trnsl.1.1.20170321T170357Z.572bc7cdd67de5fd.4f7abab4db7729f980ed966365782f465dcc043b";

    public APIServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        yandexTranslatorAPI = retrofit.create(YandexTranslatorAPI.class);
    }


    @Override
    public void getSupportedLanguages(String uiLanguage,
                                      final Escaping<LanguageConfigEntity> escaping) {
        this.yandexTranslatorAPI.getSupportedLanguages(uiLanguage, token)
                .enqueue(new Callback<LanguageConfigEntity>() {
                    @Override
                    public void onResponse(Call<LanguageConfigEntity> call,
                                           Response<LanguageConfigEntity> response) {
                        escaping.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<LanguageConfigEntity> call, Throwable t) {

                    }
                });
    }

    @Override
    public void getTranslation(String text, String direction,
                               final Escaping<ServerTranslationEntity> escaping) {
        this.yandexTranslatorAPI.getTranslation(text, direction, token)
                .enqueue(new Callback<ServerTranslationEntity>() {
                    @Override
                    public void onResponse(Call<ServerTranslationEntity> call,
                                           Response<ServerTranslationEntity> response) {
                        escaping.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<ServerTranslationEntity> call, Throwable t) {

                    }
                });
    }

    private String transformListToAPIString(List<String> listToTransform) {
        String stringList = TextUtils.join(", ", listToTransform);
        return stringList;
    }

}
