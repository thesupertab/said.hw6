package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  EditText etLogin, etPassword;
    private Button btnNext;
    private TextView tvWelcome;
    private TextView tvSecond;
    private TextView tvFirst;
    private TextView tvVhod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFirst = findViewById(R.id.tv_first);
        tvSecond = findViewById(R.id.tv_second);
        tvVhod = findViewById(R.id.vhod);
        etLogin = findViewById(R.id.et_pochta);
        etPassword = findViewById(R.id.et_parol);
        btnNext = findViewById(R.id.voiti);
        tvWelcome = findViewById(R.id.welcome);



        etLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (etLogin.getText().toString().isEmpty()){
                    btnNext.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                }else {
                    btnNext.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
        });
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etLogin.getText().toString().isEmpty()){
                    btnNext.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                }else {
                    btnNext.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
        });
        btnNext.setOnClickListener(view -> {
            if (etLogin.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                Toast.makeText(this, "Вы успешно зарегестрировались", Toast.LENGTH_SHORT).show();
                etLogin.setVisibility(View.GONE);
                tvVhod.setVisibility(View.GONE);
                tvSecond.setVisibility(View.GONE);
                tvFirst.setVisibility(View.GONE);
                etPassword.setVisibility(View.GONE);
                btnNext.setVisibility(View.GONE);
            }else {
                Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }
}