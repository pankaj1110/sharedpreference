package com.pankaj.shared_preferenceapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Activity extends AppCompatActivity {
    Button btn_Logout;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        btn_Logout=findViewById(R.id.btn_Logout);
        initListener();

    }

    private void initListener() {
        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("MyDataBase",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putInt("Login",0);
                editor.commit();

                Intent i = new Intent(context, MainActivity.class);
                startActivity(i);
                finish();

            }
        });
    }
}
