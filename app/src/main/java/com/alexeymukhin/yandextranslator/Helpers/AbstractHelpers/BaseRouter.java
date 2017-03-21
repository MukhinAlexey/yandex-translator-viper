package com.alexeymukhin.yandextranslator.Helpers.AbstractHelpers;


public class BaseRouter<Activity> {

    Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

}
