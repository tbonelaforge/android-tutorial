package com.tford.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.tford.firstapplication.MESSAGE";

    public final static int APPROVE_MESSAGE_REQUEST = 1;

    private ArrayList<String> previousMessages;

    private static String STATE_PREVIOUS_MESSAGES = "previous_messages";

    private ListView listView;

    private ListItemAdapter listItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            previousMessages = savedInstanceState.getStringArrayList(STATE_PREVIOUS_MESSAGES);
        } else {
            previousMessages = new ArrayList<String>();
        }
        setContentView(R.layout.activity_my);
        listView = (ListView) findViewById(R.id.list);
        listItemAdapter = new ListItemAdapter(
                this,
                R.layout.list_item,
                R.id.list_item_text_view,
                previousMessages
        );
        listView.setAdapter(listItemAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putStringArrayList(STATE_PREVIOUS_MESSAGES, previousMessages);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        if (message.equals("poopyfacepoopoohead")) {
            System.out.println("Finishing activity now!!!");
            finish();
            return;
        }
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, APPROVE_MESSAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == APPROVE_MESSAGE_REQUEST) {
            if (resultCode == RESULT_OK || resultCode == RESULT_CANCELED) {
                previousMessages.add(intent.getStringExtra(EXTRA_MESSAGE));
                listItemAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        listItemAdapter.notifyDataSetChanged();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void removeItem(int position) {
        previousMessages.remove(position);
        listItemAdapter.notifyDataSetChanged();
    }

}
