package com.picher.example.phone;

import android.content.Intent;
import android.os.IBinder;
import android.telecom.Call;
import android.telecom.CallAudioState;
import android.telecom.InCallService;
import android.util.Log;

/**
 * @author xiuhao on 2020/4/27.
 * @version 1.0
 * @describe:
 */
public class InCallServiceImp extends InCallService {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("picher", "InCallService创建");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("picher", "bindService");
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("picher", "unBindService");
        return super.onUnbind(intent);
    }

    @Override
    public void onCallAdded(Call call) {
        super.onCallAdded(call);
        Log.d("picher", "onCallAdded");
    }

    @Override
    public void onCallRemoved(Call call) {
        super.onCallRemoved(call);
        Log.d("picher", "onCallRemoved");
    }

    @Override
    public void onCallAudioStateChanged(CallAudioState audioState) {
        super.onCallAudioStateChanged(audioState);
        Log.d("picher", "onCallAudioStateChanged");
    }

    @Override
    public void onBringToForeground(boolean showDialpad) {
        super.onBringToForeground(showDialpad);
        Log.d("picher", "onBringToForeground");
    }

    @Override
    public void onCanAddCallChanged(boolean canAddCall) {
        super.onCanAddCallChanged(canAddCall);
        Log.d("picher", "onCanAddCallChanged");
    }
}
