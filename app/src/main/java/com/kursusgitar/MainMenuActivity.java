package com.kursusgitar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void insertData(View view) {
        Intent keInsertActivity = new Intent(MainMenuActivity.this, InsertActivity.class);
        //mengirim data ke activity insert data,
        // flag 0 untuk insert data, flag 1 untuk edit data
        keInsertActivity.putExtra("flag", 0);
        startActivity(keInsertActivity);
    }

    public void editData(View view) {
        Intent keInsertActivity = new Intent(MainMenuActivity.this, InsertActivity.class);
        //mengirim data ke activity insert data,
        // flag 0 untuk insert data, flag 1 untuk edit data
        keInsertActivity.putExtra("flag", 1);
        startActivity(keInsertActivity);
    }

    public void listData(View view) {
        Intent keListActivity = new Intent(MainMenuActivity.this, ListActivity.class);
        startActivity(keListActivity);
    }
}
