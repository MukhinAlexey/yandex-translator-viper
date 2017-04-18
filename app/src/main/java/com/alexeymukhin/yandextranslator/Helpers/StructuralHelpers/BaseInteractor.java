package com.alexeymukhin.yandextranslator.Helpers.StructuralHelpers;


import lombok.Getter;
import lombok.Setter;

public abstract class BaseInteractor<Presenter> {

    @Getter
    @Setter
    private Presenter presenter;

}
