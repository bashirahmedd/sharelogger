package com.ahmed.sharelogger.utils;

import android.annotation.TargetApi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.content.Context;
import android.content.Intent;

import android.os.Build;

//import android.support.v4.content.ContextCompat;
import androidx.core.content.ContextCompat;

//import de.eric_scheibler.clipboardtospeech.R;
import com.ahmed.sharelogger.R;

public class ApplicationInstance  {

    private Context context;
    private static ApplicationInstance applicationInstance;

    public  ApplicationInstance(Context context) {
        this.context = context;
        // set notification channel for android 8
        createNotificationChannel();
        // settings manager instance
        SettingsManager settingsManagerInstance = SettingsManager.getInstance(context);
        // update notification
        if (settingsManagerInstance.getClipboardMonitorServiceEnabled()) {
            updateServiceNotification();
        }
    }

    /**
     * notification
     */
    @TargetApi(Build.VERSION_CODES.O)
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    Constants.ID.NOTIFICATION_CHANNEL_ID,
                    context.getResources().getString(R.string.app_name),
                    NotificationManager.IMPORTANCE_LOW);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationChannel.setShowBadge(true);
            ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE))
                .createNotificationChannel(notificationChannel);
        }
    }

    public void updateServiceNotification() {
        Intent updateServiceNotificationIntent = new Intent(context, ClipboardMonitorService.class);
        updateServiceNotificationIntent.setAction(Constants.CustomAction.UPDATE_SERVICE_NOTIFICATION);
        ContextCompat.startForegroundService(context, updateServiceNotificationIntent);
    }

    public static ApplicationInstance getInstance(Context context ) {
        if (applicationInstance == null) {
            applicationInstance = new ApplicationInstance(context);
        }
        return applicationInstance;
    }
}
