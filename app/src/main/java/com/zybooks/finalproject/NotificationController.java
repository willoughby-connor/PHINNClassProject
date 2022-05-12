package com.zybooks.finalproject;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationController
{
    private static final String CHANNEL_1_ID =  "channel1";
    private static final String CHANNEL_2_ID = "channel2";
    private NotificationManagerCompat notificationManager;

    public NotificationController(Context context)
    {
        notificationManager = NotificationManagerCompat.from(context);
    }

    public void sendBreakNotification(Context context, View v) {
        String title = "A Message from PHINN";
        String message = "It's okay to take breaks. Make sure you're taking care of yourself!";

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManager.notify(1, notification);
    }

    public void sendFriendlyNotification(Context context, View v) {
        String title = "A Message from PHINN";
        String message = "Just wanted to say hello!";

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManager.notify(2, notification);

    }
}
