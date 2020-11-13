package com.example.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private final List<Integer> ids = new ArrayList<>(Arrays.asList(R.id.item1, R.id.item2, R.id.item3, R.id.item4, R.id.item5, R.id.item6, R.id.item7, R.id.item8, R.id.item9, R.id.item10));
    private ArrayList<String> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            items = savedInstanceState.getStringArrayList("items");
            buildList();
        }
    }

    public void addItem(View view) {
        if(items.size() >= 10){
            String message = "The list is full";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, ItemsActivity.class);
            startActivityForResult(intent, TEXT_REQUEST);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("items", items);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String item = data.getStringExtra(ItemsActivity.EXTRA_REPLY);
                TextView element = getEmptyTextView();
                element.setText(item);
                items.add(item);
                resetItems();
                buildList();
            }
        }
    }

    private TextView getEmptyTextView(){
        TextView emptyTextView;
        for(int id: ids){
            emptyTextView = findViewById(id);
            if (emptyTextView.getText().toString().equals("")){
                return emptyTextView;
            }
        }
        return null;
    }

    public void deleteItem(View view) {
        TextView element = (TextView) view;
        items.remove(element.getText().toString());
        element.setText("");
    }

    public void buildList(){
        for(int i = 0; i < items.size(); i++){
            TextView textView = findViewById(ids.get(i));
            textView.setText(items.get(i));
        }
    }

    public void resetItems(){
        for(int id: ids){
            TextView textView = findViewById(id);
            textView.setText("");
        }
    }
}