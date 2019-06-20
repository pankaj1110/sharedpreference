package com.pankaj.shared_preferenceapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName,etPass;
    Button btn_Login;
    TextView tv_Signup;
    Context context=this;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        isLogin();
        initListener();
        
        
    }

    private void isLogin() {
        sp=getSharedPreferences("MyDataBase",MODE_PRIVATE);
        int i=sp.getInt("Login",0);
        if(i==1)
        {
            Intent i1=new Intent(context,Home_Activity.class);
            startActivity(i1);
            finish();
        }
    }

    private void initListener() {
        btn_Login.setOnClickListener(this);
        tv_Signup.setOnClickListener(this);
    }

    private void init() {
        etName=findViewById(R.id.etName);
        etPass=findViewById(R.id.etPass);
        btn_Login=findViewById(R.id.btn_Login);
        tv_Signup=findViewById(R.id.tv_Signup);
        tv_Signup.setText(R.string.Register_string);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.btn_Login:
                String user=etName.getText().toString().trim();
                String pass=etPass.getText().toString().trim();



                sp=getSharedPreferences("MyDataBase",MODE_PRIVATE);
                SharedPreferences.Editor editor =sp.edit();

                String user1=sp.getString("User","");
                String pass1=sp.getString("Pass","");

                if (user.equals(user1) && pass.equals(pass1)&&user!=null&&pass!=null) {
                    Intent i = new Intent(context, Home_Activity.class);
                    startActivity(i);
                    editor.putInt("Login",1);
                    editor.commit();
                    Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(context, "Oops there's a problem sigining in", Toast.LENGTH_SHORT).show();
                    
                }
                etName.setText("");
                etPass.setText("");
                break;

            case R.id.tv_Signup:
                Intent i=new Intent(context,Register_Activity.class);
               startActivity(i);
               break;
        }



    }
}
