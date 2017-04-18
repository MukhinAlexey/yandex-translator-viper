package com.alexeymukhin.yandextranslator.Modules.Loading;

import android.content.Intent;

import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BaseRouter;
import com.alexeymukhin.yandextranslator.Modules.Translator.TranslatorActivity;

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
