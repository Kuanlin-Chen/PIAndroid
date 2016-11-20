package kkk.taiwan.kuanlin.piandroid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by kuanlin on 2016/3/15.
 */
public class ServiceLog extends Service
{
    private static String package_name;
    private boolean flag;
    private Handler handler;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(getApplicationContext(), "正在執行意圖監控", Toast.LENGTH_LONG).show();
        Log.i("ServiceLog", "ServiceLog is running");
        package_name = intent.getExtras().getString("package_name");
        flag = intent.getExtras().getBoolean("flag");
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (flag){
                    try {
                        //su
                        Process p = Runtime.getRuntime().exec("su");
                        DataOutputStream pp =  
                                new DataOutputStream(p.getOutputStream());
                        //logcat
                        pp.writeBytes("logcat -v time -d |grep '"
                                + package_name + "' |grep 'android.intent.action.'\n");
                        BufferedReader bufferedReader = 
                                new BufferedReader
                                    (new InputStreamReader(p.getInputStream()));
                        pp.writeBytes("exit\n");
                        pp.flush();

                        StringBuilder log = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null){
                            log.append(line);
                            log.append("\n");
                        }

                        if (kkk.taiwan.kuanlin.piandroid.intent.splitlog == null) {
                            kkk.taiwan.kuanlin.piandroid.intent.splitlog = new String[1];
                            kkk.taiwan.kuanlin.piandroid.intent.splitlog[0] = "無任何紀錄";
                        } else {
                            kkk.taiwan.kuanlin.piandroid.intent.splitlog = log.toString().split("\n");
                            //翻譯關鍵字
                            replace.replace();

                        }
                    } catch (IOException e) {
                        kkk.taiwan.kuanlin.piandroid.intent.splitlog = new String[1];
                        kkk.taiwan.kuanlin.piandroid.intent.splitlog[0] = "很抱歉，您沒有超級使用者權限(SuperUser)！";
                    }
                }
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy()
    {
        flag = false;
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0)
    {
        return null;
    }
}
