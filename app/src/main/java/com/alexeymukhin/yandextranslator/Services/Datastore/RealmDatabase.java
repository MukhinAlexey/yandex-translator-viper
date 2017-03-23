package com.alexeymukhin.yandextranslator.Services.Datastore;


import com.alexeymukhin.yandextranslator.Entities.DirectionEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.List;

import io.realm.Realm;

public class RealmDatabase
        implements Database {

    Realm realm = Realm.getDefaultInstance();

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
    public void saveLanguage(final LanguageEntity language) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(language);
            }
        });
    }

    @Override
    public void getLanguages(final Escaping<List<LanguageEntity>> escaping) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                escaping.onSuccess(realm.copyFromRealm(realm.where(LanguageEntity.class).findAll()));
            }
        });
    }

}
