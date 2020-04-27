package com.picher.example.phone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mStatetv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        telephonyManager.listen(new PhoneStateListener() {
//            @Override
//            public void onCallStateChanged(int state, String phoneNumber) {
//                super.onCallStateChanged(state, phoneNumber);
//                Log.d("picher", "状态：" + state + "号码：" + phoneNumber);
//                switch (state) {
//                    case TelephonyManager.CALL_STATE_IDLE:
//                        Log.d("picher", "当前空闲");
//                        break;
//                    case TelephonyManager.CALL_STATE_OFFHOOK:
//                        Log.d("picher", "当前空闲");
//                        break;
//                    case TelephonyManager.CALL_STATE_RINGING:
//                        Log.d("picher", "当前响铃");
//                        break;
//                }
//            }
//        }, PhoneStateListener.LISTEN_CALL_STATE);
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_NEW_OUTGOING_CALL);//去电监听
        filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);//来电状态监听
        registerReceiver(new PhoneReceiver(), filter);

        mStatetv = findViewById(R.id.m_state_tv);
        findViewById(R.id.m_get_phone_state_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStatetv.setText(getCallState() + "");
            }
        });
    }

    public class PhoneReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if (action == null) {
                    return;
                }
                Log.d("picher", "" + action);
                if (action.equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
                    Log.d("picher", "去电");
                } else if (action.equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
                    Log.d("picher", "状态：" + getCallState());
                }
            }
        }
    }

    public int getCallState() {
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        return manager.getCallState();
    }
}
