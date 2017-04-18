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

public class LanguagesDatabaseImpl
        implements LanguagesDatabase {

    private Realm realm = Realm.getDefaultInstance();

    @Override
    public void saveLanguage(final LanguageEntity language) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm.where(LanguageEntity.class)
                        .equalTo("shortName", language.getShortName())
                        .findFirst() == null) {
                    realm.copyToRealmOrUpdate(language);
                }
            }
        });
    }

    @Override
    public void saveLanguages(Map<String, String> languages) {
        for (Map.Entry<String, String> entry : languages.entrySet()) {
            saveLanguage(new LanguageEntity(entry.getKey(), entry.getValue()));
        }
    }

    @Override
    public void getLanguages(final Escaping<List<LanguageEntity>> escaping) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                escaping.onSuccess(realm.copyFromRealm(realm
                        .where(LanguageEntity.class)
                        .findAll()));
            }
        });
    }

    @Override
    public void getSelectedLanguages(final Escaping<Map<String, LanguageEntity>> escaping) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Map<String, LanguageEntity> fromToLanguages = new HashMap<String, LanguageEntity>();

                LanguageEntity fromLanguage = realm
                        .where(LanguageEntity.class)
                        .equalTo("isFromSelected", true)
                        .findFirst();

                LanguageEntity toLanguage = realm
                        .where(LanguageEntity.class)
                        .equalTo("isToSelected", true)
                        .findFirst();

                if (fromLanguage == null) {
                    fromLanguage = realm
                            .where(LanguageEntity.class).findFirst();
                }

                if (toLanguage == null) {
                    toLanguage = realm
                            .where(LanguageEntity.class).findFirst();
                }

                fromToLanguages.put("fromLanguage", fromLanguage);
                fromToLanguages.put("toLanguage", toLanguage);
                escaping.onSuccess(fromToLanguages);
            }
        });
    }

    @Override
    public void swapSelectedLanguages(final Map<String, LanguageEntity> fromToLanguages,
                                      final Escaping<Map<String, LanguageEntity>> escaping) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(LanguageEntity.class)
                        .equalTo("fullName", fromToLanguages.get("fromLanguage").getFullName())
                        .findFirst()
                        .setIsFromSelected(false);

                realm.where(LanguageEntity.class)
                        .equalTo("fullName", fromToLanguages.get("fromLanguage").getFullName())
                        .findFirst()
                        .setIsToSelected(true);

                realm.where(LanguageEntity.class)
                        .equalTo("fullName", fromToLanguages.get("toLanguage").getFullName())
                        .findFirst()
                        .setIsFromSelected(true);

                realm.where(LanguageEntity.class)
                        .equalTo("fullName", fromToLanguages.get("toLanguage").getFullName())
                        .findFirst()
                        .setIsToSelected(false);

            }
        });
        getSelectedLanguages(new Escaping<Map<String, LanguageEntity>>() {
            @Override
            public void onSuccess(Map<String, LanguageEntity> response) {
                escaping.onSuccess(response);
            }

            @Override
            public void onFailure(Throwable error) {

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
                        fromLanguage.setIsFromSelected(false);
                    }

                    realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .findFirst()
                            .setIsFromSelected(true);
                    realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .findFirst()
                            .setIsToSelected(false);
                    LanguageEntity toLanguage = realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .equalTo("isToSelected", true)
                            .findFirst();

                    if (toLanguage != null) {
                        toLanguage.setIsToSelected(false);
                    }
                } else {
                    LanguageEntity toLanguage = realm.where(LanguageEntity.class)
                            .equalTo("isToSelected", true)
                            .findFirst();

                    if (toLanguage != null) {
                        toLanguage.setIsToSelected(false);
                    }

                    realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .findFirst()
                            .setIsFromSelected(false);
                    realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .findFirst()
                            .setIsToSelected(true);

                    LanguageEntity fromLanguage = realm.where(LanguageEntity.class)
                            .equalTo("fullName", language)
                            .equalTo("isFromSelected", true)
                            .findFirst();

                    if (fromLanguage != null) {
                        fromLanguage.setIsToSelected(false);
                    }
                }
            }
        });
    }
}
