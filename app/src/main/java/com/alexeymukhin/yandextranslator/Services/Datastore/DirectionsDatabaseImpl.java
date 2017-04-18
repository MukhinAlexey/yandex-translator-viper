package com.alexeymukhin.yandextranslator.Services.Datastore;


import com.alexeymukhin.yandextranslator.Entities.DirectionEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;

public class DirectionsDatabaseImpl
        implements DirectionsDatabase {

    private Realm realm = Realm.getDefaultInstance();

    @Override
    public void saveDirection(final DirectionEntity direction) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(direction);
            }
        });
    }

    @Override
    public void saveDirections(List<String> directions) {
        for (String directionString : directions) {
            DirectionEntity direction = new DirectionEntity(directionString);
            saveDirection(direction);
        }
    }
}
