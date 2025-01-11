package com.example.thrivedrive.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.thrivedrive.R;
import com.example.thrivedrive.Utils.ConstantData;

public class LoginActivity extends AppCompatActivity {

    EditText etemail, etpassword;
    Button btnlogin;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etemail = findViewById(R.id.editTextTextPerson);
        etpassword = findViewById(R.id.editTextTextPassword);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(v -> {
            sp = getSharedPreferences(ConstantData.SP_NAME,MODE_PRIVATE);
            String email = etemail.getText().toString().trim();
            String pass = etpassword.getText().toString().trim();

            SharedPreferences.Editor ed = sp.edit();
            ed.putString(ConstantData.SP_EMAIL,etemail.getText().toString().trim());
            ed.putBoolean(ConstantData.SP_IS_LOGIN,true);
            ed.commit();

            Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}