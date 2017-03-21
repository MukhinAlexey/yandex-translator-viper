package com.alexeymukhin.yandextranslator.LoadingModule;

import android.app.Activity;
import android.content.Intent;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseRouter;
import com.alexeymukhin.yandextranslator.SelectLanguageModule.SelectLanguageActivity;
import com.alexeymukhin.yandextranslator.TranslatorModule.TranslatorActivity;
import com.alexeymukhin.yandextranslator.TranslatorModule.TranslatorRouter;

public class LoadingRouter
        extends BaseRouter<LoadingActivity>
        implements LoadingRouterInput {

    @Override
    public void showTranslatorActivity() {
        Intent intent = new Intent(this.getActivity(), TranslatorActivity.class);
        this.getActivity().startActivity(intent);
        this.getActivity().finish();
    }
}
