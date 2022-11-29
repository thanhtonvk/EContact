package com.utehy.econtact.Service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

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
    public static String className;
    public FirebaseDatabase database;
    public DatabaseReference reference;
    public static final String NOTI = "thongbao";
    List<Notifications> notificationsList;

    @Override
    public void onCreate() {
        super.onCreate();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("notifications");
        notificationsList = new ArrayList<>();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
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
                        Notifications noti = notificationsList.get(notificationsList.size() - 1);
                        if (noti.class_id.toLowerCase().contains(className.toLowerCase())) {
                            Notification notification = new NotificationCompat.Builder(getApplicationContext(), NOTI)
                                    .setContentTitle(noti.notification_title)
                                    .setContentText(noti.getNotification_content())
                                    .setSmallIcon(R.drawable.anh_notification).build();
                            startForeground(1, notification);
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

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
