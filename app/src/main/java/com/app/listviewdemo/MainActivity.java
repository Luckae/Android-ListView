package com.app.listviewdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

         int [] listviewImage = new int[]{
                R.drawable.ic_info_outline_black_24dp,
                 R.drawable.ic_mail_black_24dp,
                 R.drawable.ic_share_black_24dp,
                 R.drawable.ic_stars_black_24dp
        };

         String[] listViewShortDescription = new String[]{
           "About the App", "Rate", "Share", "Contact"
         };

         List<HashMap<String, String>> aList = new ArrayList<>();

         for(int i=0; i<4; i++){
             HashMap<String, String> hm = new HashMap<>();
             hm.put("listview description",listViewShortDescription[i]);
             hm.put("listview image", Integer.toString(listviewImage[i]));
             aList.add(hm);
         }

         String[] from = {"listview image", "listview description"};
         int[] to = {R.id.listview_image, R.id.listview_item_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getApplicationContext(),
                aList, R.layout.activity_main, from, to);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {

                switch (i){
                    case 0:
                        Toast.makeText(getApplicationContext(),
                                "About us", Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        Toast.makeText(getApplicationContext(),
                                "Rate", Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        Toast.makeText(getApplicationContext(),
                                "Share", Toast.LENGTH_LONG).show();
                        break;

                    case 3:
                        Toast.makeText(getApplicationContext(),
                                "Contact", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        });
    }
}
