package com.alexeymukhin.yandextranslator.LoadingModule;

import android.os.Bundle;
import android.os.Handler;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseActivity;
import com.alexeymukhin.yandextranslator.R;

import java.util.Locale;

import io.realm.Realm;

public class LoadingActivity
        extends BaseActivity<LoadingPresenter>
        implements LoadingActivityInput {

    private long LOADING_TIME_DELAY = 3000;
    private long activityStartedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        this.configureVIPER();
        this.configureLanguage();
    }

    @Override
    protected void onStart() {
        super.onStart();
        activityStartedTime = System.currentTimeMillis();
    }

    private void configureVIPER(){
        LoadingAssembly.INSTANCE.configure(this);
    }

    private void configureLanguage() {
        this.getPresenter().getSupportedLanguages(Locale.getDefault().getLanguage());
    }

    @Override
    public void didGetSupportedLanguages() {
        long timePassedFromActivityStarted = System.currentTimeMillis() - activityStartedTime;

        long timeToWait = 0;

        if (timePassedFromActivityStarted < LOADING_TIME_DELAY) {
            timeToWait = LOADING_TIME_DELAY - timePassedFromActivityStarted ;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getPresenter().showTranslatorActivity();

            }
        }, timeToWait);

    }
}
