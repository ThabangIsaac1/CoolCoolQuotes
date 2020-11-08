package com.example.coolquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class mainSettings extends AppCompatActivity {
    private RadioGroup groupColors;
    private RadioButton burgundy;
    private RadioButton cathams;
    private RadioButton coast;
    private RadioButton black;
    ImageButton select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);

        select = (ImageButton) findViewById(R.id.selectColor);
        groupColors = (RadioGroup) findViewById(R.id.chooseColors);
        burgundy = (RadioButton) findViewById(R.id.burgundy);
        cathams = (RadioButton) findViewById(R.id.chathams);
        coast = (RadioButton) findViewById(R.id.coast);
        black = (RadioButton) findViewById(R.id.black);

        View mainSettings =  findViewById(R.id.bgMainSettings);
        SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);
        String maincolour = preferences.getString("colour", "Black");


        switch (maincolour) {
            case "Dark Burgundy":
                mainSettings.setBackgroundColor(Color.parseColor("#720F07"));
                break;
            case "Chathams Blue":
                mainSettings.setBackgroundColor(Color.parseColor("#133C82"));


                break;
            case "West coast":
                mainSettings.setBackgroundColor(Color.parseColor("#49571A"));


                break;
            case "Black":
                mainSettings.setBackgroundColor(Color.parseColor("#000000"));


                break;
            default:
                Toast.makeText(mainSettings.this, "Not working here", Toast.LENGTH_SHORT).show();
                mainSettings.setBackgroundColor(Color.parseColor("#000000"));
                break;
        }


        groupColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if ((null == rb) || (checkedId <= -1)) {
                    return;
                }


                Toast.makeText(mainSettings.this, rb.getText(), Toast.LENGTH_SHORT).show();
                View mainSettings =  findViewById(R.id.bgMainSettings);

                String text = (String) rb.getText().toString();
                final Intent intent;
                System.out.println(text);
                if(rb.getText().equals("Dark Burgundy")){

                    mainSettings.setBackgroundColor(Color.parseColor("#720F07"));

                }

                else if(rb.getText().equals("Chathams Blue")){

                    mainSettings.setBackgroundColor(Color.parseColor("#133C82"));

                }else if(rb.getText().equals("West coast")){

                    mainSettings.setBackgroundColor(Color.parseColor("#49571A"));

                }else if(rb.getText().equals("Black")){

                    mainSettings.setBackgroundColor(Color.parseColor("#000000"));

                }


                else {


                    Toast.makeText(mainSettings.this, "Try Selecting Color Again", Toast.LENGTH_SHORT).show();
                }




            }


        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Collect id fro background color and fetch preference
                View mainSettings =  findViewById(R.id.bgMainSettings);
                String color;
                SharedPreferences preferences = getSharedPreferences("mypref", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();


                RadioButton rb = (RadioButton) groupColors.findViewById(groupColors.getCheckedRadioButtonId());
                String text = (String) rb.getText().toString();
                final Intent intent;
                if(rb.getText().equals("Dark Burgundy")){

                    mainSettings.setBackgroundColor(Color.parseColor("#720F07"));
                    color ="Dark Burgundy";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(mainSettings, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar mSnackbar = Snackbar.make(mainSettings, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    mSnackbar.show();
                                    Intent intent = new Intent(mainSettings.this, Settings.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }

                else  if(rb.getText().equals("Chathams Blue")){

                    mainSettings.setBackgroundColor(Color.parseColor("#133C82"));
                    color ="Chathams Blue";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(mainSettings, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar mSnackbar = Snackbar.make(mainSettings, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    mSnackbar.show();
                                    Intent intent = new Intent(mainSettings.this, Settings.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }else if(rb.getText().equals("West coast")){

                    mainSettings.setBackgroundColor(Color.parseColor("#49571A"));
                    color ="West coast";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(mainSettings, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar mSnackbar = Snackbar.make(mainSettings, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    mSnackbar.show();
                                    Intent intent = new Intent(mainSettings.this, Settings.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }else if(rb.getText().equals("Black")){

                    mainSettings.setBackgroundColor(Color.parseColor("#000000"));
                    color ="Black";
                    editor.putString("colour", color);
                    editor.apply();


                    Snackbar snackbar = Snackbar
                            .make(mainSettings, "Confirm Selected Color ?", Snackbar.LENGTH_LONG)
                            .setAction("SAVE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Snackbar mSnackbar = Snackbar.make(mainSettings, "Color Added Succesfully.", Snackbar.LENGTH_SHORT);
                                    mSnackbar.show();
                                    Intent intent = new Intent(mainSettings.this, Settings.class);
                                    startActivity(intent);
                                }
                            });

                    snackbar.show();
                }


                else {


                    Toast.makeText(mainSettings.this, "Try Selecting Color Again", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }


}