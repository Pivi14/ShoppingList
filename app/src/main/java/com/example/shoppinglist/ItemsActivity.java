package com.example.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ItemsActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.shoppinglist.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
    }

    public void addItem(View view) {
        String itemName = ((Button) view).getText().toString();
        Intent intent = new Intent();
        intent.putExtra(EXTRA_REPLY, itemName);
        setResult(RESULT_OK, intent);
        finish();
    }
}