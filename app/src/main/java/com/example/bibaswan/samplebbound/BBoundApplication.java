package com.example.bibaswan.samplebbound;

import android.app.Application;

import com.bebound.sdk.BeBound;
import com.bebound.sdk.config.BeAppConfig;

public class BBoundApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        BeBound.init(this, new BeAppConfig() {
            @Override
            public String getBeAppKey() {
                return "YVQNxFiY3nRCmEEqXHs1hFxJChB9WxA9EFSwtWGRZJGA";
            }

            @Override
            public long getBeAppId() {
                return 108; // Put your APP_ID here
            }

            @Override
            public int getBeAppManifestResId() {
                return R.xml.b_bound_manifest; //Put the reference of your Be-Application manifest
            }
        });    }
}
