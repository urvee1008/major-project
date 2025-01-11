package com.example.thrivedrive.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.thrivedrive.R;
import com.example.thrivedrive.Utils.ConstantData;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences sp;
    TextView Tvemail;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Tvemail = findViewById(R.id.tvEmail);
        btnLogout = findViewById(R.id.btnLogout);

        sp = getSharedPreferences(ConstantData.SP_NAME,MODE_APPEND);
        String email = sp.getString(ConstantData.SP_EMAIL,"");
        Tvemail.setText("Hello " + email);


        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor ed = sp.edit();
            ed.clear();
            ed.apply();

            Intent intent=new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}