package com.example.sentinel;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.ActivityTransitionEvent;
import com.google.android.gms.location.ActivityTransitionResult;

import static android.content.ContentValues.TAG;


public class TransitionIntentService extends IntentService {

    public TransitionIntentService() {
        super("TransitionIntentService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "onHandleIntent: GO");
        if (intent != null) {
            if (ActivityTransitionResult.hasResult(intent)) {
                ActivityTransitionResult result = ActivityTransitionResult.extractResult(intent);
                for (ActivityTransitionEvent event : result.getTransitionEvents()) {

                    Toast.makeText(this, event.getTransitionType() + "-" + event.getActivityType(), Toast.LENGTH_LONG).show();
                    //7 for walking and 8 for running
                    Log.i(TAG, "Activity Type " + event.getActivityType());


                    // 0 for enter, 1 for exit
                    Log.i(TAG, "Transition Type " + event.getTransitionType());
                }
            } else {
                Log.d(TAG, "onHandleIntent: Banana");
            }
        }
    }
}
