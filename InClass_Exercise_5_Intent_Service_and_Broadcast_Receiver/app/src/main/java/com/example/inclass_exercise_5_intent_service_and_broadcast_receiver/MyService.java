package com.example.inclass_exercise_5_intent_service_and_broadcast_receiver;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends IntentService {
    public MyService() {
        super(MyService.class.getSimpleName());
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Intent intent1 = new Intent();
        Log.e("MyService: ", "MESSAGE FROM SERVICE");
        intent1.setAction("changeText");
        intent1.putExtra("DATAPASSED", "TEXT CHANGED BY SERVER VIA BROADCAST");
        sendBroadcast(intent1);
    }
}
