package com.ahmed.sharelogger.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

//import android.support.v4.content.ContextCompat;
import androidx.core.content.ContextCompat;

public class StoreClipboardReceiver extends BroadcastReceiver {


    @Override public void onReceive(Context context, Intent intent) {
        Log.d("BootCompletedReciever", intent.getAction());
        Log.d("NEWCLIPBOARDENTRY", intent.getStringExtra("NEWCLIPBOARDENTRY"));
//        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)
//                && SettingsManager.getInstance(context).getClipboardMonitorServiceEnabled()) {
//            Intent updateServiceNotificationIntent = new Intent(context, ClipboardMonitorService.class);
//            updateServiceNotificationIntent.setAction(Constants.CustomAction.UPDATE_SERVICE_NOTIFICATION);
//            ContextCompat.startForegroundService(context, updateServiceNotificationIntent);
//        }
    }

}
