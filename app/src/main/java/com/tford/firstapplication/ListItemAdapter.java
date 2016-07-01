package com.tford.firstapplication;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tford on 7/1/16.
 */
public class ListItemAdapter extends ArrayAdapter<String> {

    public ListItemAdapter(Context context, int resource, int textViewResourceId, List<String> data) {
        super(context, resource, textViewResourceId, data);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView) listItemView.findViewById(R.id.list_item_text_view);
        textView.setText(getItem(position));
        Button button = (Button) listItemView.findViewById(R.id.list_item_remove_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.printf("Inside the click handler for item number %d, got called", position);
                Log.d("remove", String.format("Inside the click handler for item number %d, got called", position));
                MyActivity myActivity = (MyActivity) getContext();
                Log.d("remove", "About to call removItem on myActivity");
                myActivity.removeItem(position);
            }
        });
        return listItemView;
    }


}
