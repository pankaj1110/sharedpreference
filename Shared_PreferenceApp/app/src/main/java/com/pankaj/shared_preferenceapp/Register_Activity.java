package com.pankaj.shared_preferenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPass;
    Button btn_SignUp;
    TextView tv_back;
    Context context=this;
    SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_);
        init();
        initListener();
    }

    private void initListener() {
        btn_SignUp.setOnClickListener(this);
        tv_back.setOnClickListener(this);

    }

    private void init() {
        etName=findViewById(R.id.etName);
        etPass=findViewById(R.id.etPass);
        btn_SignUp=findViewById(R.id.btn_SignUp);
        tv_back=findViewById(R.id.tv_back);
        tv_back.setText(R.string.Back_string);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_SignUp:
            String user=etName.getText().toString().trim();
            String pass=etPass.getText().toString().trim();

                int user_val=user.length();
                int pass_val=pass.length();

                if(pass_val<6)
                {
                    Toast.makeText(context, "password greater than 6 char", Toast.LENGTH_SHORT).show();
                }
                else {

                    sp = getSharedPreferences("MyDataBase", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();


                    editor.putString("User", user);
                    editor.putString("Pass", pass);
                    editor.commit();

                    etName.setText("");
                    etPass.setText("");
                }
            break;

            case R.id.tv_back:
                finish();
                break;

        }

    }
}
