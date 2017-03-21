package com.alexeymukhin.yandextranslator.LoadingModule;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseAssembly;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.API.APIServiceImpl;


class LoadingAssembly extends BaseAssembly<LoadingActivity> {

    static final LoadingAssembly INSTANCE = new LoadingAssembly();

    @Override
    public void configure(LoadingActivity loadingActivity) {
        LoadingPresenter loadingPresenter = new LoadingPresenter();
        LoadingInteractor loadingInteractor = new LoadingInteractor();
        LoadingRouter loadingRouter = new LoadingRouter();
        APIService server = new APIServiceImpl();

        loadingInteractor.setPresenter(loadingPresenter);
        loadingInteractor.setServer(server);
        loadingPresenter.setInteractor(loadingInteractor);
        loadingRouter.setActivity(loadingActivity);
        loadingPresenter.setRouter(loadingRouter);
        loadingPresenter.setView(loadingActivity);
        loadingActivity.setPresenter(loadingPresenter);
    }
}
