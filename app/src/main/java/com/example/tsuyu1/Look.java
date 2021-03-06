package com.example.tsuyu1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Look extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);

        ListView lvMenu = findViewById(R.id.look_list);
        List<Map<String, String>> menuList = new ArrayList<>();

        Map<String,String> menu = new HashMap<>();
        menu.put("date","12月12日");
        menu.put("item","給料");
        menu.put("memo","マック");
        menu.put("amount","5000");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("date","12月12日");
        menu.put("item","服");
        menu.put("memo","UNIQLO");
        menu.put("amount","-2000");
        menuList.add(menu);


        String[] from = {"item","memo","amount"};
        int[] to = {R.id.display_item, R.id.display_memo,R.id.display_amount};
        SimpleAdapter adapter = new SimpleAdapter(Look.this,menuList,R.layout.row,from,to);
        lvMenu.setAdapter(adapter);

        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, String> item = (Map<String, String>)parent.getItemAtPosition(position);

            String fixDate = item.get("date");
            String fixItem = item.get("item");
            String fixMemo = item.get("memo");
            String fixAmount = item.get("amount");


            Intent intent = new Intent(Look.this, Fix.class);

            intent.putExtra("fixDate",fixDate);
            intent.putExtra("fixItem",fixItem);
            intent.putExtra("fixMemo",fixMemo);
            intent.putExtra("fixAmount",fixAmount);

            startActivity(intent);
        }
    }
}