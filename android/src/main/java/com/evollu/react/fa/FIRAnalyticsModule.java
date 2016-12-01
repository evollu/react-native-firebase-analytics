package com.evollu.react.fa;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.analytics.FirebaseAnalytics;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.Iterator;

public class FIRAnalyticsModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private final static String TAG = FIRAnalyticsModule.class.getCanonicalName();

    public FIRAnalyticsModule(ReactApplicationContext reactContext) {
        super(reactContext);

        getReactApplicationContext().addLifecycleEventListener(this);
    }

    @Override
    public String getName() {
        return "RNFIRAnalytics";
    }

    @ReactMethod
    public void setUserId(String id){
        FirebaseAnalytics.getInstance(getReactApplicationContext()).setUserId(id);
    }

    @ReactMethod
    public void setUserProperty(String name, String property) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).setUserProperty(name, property);
    }

    @ReactMethod
    public void logEvent(String name, ReadableMap parameters) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).logEvent(name, Arguments.toBundle(parameters));
    }

    @ReactMethod
    public void setScreenName(String name) {
        Activity currentActivity = getCurrentActivity();
        if(currentActivity != null){
            FirebaseAnalytics.getInstance(getReactApplicationContext()).setCurrentScreen(currentActivity, name, null);
        } else {
            Log.e(TAG, "Set screen name " + name + "failed because current activity is null");
        }
    }

    @ReactMethod
    public void setEnabled(Boolean enabled) {
        FirebaseAnalytics.getInstance(getReactApplicationContext()).setAnalyticsCollectionEnabled(enabled);
    }

    @Override
    public void onHostResume() {
    }

    @Override
    public void onHostPause() {
    }

    @Override
    public void onHostDestroy() {

    }
}
