package com.alexeymukhin.yandextranslator.Modules.Loading;

import com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers.BaseAssembly;
import com.alexeymukhin.yandextranslator.Services.API.APIService;
import com.alexeymukhin.yandextranslator.Services.API.APIServiceImpl;
import com.alexeymukhin.yandextranslator.Services.Datastore.DirectionsDatabase;
import com.alexeymukhin.yandextranslator.Services.Datastore.DirectionsDatabaseImpl;
import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabase;
import com.alexeymukhin.yandextranslator.Services.Datastore.LanguagesDatabaseImpl;


class LoadingAssembly extends BaseAssembly<LoadingActivity> {

    static final LoadingAssembly INSTANCE = new LoadingAssembly();

    @Override
    public void configure(LoadingActivity loadingActivity) {
        LoadingPresenter loadingPresenter = new LoadingPresenter();
        LoadingInteractor loadingInteractor = new LoadingInteractor();
        LoadingRouter loadingRouter = new LoadingRouter();
        APIService server = new APIServiceImpl();
        DirectionsDatabase directionsDatabase = new DirectionsDatabaseImpl();
        LanguagesDatabase languagesDatabase = new LanguagesDatabaseImpl();

        loadingInteractor.setPresenter(loadingPresenter);
        loadingInteractor.setDirectionsDatabase(directionsDatabase);
        loadingInteractor.setLanguagesDatabase(languagesDatabase);
        loadingInteractor.setServer(server);
        loadingPresenter.setInteractor(loadingInteractor);
        loadingRouter.setActivity(loadingActivity);
        loadingPresenter.setRouter(loadingRouter);
        loadingPresenter.setView(loadingActivity);
        loadingActivity.setPresenter(loadingPresenter);
    }
}
