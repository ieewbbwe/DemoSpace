package com.picher.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.picher.example.aidl.MServices;

public class MainActivity extends AppCompatActivity {
    private MServices mService;
    private ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("mxh", "onServiceConnected");
            mService = MServices.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("mxh", "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindServices();

        findViewById(R.id.m_get_name_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = mService.getName();
                    Log.d("mxh", "name:" + name + "BookName:" + mService.getBooks().get(0).getName());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void bindServices() {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.picher.example.model2", "com.picher.example.model2.AIDLServices");
        intent.setComponent(componentName);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
