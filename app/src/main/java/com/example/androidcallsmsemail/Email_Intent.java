package com.example.androidcallsmsemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email_Intent extends AppCompatActivity {
    EditText editTextTo,editTextSubject,editTextMessage;
    Button send;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email__intent);

        editTextTo = findViewById(R.id.editText1);
        editTextSubject = findViewById(R.id.editText2);
        editTextMessage = findViewById(R.id.editText3);

        send = findViewById(R.id.button1);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to=editTextTo.getText().toString();
                String subject=editTextSubject.getText().toString();
                String message=editTextMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, to);
                //email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });
    }
}
