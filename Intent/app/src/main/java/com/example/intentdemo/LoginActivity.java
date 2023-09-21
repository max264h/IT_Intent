package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    private EditText account,password;
    private Button register,login;
    private Dialog dialog;
    private AccountPasswordData accountPasswordData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        account = findViewById(R.id.account);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register_button);
        login = findViewById(R.id.login_button);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.register_dialog);
        accountPasswordData = new AccountPasswordData();

        register.setOnClickListener(view -> setDialog());
        login.setOnClickListener(view -> checkActPwdData(account.getText().toString(),password.getText().toString()));
    }

    private void checkActPwdData(String act, String pwd) {
        ArrayList<HashMap<String,String>> data = accountPasswordData.getActPwdData();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).get("Account").equals(act) && data.get(i).get("Password").equals(pwd)){
                Intent intent = new Intent();
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
            }
            else{
                password.setText("");
                Log.d("test", "登入失敗");
            }
        }
    }

    private void setDialog() {
        dialog.show();
        EditText register_act = dialog.findViewById(R.id.register_act);
        EditText register_pwd = dialog.findViewById(R.id.register_pwd);
        Button cancel = dialog.findViewById(R.id.cancel);
        Button create = dialog.findViewById(R.id.create);

        cancel.setOnClickListener(view -> {
            register_act.setText("");
            register_pwd.setText("");
            dialog.dismiss();
        });
        create.setOnClickListener(view -> {
            accountPasswordData.setActPwdData(register_act.getText().toString(),register_pwd.getText().toString());
            register_act.setText("");
            register_pwd.setText("");
            dialog.dismiss();
        });
    }
}