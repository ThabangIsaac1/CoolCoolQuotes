package com.example.coolquotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView textColor = (TextView) findViewById(R.id.textView);
        TextView textColor2 = (TextView) findViewById(R.id.textView2);



        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);
        String maincolour = preferences.getString("colour", "Black");


        switch (maincolour) {
            case "Dark Burgundy":
                textColor.setBackgroundColor(Color.parseColor("#720F07"));
                textColor2.setBackgroundColor(Color.parseColor("#720F07"));
                break;
            case "Chathams Blue":
                textColor.setBackgroundColor(Color.parseColor("#133C82"));
                textColor2.setBackgroundColor(Color.parseColor("#133C82"));


                break;
            case "West coast":
                textColor.setBackgroundColor(Color.parseColor("#49571A"));
                textColor2.setBackgroundColor(Color.parseColor("#49571A"));





                break;
            default:
                Toast.makeText(Settings.this, "Not working here", Toast.LENGTH_SHORT).show();
                textColor.setBackgroundColor(Color.parseColor("#ffffff"));
                textColor2.setBackgroundColor(Color.parseColor("#ffffff"));
                break;
        }




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
            case R.id.logout:
                 intent = new Intent(this, Login.class);
                startActivity(intent);
                return true;
            default:
                return  super.onOptionsItemSelected(item);





        }
    }
}