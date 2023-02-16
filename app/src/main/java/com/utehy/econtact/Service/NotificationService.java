package com.utehy.econtact.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.utehy.econtact.Models.Notifications;
import com.utehy.econtact.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationService extends Service {
    private static final String ID_SIGNAL = "THONGBAO";
    private static final int NOTI_ID_MONEY = 36;
    public static String className;
    public FirebaseDatabase database;
    public DatabaseReference reference;
    public static final String NOTI = "thongbao";
    List<Notifications> notificationsList;
    Notification notification;
    @Override
    public void onCreate() {
        super.onCreate();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("notifications");
        notificationsList = new ArrayList<>();
        startMyOwnForeground("EContact", "EContact đang chạy trong nền");
        createNotificationChannel("Thông báo", "Thông báo", ID_SIGNAL);
        try {
            if (className != null) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        notificationsList.clear();
                        Log.e("TAG", "Noti " + snapshot.toString());
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()
                        ) {
                            Notifications notifications = dataSnapshot.getValue(Notifications.class);
                            if (notifications.class_id.equalsIgnoreCase(className)) {
                                notificationsList.add(notifications);
                            }

                        }
                        if (notificationsList.size() > 1) {
                            Notifications noti = notificationsList.get(notificationsList.size() - 1);
                            if (noti.class_id.toLowerCase().contains(className.toLowerCase())) {

                               pushThongBao(noti.notification_title,noti.notification_content);
                            }
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private void createNotificationChannel(String name, String description, String id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(id, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void pushThongBao(String title, String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ID_SIGNAL)
                .setSmallIcon(R.drawable.bell)
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(content))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTI_ID_MONEY, builder.build());
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return super.onStartCommand(intent, flags, startId);
    }
    private void startMyOwnForeground(String content, String title) {
        String NOTIFICATION_CHANNEL_ID = "Notifcations";
        String channelName = "Notification";
        NotificationChannel chan = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            chan = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, NotificationManager.IMPORTANCE_NONE);
            chan.setLightColor(Color.BLUE);
            chan.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            assert manager != null;
            manager.createNotificationChannel(chan);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
            Notification notification = notificationBuilder.setOngoing(true)
                    .setSmallIcon(R.drawable.bell)
                    .setContentTitle(title)
                    .setContentText(content)
                    .setPriority(NotificationManager.IMPORTANCE_MIN)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .build();
            startForeground(2, notification);
        }

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
