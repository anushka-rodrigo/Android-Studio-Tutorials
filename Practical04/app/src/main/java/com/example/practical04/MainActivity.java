package com.example.practical04;

import static java.util.Collections.list;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        image = findViewById(R.id.img);

        listView = findViewById(R.id.list1);

        //get array from strings.xml
        final String[] list = getResources().getStringArray(R.array.list_name);

        //set adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                list
        );

        listView.setAdapter(adapter);

        //click event for click list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItems = list[position];
                Toast.makeText(MainActivity.this,"You clicked: " + selectedItems,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void radioButtonClick(View view){
        int id = view.getId();

        if (id == R.id.opt1){
            image.setImageResource(R.drawable.pic1);
        }
        else if (id == R.id.opt2){
            image.setImageResource(R.drawable.pic2);
        }
        else if (id == R.id.opt3){
            image.setImageResource(R.drawable.pic3);
        }
        else if (id == R.id.opt4){
            image.setImageResource(R.drawable.pic4);
        }
    }


}