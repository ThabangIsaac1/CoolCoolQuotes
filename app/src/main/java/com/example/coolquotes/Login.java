package com.example.coolquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private ImageButton btnLogin;
    private ImageButton btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Fetch login componets by their IDs
        inputEmail = findViewById(R.id.logemail);
        inputPassword = findViewById(R.id.logpass);
        btnLogin = findViewById(R.id.loginbtn);
        btnregister = findViewById(R.id.regbtn2);


        //Get shared preference for storage
        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);

        //Values to store on the shared preference
        String email = "emailKey";
        String password = "passwordKey";


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Collect email and password from  preference storage
                String authEmail = preferences.getString(email, "");
                String authPassword = preferences.getString(password, "");

                //Convert Editable text fields for email and password to Strings
                String text1 = inputEmail.getText().toString();
                String text2 = inputPassword.getText().toString();

                //Ensure email and passwords are filled and not empty
                if (TextUtils.isEmpty(text1)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(text2)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (text2.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Authentication to check if user exists
                if (authEmail.equals(text1) && authPassword.equals(text2)) {

                    //Create key value pairs to send preference data to the settings screen
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email", text1);
                    editor.putString("password", text2);
                    editor.apply();

                    Toast.makeText(getApplicationContext(), "Correct Credentials", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Settings.class);
                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();


                }


            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Store user email and password to preference
                String e = inputEmail.getText().toString();
                String p = inputPassword.getText().toString();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(email, e);
                editor.putString(password, p);
                editor.apply();

                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();

                inputEmail.setText("");
                inputPassword.setText("");

            }
        });

    }
}