package com.example.practical02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView firstTxt, secondTxt, answer, textView;
    EditText edit1, edit2;
    Button add, sub;

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

        firstTxt = findViewById(R.id.txtFirst);
        secondTxt = findViewById(R.id.txtSecond);
        answer = findViewById(R.id.ans);
        textView = findViewById(R.id.txtView);

        edit1 = findViewById(R.id.editTxt1);
        edit2 = findViewById(R.id.editTxt2);

        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSub);

        add.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               SetCalculateValue(MainActivity.Type.ADD);
           }
        });
        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SetCalculateValue(MainActivity.Type.SUB);
            }
        });

    }

    private enum Type
    {
        ADD, SUB
    }

    private void SetCalculateValue (Type type){
        float result = 0.0f;

        if (edit1.getText().toString().equals("")||edit2.getText().toString().equals("")){
            Toast.makeText(this,"Enter numbers", Toast.LENGTH_SHORT).show();
        }
        else{
            float n1 = Float.valueOf(edit1.getText().toString());
            float n2 = Float.valueOf(edit2.getText().toString());

            if (type==Type.ADD){
                result = n1 + n2;
            }
            else if (type==Type.SUB){
                result = n1 - n2;
            }

            textView.setText(String.valueOf(result));
            Toast.makeText(this,"Answer is: " + result,Toast.LENGTH_SHORT).show();
        }
    }
}