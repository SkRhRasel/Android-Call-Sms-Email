package com.example.androidcallsmsemail;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsPredefinedNumber extends AppCompatActivity {

    final int SEND_SMS_PERMISSION_REQUEST_CODE=1;

    EditText number;
    EditText message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_predefined_number);

        number = findViewById(R.id.inputNumber);
        message = findViewById(R.id.inputMessage);
        send = findViewById(R.id.sendBtn);


        if (checkPermission((Manifest.permission.SEND_SMS))){
            send.setEnabled(true);
        }else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_REQUEST_CODE);
        }
    }

    public void send(View view) {
        String phoneNumber = number.getText().toString();
        String messageText = message.getText().toString();

        if (phoneNumber == null || phoneNumber.length()==0
                || messageText == null
                || messageText.length()==0){
            return;
        }
        if (checkPermission(Manifest.permission.SEND_SMS)){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber,null,messageText,null,null);
            Toast.makeText(this, "Message Sent Sucessfully", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this,permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }
}
