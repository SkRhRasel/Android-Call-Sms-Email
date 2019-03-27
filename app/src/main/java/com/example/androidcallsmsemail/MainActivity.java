package com.example.androidcallsmsemail;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public Button button1;
    public EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        button1 = findViewById(R.id.button1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = editText1.getText().toString();

                Intent intentCall = new Intent(Intent.ACTION_DIAL);

                intentCall.setData(Uri.parse("tel:" +Uri.encode(number.trim()) ));
                intentCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentCall);


            }
        });
    }

}
