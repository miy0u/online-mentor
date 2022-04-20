package com.example.realmentor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText password;
    private EditText username;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password = (EditText) findViewById(R.id.editTextPassword);
        username = (EditText) findViewById(R.id.editTextUsername);

        login = (Button) findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passwordText = password.getText().toString();
                String usernameText = username.getText().toString();
                if (usernameText.equals("admin")) {
                    if (passwordText.equals("admin")){
                        Intent intentLogin = new Intent(getApplicationContext(),MenuActivity.class);
                        intentLogin.putExtra("username",usernameText);
                        startActivity(intentLogin); }
                    else {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Неправильный логин или пароль, повторите попытку", Toast.LENGTH_SHORT);
                        toast.show();
                    } }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Неправильный логин или пароль, повторите попытку", Toast.LENGTH_SHORT);
                    toast.show();
                };
            }
        });

    }

}