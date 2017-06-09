package com.example.hernandez.avanceproyecto;

/**
 * Created by HERNANDEZ on 07/06/2017.
 */

import android.nfc.Tag;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by HERNANDEZ on 31/05/2017.
 */

public class MiFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = "NOTICIAS";



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensaje recibido de:" + from);

        if (remoteMessage.getNotification() != null){
            Log.d(TAG, "Notificacion: " + remoteMessage.getNotification().getBody());

        }

    }
}
