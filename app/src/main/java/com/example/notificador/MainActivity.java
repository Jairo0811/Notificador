package com.example.notificador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;

public class MainActivity extends AppCompatActivity {
    public static final String TAG= "PUSH";
    public String pushtoken ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getToken();
    }
private void getToken() {
    Log.i(TAG, "get token begin");

    new Thread() {
        @Override
        public void run() {
            try {
                String appId = AGConnectServicesConfig.fromContext(MainActivity.this).getString("client/app_id");
                Log.i(TAG, "APPID" + appId);
                pushtoken = HmsInstanceId.getInstance(MainActivity.this).getToken(appId, "HCM");
                Log.i(TAG, "token");
                if (!TextUtils.isEmpty(pushtoken)) {
                    Log.i(TAG, "get token" + pushtoken);
                }
            } catch (Exception e) {
                Log.i(TAG, "getToken Failed" + e);

            }
        }
    }.start();

}
}