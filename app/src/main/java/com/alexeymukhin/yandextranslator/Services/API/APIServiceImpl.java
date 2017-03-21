package com.alexeymukhin.yandextranslator.Services.API;

import android.text.TextUtils;

import com.alexeymukhin.yandextranslator.Entities.RecognizedLanguage;
import com.alexeymukhin.yandextranslator.Entities.SupportedLanguages;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServiceImpl implements APIService {

    private YandexTranslatorAPI yandexTranslatorAPI;
    private Retrofit retrofit;
    private String token = "trnsl.1.1.20170321T170357Z.572bc7cdd67de5fd.4f7abab4db7729f980ed966365782f465dcc043b";

    public APIServiceImpl() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        yandexTranslatorAPI = retrofit.create(YandexTranslatorAPI.class);
    }


    @Override
    public void getSupportedLanguages(String uiLanguage, final Escaping<SupportedLanguages> escaping) {
        this.yandexTranslatorAPI.getSupportedLanguages(uiLanguage, token)
                .enqueue(new Callback<SupportedLanguages>() {
                    @Override
                    public void onResponse(Call<SupportedLanguages> call, Response<SupportedLanguages> response) {
                        escaping.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<SupportedLanguages> call, Throwable t) {

                    }
                });
    }

    @Override
    public void checkLanguage(String text, List<String> possibleLanguages, final Escaping<RecognizedLanguage> escaping) {
        this.yandexTranslatorAPI.checkLanguage(text, this.transformListToAPIString(possibleLanguages), "")
                .enqueue(new Callback<RecognizedLanguage>() {
                    @Override
                    public void onResponse(Call<RecognizedLanguage> call, Response<RecognizedLanguage> response) {
                        escaping.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<RecognizedLanguage> call, Throwable t) {

                    }
                });
    }

    @Override
    public void getTranslation(String textToTranslate) {

    }

    private String transformListToAPIString(List<String> listToTransform) {
        String stringList = TextUtils.join(", ", listToTransform);
        return stringList;
    }

}
