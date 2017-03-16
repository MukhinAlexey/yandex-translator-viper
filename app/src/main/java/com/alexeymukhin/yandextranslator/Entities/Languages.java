package com.alexeymukhin.yandextranslator.Entities;

/**
 * Created by alexey on 15.03.17.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Languages {

    @SerializedName("dirs")
    @Expose
    private List<String> dirs = null;
    @SerializedName("langs")
    @Expose
    private Language language;

    public List<String> getDirs() {
        return dirs;
    }

    public void setDirs(List<String> dirs) {
        this.dirs = dirs;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language langs) {
        this.language = langs;
    }

}
