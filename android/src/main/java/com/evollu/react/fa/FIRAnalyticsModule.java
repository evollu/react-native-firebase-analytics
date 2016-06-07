package com.evollu.react.fa;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.analytics.FirebaseAnalytics;

import android.os.Bundle;

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
        FirebaseAnalytics.getInstance(getCurrentActivity()).setUserId(id);
    }

    @ReactMethod
    public void setUserProperty(String name, String property) {
        FirebaseAnalytics.getInstance(getCurrentActivity()).setUserProperty(name, property);
    }

    @ReactMethod
    public void logEvent(String name, ReadableMap parameters) {
        FirebaseAnalytics.getInstance(getCurrentActivity()).logEvent(name, Arguments.toBundle(parameters));
    }

    @ReactMethod
    public void setEnabled(Boolean enabled) {
        FirebaseAnalytics.getInstance(getCurrentActivity()).setAnalyticsCollectionEnabled(enabled);
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
