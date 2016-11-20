package kkk.taiwan.kuanlin.piandroid;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.StringRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private long exitTime=0; //返回鍵
    public static DatabaseHelper PiaDb;
    double starttime;
    double endtime;

    //doInbackground
    private static String string_score;

    //permission
    private static List<ResolveInfo> List_apps; //App清單
    private static int appnumber;
    protected static String[] group_permission; //單一App之permissions
    private static String pkg_name;

    //devicePolicymanager
    public static ComponentName DAN; //settings也要用

    //settings
    private WifiManager wifiManager;
    public static DevicePolicyManager devicePolicyManager; //settings也要用
    private final int REQUEST_CODE = 100;
    private CookieManager cm = new CookieManager();

    TextView textView_title1;
    TextView textView_title2;
    TextView textView_score;
    Button button_detail;
    Button button_refresh;
    Button button_times;

    private DrawerLayout drawer_layout;
    private FrameLayout frame_layout;
    private ListView listview_left;

    Context mContext = MainActivity.this;
    String[] Balls = new String[]
            {"首頁","權限分析","意圖監控","組態設定"};
    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // TODO Auto-generated method stub
            String sel = parent.getItemAtPosition(position).toString();
            //switch不能處理字串型別
            if (sel.equals("首頁"))
            {}
            else if (sel.equals("權限分析"))
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, permission.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
            else if (sel.equals("意圖監控"))
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, intent.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
            else if (sel.equals("組態設定"))
            {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, settings.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_title1 = (TextView)findViewById(R.id.textView_title1);
        textView_title2 = (TextView)findViewById(R.id.textView_title2);
        textView_score = (TextView)findViewById(R.id.textView_score);
        button_detail = (Button)findViewById(R.id.button_detail);
        button_refresh = (Button)findViewById(R.id.button_refresh);
        button_times = (Button)findViewById(R.id.button_times);

        drawer_layout = (DrawerLayout)findViewById(R.id.drawer_layout);
        frame_layout = (FrameLayout)findViewById(R.id.frame_layout);
        listview_left = (ListView)findViewById(R.id.listview_left);
        ArrayAdapter<String> adapterBalls=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Balls);
        listview_left.setAdapter(adapterBalls);
        listview_left.setOnItemClickListener(listener);

        PiaDb = new DatabaseHelper(MainActivity.this); //創建資料庫
        new LoadingDataAsyncTask().execute(); //執行AsyncTask

        //裝置管理員
        devicePolicyManager = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
        //申請權限
        DAN = new ComponentName(this, myAdmin.class);
        boolean isAdminActive = devicePolicyManager.isAdminActive(DAN);
        if(!isAdminActive) {
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, DAN);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "裝置政策管理員");
            startActivityForResult(intent, REQUEST_CODE);
        }

        viewData(); // button_detail.OnClickListener
        refreshData(); //button_refresh.OnClickListener
    }

    class LoadingDataAsyncTask extends AsyncTask<String, Integer, Integer>
    {
        //double total_score = 0;
        //double average_score = 0;
        private ProgressDialog myDialog;

        @Override
        protected void onPreExecute() {
            //在背景執行之前要做的事，寫在這裡
            //初始化進度條
            myDialog = new ProgressDialog(MainActivity.this);
            myDialog.setMessage("複雜是工程，簡潔是藝術!");
            myDialog.setCancelable(false);
            myDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            myDialog.show();
            super.onPreExecute();
        }
        @Override
        protected Integer doInBackground(String... param) {
            //一定必須覆寫的方法
            //背景執行的內容放此
            //這裡不能和UI有任何互動

            //開始計時
            starttime = System.currentTimeMillis();
            //獲取系統所有app訊息
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            List_apps = getPackageManager().queryIntentActivities(mainIntent, 0);

            appnumber = List_apps.size();
            Log.i("totalidid", Integer.toString(appnumber));
            double thisapp_score = 0;
            String thisapp_finalscore;

            int progress = 0;
            for(int i = 0; i <appnumber; i++) //計算分數+匯入至資料庫
            {
                ResolveInfo info = List_apps.get(i);
                Log.i("ididid", Integer.toString(i));

                pkg_name = info.activityInfo.packageName;

                //取得權限
                try
                {
                    PackageInfo pinfo = getPackageManager().getPackageInfo(pkg_name, PackageManager.GET_PERMISSIONS);
                    group_permission = pinfo.requestedPermissions;
                    if (group_permission == null)
                    {
                        group_permission = new String[1];
                        group_permission[0] = "不需要任何權限,Good!";
                    }
                    thisapp_score = 0;
                    thisapp_score = calculate.calculatescore(); //計算分數
                    //total_score += thisapp_score;
                }
                catch(PackageManager.NameNotFoundException e) {
                    e.printStackTrace(); }

                DecimalFormat df = new DecimalFormat("#.###");
                thisapp_finalscore = df.format(thisapp_score);

                Cursor test = PiaDb.getAllData();
                int testnumber = test.getCount();
                if(testnumber<appnumber) //判斷要新增的資料是否已經存在資料庫內
                {
                    //匯入至資料庫PiaDb
                    PiaDb.insertData(String.valueOf(i+1), pkg_name, "Application", Double.parseDouble(thisapp_finalscore));
                    Log.i("kkk", pkg_name + "insert");
                }
                else
                {
                    //若已存在，updataData
                    PiaDb.updateData(String.valueOf(i+1), pkg_name, "Application", Double.parseDouble(thisapp_finalscore));
                    Log.i("kkk", "i:" + String.valueOf(i) + " " + pkg_name + "update");
                }
                publishProgress(Integer.valueOf(progress));
                progress++;
            }

            loadsetting();
            //average_score = total_score/appnumber;

            //結束計時
            endtime = System.currentTimeMillis();
            return 1;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            //此方法會取得一個數值，可以用來計算目前執行進度
            //通常用來改變進度列(Progressbar)
            myDialog.setProgress(progress[0]);
            super.onProgressUpdate(progress);
        }

        @Override
        protected void onPostExecute(Integer result) {
            //doInBackground執行完後就會執行此方法
            //通常用來傳資料給UI顯示
            ((TextView)findViewById(R.id.textView_title1)).setText("已安裝應用程式數量 = " + appnumber);

            Cursor res_ave = PiaDb.getAverage(); //取得平均評分
            if (res_ave.getCount() == 0) {
                //show message
                showMessage("錯誤", "無任何資料");
            }
            res_ave.moveToFirst(); //把指標移到第一筆資料
            float ave = res_ave.getFloat(0);

            DecimalFormat df = new DecimalFormat("#.###"); //只顯示到小數點後第三位
            string_score = new String();
            string_score = df.format(ave);
            if (ave>=5) {
                //分數大於5字體紅色
                ((TextView)findViewById(R.id.textView_score)).setTextColor(Color.RED);
                ((TextView)findViewById(R.id.textView_score)).setText(string_score);
            }
            else {
                //其他為藍色
                ((TextView)findViewById(R.id.textView_score)).setTextColor(Color.BLUE);
                ((TextView)findViewById(R.id.textView_score)).setText(string_score);
            }

            super.onPostExecute(result);
            if(result.equals(1)){
                myDialog.dismiss();
            }

            double totaltime = endtime-starttime;
            button_times.setText("時間="+(totaltime/1000)+"秒");
        }
    }

    public void loadsetting()
    {
        Cursor test = PiaDb.getAllData();
        int testnumber = test.getCount();

        int id_number = appnumber+1;

        //version
        if(Build.VERSION.SDK_INT < 21)
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Version", "System Configuration", 8);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Version", "System Configuration", 8);
                id_number += 1;
            }
        }
        else
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Version", "System Configuration", 0);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Version", "System Configuration", 0);
                id_number += 1;
            }
        }

        //auto-lock time
        String autolock = Settings.System.getString(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT);
        if(Integer.parseInt(autolock)>60000)
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Auto-Lock Time", "System Configuration", 8);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Auto-Lock Time", "System Configuration", 8);
                id_number += 1;
            }
        }
        else
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Auto-Lock Time", "System Configuration", 0);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Auto-Lock Time", "System Configuration", 0);
                id_number += 1;
            }
        }

        //thirdparty
        int thirdparty_state_int = Settings.Secure.getInt(getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS, 0);
        if(thirdparty_state_int == 0) //未知來源關閉：0  未知來源開啟：1
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Third Party App", "System Configuration", 0);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Third Party App", "System Configuration", 0);
                id_number += 1;
            }
        }
        else
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Third Party App", "System Configuration",8);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Third Party App", "System Configuration", 8);
                id_number += 1;
            }
        }

        //screen lock
        int pw_state = 0;
        if(Build.VERSION.SDK_INT < 23) {
            try {
                pw_state = android.provider.Settings.System.getInt(getContentResolver(), Settings.System.LOCK_PATTERN_ENABLED);
            } catch (Settings.SettingNotFoundException e) {e.printStackTrace();}

            if(pw_state == 0)
            {
                if(testnumber<id_number)
                {
                    PiaDb.insertData(String.valueOf(id_number), "Screen Lock", "System Configuration", 8);
                    id_number += 1;
                }
                else
                {
                    PiaDb.updateData(String.valueOf(id_number), "Screen Lock", "System Configuration", 8);
                    id_number += 1;
                }
            }
            else
            {
                if(testnumber<id_number)
                {
                    PiaDb.insertData(String.valueOf(id_number), "Screen Lock", "System Configuration", 0);
                    id_number += 1;
                }
                else
                {
                    PiaDb.updateData(String.valueOf(id_number), "Screen Lock", "System Configuration", 0);
                    id_number += 1;
                }
            }
        }
        else
        {
            //不列入計算
        }

        //Wifi
        //需要ACCESS_WIFI_STATE權限
        wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        boolean wifi_test = wifiManager.isWifiEnabled();
        String s_test = String.valueOf(wifi_test);
        Log.i("kkk", s_test);
        if(wifiManager.isWifiEnabled())
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Wi-Fi Setting", "System Configuration", 8);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Wi-Fi Setting", "System Configuration", 8);
                id_number += 1;
            }
        }
        else
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Wi-Fi Setting", "System Configuration", 0);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Wi-Fi Setting", "System Configuration", 0);
                id_number += 1;
            }
        }

        //encryption status
        int test_encryption = devicePolicyManager.getStorageEncryptionStatus();
        Log.i("test_encryption", String.valueOf(test_encryption));
        if(test_encryption==0 ||test_encryption==1) //不支援：0 支援但沒開啟：1 啟動加密+螢幕鎖：3
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Encrypt Phone", "System Configuration", 8);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Encrypt Phone", "System Configuration", 8);
                id_number += 1;
            }
        }
        else
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Encrypt Phone", "System Configuration",0);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Encrypt Phone", "System Configuration",0);
                id_number += 1;
            }
        }

        //disable camera
        if(devicePolicyManager.getCameraDisabled(DAN)==true)
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Disable Camera", "System Configuration", 0);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Disable Camera", "System Configuration", 0);
                id_number += 1;
            }
        }
        else
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Disable Camera", "System Configuration",8);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Disable Camera", "System Configuration", 8);
                id_number += 1;
            }
        }

        //cookie setting
        CookieStore cookieStore = cm.getCookieStore();
        List<HttpCookie> cookieList = cookieStore.getCookies();
        if(cookieList==null)//若cookiestore為空,代表較無風險
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Cookie Setting", "System Configuration", 0);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Cookie Setting", "System Configuration", 0);
                id_number += 1;
            }
        }
        else
        {
            if(testnumber<id_number)
            {
                PiaDb.insertData(String.valueOf(id_number), "Cookie Setting", "System Configuration",8);
                id_number += 1;
            }
            else
            {
                PiaDb.updateData(String.valueOf(id_number), "Cookie Setting", "System Configuration", 8);
                id_number += 1;
            }
        }
    }

    public void viewData()
    {
        button_detail.setOnClickListener(new Button.OnClickListener() //顯示詳細資料
        {
            @Override
            public void onClick(View v)
            {
                Cursor res = PiaDb.getAllData();
                if(res.getCount()==0) //若資料筆數為0，顯示錯誤訊息
                {
                    //show message
                    showMessage("錯誤", "無任何資料");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Id : " +res.getString(0)+ "\n");
                    buffer.append("Title : " +res.getString(1)+ "\n");
                    buffer.append("Type : " +res.getString(2)+ "\n");
                    buffer.append("Marks : " +res.getDouble(3)+ "\n\n");
                }

                //show all data
                showMessage("詳細資訊", buffer.toString());
            }
        });
    }

    public void refreshData()
    {
        button_refresh.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadingDataAsyncTask().execute(); //再執行AsyncTask
            }
        });
    }

    public void showMessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
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
