package com.example.realmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private Button btnExit;
    private TextView usernameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intentLogin = getIntent();

        String username = intentLogin.getStringExtra("username");

        usernameView = findViewById(R.id.TextViewUsername);
        usernameView.setText(username);

        btnExit = (Button) findViewById(R.id.buttonExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentExit = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentExit);
            }
        });
    }
}