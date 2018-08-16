package com.example.bibaswan.samplebbound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bebound.sdk.BeBound;
import com.bebound.sdk.authentication.AuthManager;
import com.bebound.sdk.authentication.listener.AuthListener;

public class MainActivity extends AppCompatActivity implements AuthListener {

    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!BeBound.isUserAuthenticated()) {
            new Thread(() -> AuthManager.getInstance()
                    .withContext(this)
                    .onAuthListener(this)
                    .send())
                    .start();
        }
    }

    public void onSendRequestClick(View view){

    }

    @Override
    public void onAuthenticationSent() {
        Log.d(TAG, "Authentication request sent");
    }

    @Override
    public void onUserAuthenticated() {
        Log.d(TAG, "Success! User is authenticated");
    }

    @Override
    public void onErrorDuringUserAuthentication(int errorStatus) {
        Log.d(TAG, "Error during authentication!");
    }
}
