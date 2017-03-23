package com.alexeymukhin.yandextranslator.LoadingModule;

import com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers.BaseAssembly;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.API.APIServiceImpl;
import com.alexeymukhin.yandextranslator.Services.Datastore.Database;
import com.alexeymukhin.yandextranslator.Services.Datastore.RealmDatabase;


class LoadingAssembly extends BaseAssembly<LoadingActivity> {

    static final LoadingAssembly INSTANCE = new LoadingAssembly();

    @Override
    public void configure(LoadingActivity loadingActivity) {
        LoadingPresenter loadingPresenter = new LoadingPresenter();
        LoadingInteractor loadingInteractor = new LoadingInteractor();
        LoadingRouter loadingRouter = new LoadingRouter();
        APIService server = new APIServiceImpl();
        Database realmDatabase = new RealmDatabase();

        loadingInteractor.setPresenter(loadingPresenter);
        loadingInteractor.setServer(server);
        loadingInteractor.setDatabase(realmDatabase);
        loadingPresenter.setInteractor(loadingInteractor);
        loadingRouter.setActivity(loadingActivity);
        loadingPresenter.setRouter(loadingRouter);
        loadingPresenter.setView(loadingActivity);
        loadingActivity.setPresenter(loadingPresenter);
    }
}
