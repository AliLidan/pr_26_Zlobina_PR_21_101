package com.example.pr_26_zlobina_pr_21_101;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    Button button, button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button90);
        button1 = findViewById(R.id.button99);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            NotificationChannel channel = new NotificationChannel("note1", "note2", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

            NotificationChannel channel1 = new NotificationChannel("note3", "note2", NotificationManager.IMPORTANCE_LOW);
            NotificationManager manager1 = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"note1");
                builder.setContentText("Say bye");
                builder.setContentTitle("Bye-bye");
                builder.setSmallIcon(R.drawable.hh0);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, builder.build()); // тоже что и show()
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"note3");
                builder.setContentText("ДAAAAAAAAAAAAAAA");
                builder.setContentTitle("All will be alright!");
                builder.setSmallIcon(R.drawable.hh0);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1, builder.build());
                playCustomTune();
            }
        });
    }

    private void playTune() { // вытащили стандартный звук уведомления
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone track = RingtoneManager.getRingtone(getApplicationContext(), notification);
            track.play();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Failed to Play This Ringtone", Toast.LENGTH_SHORT).show();
        }
    }

    private void playCustomTune() { // просто проиграли свое
        try {
            MediaPlayer track = MediaPlayer.create(getApplicationContext(), R.raw.note);
            track.start();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Failed To Play This File!", Toast.LENGTH_SHORT).show();
        }
    }
}



