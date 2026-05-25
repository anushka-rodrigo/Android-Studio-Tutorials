 package com.example.practical03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

 public class MainActivity extends AppCompatActivity {

    int score;
    TextView ans;
    Button b1,b2;

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

        generateRandomNumber();
    }

    public void leftButtonClick(View view){
        verifyValue(true);
    }
    public void rightButtonClick(View view){
        verifyValue(false);
    }

    public void verifyValue(boolean isLeft){
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);

        //get the values displayed on the buttons
        int n1 = Integer.valueOf(b1.getText().toString());
        int n2 = Integer.valueOf(b2.getText().toString());

        if (!isLeft && n2 > n1 || isLeft && n1 > n2 ){
            score++;
            Toast.makeText(this,"You are correct!",Toast.LENGTH_SHORT).show();
        }
        else{
            score--;
            Toast.makeText(this,"You are wrong!",Toast.LENGTH_SHORT).show();
        }
        ans = findViewById(R.id.point);
        ans.setText(Integer.toString(score));

        generateRandomNumber();
    }

    private void generateRandomNumber(){
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        Random random = new Random();

        int num1 = random.nextInt(100);
        int num2 = random.nextInt(100);

        while (num1 == num2){
            num2 = random.nextInt(100);
        }

        b1.setText(String.valueOf(num1));
        b2.setText(String.valueOf(num2));
    }
}
