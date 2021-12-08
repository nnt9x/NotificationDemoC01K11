package com.bkacad.nnt.notificationdemoc01k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCreate;
    private EditText edtMessage;
    private Notification notification1;
    private NotificationManagerCompat notificationManagerCompat;


    private void initUI(){
        btnCreate = findViewById(R.id.btnCreate);
        edtMessage = findViewById(R.id.edtMessage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        notificationManagerCompat = NotificationManagerCompat.from(this);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy nội dung trong edittext -> tạo notification -> show
                String msg = edtMessage.getText().toString();
                if(msg.isEmpty()){
                    edtMessage.setError("Hãy nhập nội dung");
                    return;
                }
                // Tạo notification phía dưới ....

                notification1 = new NotificationCompat.Builder(MainActivity.this,"channel1")
                        .setSmallIcon(R.drawable.ic_baseline_sentiment_very_satisfied_24)
                        .setContentTitle("Title")
                        .setContentText(msg)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();

                notificationManagerCompat.notify(1,notification1);
            }

        });
    }
}