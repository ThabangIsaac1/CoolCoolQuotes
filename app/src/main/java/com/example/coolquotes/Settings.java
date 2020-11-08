package com.example.coolquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//Fetch data from preference
        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);
        String display = preferences.getString("email", "");

        //TextView displayInfo = (TextView) findViewById(R.id.textView);
       // displayInfo.setText(display);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_nav,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.mainsettings:
                Intent intent = new Intent(this, mainSettings.class);
                startActivity(intent);
                return true;
            case R.id.help:
                Toast.makeText(this,"Help Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contact:
                Toast.makeText(this,"Contact Us Selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return  super.onOptionsItemSelected(item);





        }
    }
}