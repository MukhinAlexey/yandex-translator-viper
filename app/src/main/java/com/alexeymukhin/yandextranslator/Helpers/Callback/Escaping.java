package com.alexeymukhin.yandextranslator.Helpers.Callback;


public interface Escaping<T> {
    void onSuccess(T response);
    void onFailure(Throwable error);
}
