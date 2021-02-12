package com.example.notificador;

import android.util.Log;

import com.huawei.hms.push.HmsMessageService;

public class Services extends HmsMessageService {

    private static  final  String TAG ="PushKit";
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.i(TAG, "TOKEN RECIBIDO:" + token);
    }
}
