package com.alexeymukhin.yandextranslator.StoryModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alexeymukhin.yandextranslator.R;

public class StoryActivity extends AppCompatActivity implements StoryActivityInput {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
    }
}
