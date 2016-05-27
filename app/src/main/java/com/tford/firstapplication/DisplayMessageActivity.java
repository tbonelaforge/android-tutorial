package com.tford.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class DisplayMessageActivity extends Activity {

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
        String helloWorldString = getResources().getString(R.string.hello_world);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message + "\n" + helloWorldString);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
        this.message = message;
    }

    @Override
    public void finish() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MyActivity.EXTRA_MESSAGE, message);
        setResult(RESULT_OK, returnIntent);
        setResult(RESULT_CANCELED, returnIntent);
        super.finish();
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
