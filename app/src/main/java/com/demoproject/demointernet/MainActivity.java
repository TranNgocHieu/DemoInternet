package com.demoproject.demointernet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button search,next,back,stop,reload;
    EditText input;
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stop=(Button)findViewById(R.id.btn_stop);
        next=(Button)findViewById(R.id.btn_next);
        search=(Button) findViewById(R.id.btn_search);
        back=(Button)findViewById(R.id.btn_back);
        reload=(Button)findViewById(R.id.btn_reload);
        web=(WebView)findViewById(R.id.wb_web);
        input=(EditText)findViewById(R.id.edt_search);
        web.setWebViewClient(new WebViewClient());
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=input.getText().toString().trim();
                web.loadUrl("http://"+link);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoBack()){
                    web.goBack();
                }else {
                    Toast.makeText(MainActivity.this,"Can't go back",Toast.LENGTH_SHORT).show();
                }

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoForward()){
                    web.goForward();
                }else {
                    Toast.makeText(MainActivity.this,"Can't go next",Toast.LENGTH_SHORT).show();
                }
            }
        });
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.reload();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.destroy();
            }
        });
         //web.getSettings().setDisplayZoomControls(false);
        web.getSettings().setJavaScriptEnabled(true);
    }

}
