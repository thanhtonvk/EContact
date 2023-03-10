package com.utehy.econtact.Service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
import com.utehy.econtact.Activity.HocPhiActivity;
import com.utehy.econtact.Activity.ManHinhChinhActivity;
import com.utehy.econtact.Activity.ThongBaoActivity;
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
//        String URL =  "https://econtact-notification-47333-default-rtdb.asia-southeast1.firebasedatabase.app";
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("notifications");
        notificationsList = new ArrayList<>();
        startMyOwnForeground("EContact", "EContact đang chạy trong nền");
        createNotificationChannel("Thông báo", "Thông báo", ID_SIGNAL);
        try {
            Log.e("Notify", "onCreate: " + "try");
            if (className != null) {

                Log.e("Notify", "onCreate: " + "ok");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        notificationsList.clear();
                        Log.e("Notify", "Noti " + snapshot.toString());
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()
                        ) {
                            Notifications notifications = dataSnapshot.getValue(Notifications.class);
                            if (notifications.getClass_id().equalsIgnoreCase(className)) {
                                notificationsList.add(notifications);
                            }

                        }
                        if (notificationsList.size() > 1) {
                            Notifications noti = notificationsList.get(notificationsList.size() - 1);
                            if (noti.getClass_id().toLowerCase().contains(className.toLowerCase())) {

                                pushThongBao(noti.getNotification_title(), noti.getNotification_content(), noti.getNotification_type());
                            }
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("Notify", "onCancelled: " + error.toString());
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

    private void pushThongBao(String title, String content, int type) {
        Intent intent = null;
        //check type trong này
        if (type == 0) {
            intent = new Intent(this, HocPhiActivity.class);
        } else {
            intent = new Intent(this, ManHinhChinhActivity.class);
        }

//        intent = new Intent(this, HocPhiActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, NOTI_ID_MONEY, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ID_SIGNAL)
                .setSmallIcon(R.drawable.bell)
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(content))
                .setContentIntent(pIntent)
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
