package com.mavenlocaldemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.net.HttpPuke;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        mButton.setTextColor(Color.BLACK);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    void test(InputStream is) {
        HttpPuke puke = new HttpPuke();
        puke.request("");
        String result = puke.getStr(is);
    }

    private void findView() {
        mButton = (Button) findViewById(R.id.button);
    }
}
