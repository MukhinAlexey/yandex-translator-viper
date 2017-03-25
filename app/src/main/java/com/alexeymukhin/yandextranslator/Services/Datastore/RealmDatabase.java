package com.alexeymukhin.yandextranslator.Services.Datastore;


import com.alexeymukhin.yandextranslator.Entities.DirectionEntity;
import com.alexeymukhin.yandextranslator.Entities.LanguageEntity;
import com.alexeymukhin.yandextranslator.Helpers.Callback.Escaping;
import com.alexeymukhin.yandextranslator.Objects.Language;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

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
    public void saveDirections(List<String> directions) {
        for (String directionString : directions) {
            DirectionEntity direction = new DirectionEntity(directionString);
            saveDirection(direction);
        }
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
    public void saveLanguages(Map<String, String> languages) {
        for (Map.Entry<String, String> entry : languages.entrySet()) {
            LanguageEntity language = new LanguageEntity(entry.getKey(), entry.getValue());
            saveLanguage(language);
        }
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

    @Override
    public void getSelectedLanguages(final Escaping<Map<String, String>> escaping) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Map<String, String> fromToLanguages = new HashMap<String, String>();

                String fromLanguageString;
                String toLanguageString;

                LanguageEntity fromLanguage = realm
                        .where(LanguageEntity.class)
                        .equalTo("isFromSelected", true)
                        .findFirst();

                LanguageEntity toLanguage = realm
                        .where(LanguageEntity.class)
                        .equalTo("isToSelected", true)
                        .findFirst();

                if (fromLanguage == null) {
                    fromLanguageString = "Русский";
                } else {
                    fromLanguageString = fromLanguage.getFullName();
                }

                if (toLanguage == null) {
                    toLanguageString = "Английский";
                } else {
                    toLanguageString = toLanguage.getFullName();
                }

                fromToLanguages.put("fromLanguage", fromLanguageString);
                fromToLanguages.put("toLanguage", toLanguageString);
                escaping.onSuccess(fromToLanguages);
            }
        });
    }

    @Override
    public void selectLanguage(final String language,
                               final Boolean isFromLanguage) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (isFromLanguage) {
                    LanguageEntity fromLanguage = realm.where(LanguageEntity.class)
                            .equalTo("isFromSelected", true)
                            .findFirst();

                    if (fromLanguage != null) {
                        fromLanguage.setFromSelected(false);
                    }

                    realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .findFirst()
                            .setFromSelected(true);
                    realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .findFirst()
                            .setToSelected(false);
                    LanguageEntity toLanguage = realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .equalTo("isToSelected", true)
                            .findFirst();

                    if (toLanguage != null) {
                        toLanguage.setToSelected(false);
                    }
                } else {
                    LanguageEntity toLanguage = realm.where(LanguageEntity.class)
                            .equalTo("isToSelected", true)
                            .findFirst();

                    if (toLanguage != null) {
                        toLanguage.setToSelected(false);
                    }

                    realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .findFirst()
                            .setFromSelected(false);
                    realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .findFirst()
                            .setToSelected(true);

                    LanguageEntity fromLanguage = realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .equalTo("isFromSelected", true)
                            .findFirst();

                    if (fromLanguage != null) {
                        fromLanguage.setToSelected(false);
                    }
                }
            }
        });
    }

    @Override
    public void saveToHistory(String fromWord, String toWord) {

    }

}
