package kkk.taiwan.kuanlin.piandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuanlin on 2016/3/4.
 */
public class intent extends AppCompatActivity{

    private static List<ResolveInfo> List_intent_apps; //App清單
    //List不能直接實例化(instantiated)
    //可以new一個ArrayList，因為ArrayList也是一種List
    private static List<String> List_apps_name = new ArrayList<String>();
    public static String package_name;
    public static String[] splitlog;
    public static ArrayAdapter<String> logadapter;

    ImageView imageView_title_intent;
    Button button_select;
    Button button_monitor;
    Button button_stop;
    ListView listView_log;

    long exitTime=0; //返回鍵
    private DrawerLayout drawer_layout;
    private FrameLayout frame_layout;
    private ListView listview_left;
    String[] Balls = new String[]
            {"首頁","權限分析","意圖監控","組態設定"};
    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            String sel = parent.getItemAtPosition(position).toString();
            //switch不能處理字串型別
            if (sel.equals("首頁"))
            {
                Intent intent = new Intent();
                intent.setClass(intent.this, MainActivity.class);
                startActivity(intent);
                intent.this.finish();
            }
            else if (sel.equals("權限分析"))
            {
                Intent intent = new Intent();
                intent.setClass(intent.this, permission.class);
                startActivity(intent);
                intent.this.finish();
            }
            else if (sel.equals("意圖監控"))
            {}
            else if (sel.equals("組態設定"))
            {
                Intent intent = new Intent();
                intent.setClass(intent.this, settings.class);
                startActivity(intent);
                intent.this.finish();
            }
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_main);

        imageView_title_intent = (ImageView)findViewById(R.id.imageView_title_intent);
        button_select = (Button)findViewById(R.id.button_select);
        button_monitor = (Button)findViewById(R.id.button_monitor);
        button_stop = (Button)findViewById(R.id.button_stop);
        listView_log = (ListView)findViewById(R.id.listView_log);

        drawer_layout = (DrawerLayout)findViewById(R.id.drawer_layout);
        frame_layout = (FrameLayout)findViewById(R.id.frame_layout);
        listview_left = (ListView)findViewById(R.id.listview_left);
        ArrayAdapter<String> adapterBalls=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Balls);
        listview_left.setAdapter(adapterBalls);

        listview_left.setOnItemClickListener(listener);

        getAppList();
        select(); //alertdialog選單
        startmonitor();
    }

    public void getAppList()
    {
        //獲取系統所有app訊息
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List_intent_apps = getPackageManager().queryIntentActivities(mainIntent, 0);
        for(int i=0; i<List_intent_apps.size(); i++) {
            ResolveInfo info = List_intent_apps.get(i);
            List_apps_name.add(info.activityInfo.packageName);
        }
    }

    public void select()
    {
        button_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder monitor_appname = new AlertDialog.Builder(intent.this).
                        setItems(List_apps_name.toArray(new String[List_apps_name.size()]),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        package_name = List_apps_name.get(which);
                                        Toast.makeText(getApplicationContext(), package_name, Toast.LENGTH_SHORT).show();
                                        //選完將圖片顯示在畫面上
                                        ResolveInfo info = List_intent_apps.get(which);
                                        imageView_title_intent.setBackground(info.activityInfo.loadIcon(getPackageManager()));
                                    }
                                });
                monitor_appname.show();
            }
        });
    }

    public void startmonitor()
    {
        final Intent intent_log = new Intent();
        button_monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle name = new Bundle();
                Bundle flag = new Bundle();
                name.putString("package_name", package_name);
                flag.putBoolean("flag", true);
                intent_log.putExtras(flag);
                intent_log.putExtras(name);
                intent_log.setClass(intent.this, ServiceLog.class);
                startService(intent_log);
            }
        });
        button_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent_log);
                logadapter = new ArrayAdapter<String>
                        (intent.this, android.R.layout.simple_list_item_1, splitlog);
                listView_log.setAdapter(logadapter);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //System.currentTimeMillis()無論何時調用，肯定大於2000
            if((System.currentTimeMillis()-exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "連按兩次即可離開", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }
            else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
