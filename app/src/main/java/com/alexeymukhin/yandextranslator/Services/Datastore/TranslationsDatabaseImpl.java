package com.alexeymukhin.yandextranslator.Services.Datastore;


import com.alexeymukhin.yandextranslator.Entities.LocalTranslationEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class TranslationsDatabaseImpl
        implements TranslationsDatabase {

    private Realm realm = Realm.getDefaultInstance();

    @Override
    public void getTranslationHistory(final Escaping<List<LocalTranslationEntity>> escaping) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ArrayList translationList =
                        new ArrayList(realm.where(LocalTranslationEntity.class)
                                .equalTo("isFavorite", false)
                                .findAll());
                escaping.onSuccess(translationList);
            }
        });
    }

    @Override
    public void saveIntoTranslationHistory(final LocalTranslationEntity translation) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(translation);
            }
        });
    }

    @Override
    public void clearTranslationHistory() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(LocalTranslationEntity.class)
                        .equalTo("isFavorite", false)
                        .findAll()
                        .deleteAllFromRealm();
            }
        });
    }

    @Override
    public void getFavorites(final Escaping<List<LocalTranslationEntity>> escaping) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ArrayList translationList =
                        new ArrayList(realm.where(LocalTranslationEntity.class)
                                .equalTo("isFavorite", true)
                                .findAll());
                escaping.onSuccess(translationList);
            }
        });
    }

    @Override
    public void addToFavorites(final LocalTranslationEntity translation) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                translation.setIsFavorite(true);
                realm.copyToRealmOrUpdate(translation);
            }
        });
    }

    @Override
    public void clearFavorites() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(LocalTranslationEntity.class)
                                .equalTo("isFavorite", true)
                                .findAll()
                                .deleteAllFromRealm();
            }
        });
    }

}
