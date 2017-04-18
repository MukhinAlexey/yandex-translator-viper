package com.alexeymukhin.yandextranslator.Services.Datastore;

import com.alexeymukhin.yandextranslator.Entities.DirectionEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;
import java.util.Map;

public interface DirectionsDatabase {

    void saveDirection(DirectionEntity direction);
    void saveDirections(List<String> directions);

}
