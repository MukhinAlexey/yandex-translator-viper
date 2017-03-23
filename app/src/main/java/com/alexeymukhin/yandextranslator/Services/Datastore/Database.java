package com.alexeymukhin.yandextranslator.Services.Datastore;

import com.alexeymukhin.yandextranslator.Entities.DirectionEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;

public interface Database {

    void saveDirection(DirectionEntity direction);
    void saveLanguage(LanguageEntity language);
    void getLanguages(Escaping<List<LanguageEntity>> escaping);

}
