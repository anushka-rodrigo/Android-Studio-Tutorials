package com.example.practical06;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    Button browserURL;

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

        browserURL = findViewById(R.id.browseBtn);
        webView = findViewById(R.id.web);

        //enable webview settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //open links inside web view
        webView.setWebViewClient(new WebViewClient());

        //button click
        browserURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //load website
                webView.loadUrl("https://lms.foc.sjp.ac.lk/");
            }
        });
    }
}