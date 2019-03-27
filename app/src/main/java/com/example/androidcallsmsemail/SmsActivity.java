package com.example.androidcallsmsemail;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

    }

    public void sendSMS(View view) {

        String number = "01722823099";  // The number on which you want to send SMS

        startActivity(new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms",number,null)));

    }



     /* or
     public void sendSMS(View v)
      {
     Uri uri = Uri.parse("smsto:12346556");
         Intent it = new Intent(Intent.ACTION_SENDTO, uri);
         it.putExtra("sms_body", "Here you can set the SMS text to be sent");
         startActivity(it);
      } */
}
