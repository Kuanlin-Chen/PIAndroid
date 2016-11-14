package kkk.taiwan.kuanlin.piandroid;

import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
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
import java.util.List;

/**
 * Created by kuanlin on 2016/3/4.
 */
public class settings extends AppCompatActivity{

    //devicePolicymanager
    //private static ComponentName DAN;

    //組態設定
    //private DevicePolicyManager devicePolicyManager;
    private WifiManager wifiManager;
    private CookieManager cm = new CookieManager();
    //private final int REQUEST_CODE = 100;

    long exitTime=0; //返回鍵
    private DrawerLayout drawer_layout;
    private FrameLayout frame_layout;
    private ListView listview_left;
    String[] Balls = new String[]
            {"Home","Permission","Intent","Setting"};
    private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            String sel = parent.getItemAtPosition(position).toString();
            //switch不能處理字串型別
            if (sel.equals("Home"))
            {
                Intent intent = new Intent();
                intent.setClass(settings.this, MainActivity.class);
                startActivity(intent);
                settings.this.finish();
            }
            else if (sel.equals("Permission"))
            {
                Intent intent = new Intent();
                intent.setClass(settings.this, permission.class);
                startActivity(intent);
                settings.this.finish();
            }
            else if (sel.equals("Intent"))
            {
                Intent intent = new Intent();
                intent.setClass(settings.this, intent.class);
                startActivity(intent);
                settings.this.finish();
            }
            else if (sel.equals("Setting"))
            {}
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_main);

        TextView textView_title1 = (TextView)findViewById(R.id.textView_title1);

        drawer_layout = (DrawerLayout)findViewById(R.id.drawer_layout);
        frame_layout = (FrameLayout)findViewById(R.id.frame_layout);
        listview_left = (ListView)findViewById(R.id.listview_left);
        ArrayAdapter<String> adapterBalls=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Balls);
        listview_left.setAdapter(adapterBalls);

        listview_left.setOnItemClickListener(listener);

        //裝置管理員
        /*
        devicePolicyManager = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
        //申請權限
        DAN = new ComponentName(this, myAdmin.class);
        boolean isAdminActive = devicePolicyManager.isAdminActive(DAN);
        if(!isAdminActive) {
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, DAN);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "DevicePolicyManager");
            startActivityForResult(intent, REQUEST_CODE);
        }*/

        version(); //Android版本
        screenlock(); //密碼設定
        autolocktime(); //自動鎖屏時間
        thirdparty(); //應用程式設定
        wifi(); //Wi-Fi設定
        encrypt(); //全機加密
        camera(); //相機設定
        cookie(); //瀏覽器Cookie設定
    }

    public void version()
    {
        TextView textView_version_result = (TextView)findViewById(R.id.textView_version_result);
        Button button_version_fix = (Button)findViewById(R.id.button_version_fix);
        if(Build.VERSION.SDK_INT >= 21) //Android API 21 = 5.0.2
        {
            textView_version_result.setText("Pass");
            textView_version_result.setTextColor(Color.BLUE);
            button_version_fix.setText("");
            button_version_fix.setBackgroundColor(00000000);
        }
        else if (Build.VERSION.SDK_INT < 21)
        {
            textView_version_result.setText("Fail");
            textView_version_result.setTextColor(Color.RED);
            //button_version_fix.setTextColor(Color.RED);
            button_version_fix.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    AlertDialog.Builder versioncheck_repair_ad=new AlertDialog.Builder(settings.this);
                    versioncheck_repair_ad.setTitle("Version");
                    versioncheck_repair_ad.setMessage("Android version is too old！");
                    versioncheck_repair_ad.setNegativeButton("Skip", null);
                    versioncheck_repair_ad.setPositiveButton("Fix", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int fix) {
                            startActivity(new Intent(Settings.ACTION_SETTINGS));
                        }
                    });
                    versioncheck_repair_ad.show();
                }
            });
        }
        else
        {
            textView_version_result.setText("Unknown");
            textView_version_result.setTextColor(Color.GREEN);
            button_version_fix.setText("");
            button_version_fix.setBackgroundColor(00000000);
        }
    }

    public void screenlock()
    {
        TextView textView_screenlock_result = (TextView)findViewById(R.id.textView_screenlock_result);
        Button button_screenlock_fix = (Button)findViewById(R.id.button_screenlock_fix);
        int pw_state = 0;
        if(Build.VERSION.SDK_INT < 23) {
            try {
                pw_state = android.provider.Settings.System.getInt(getContentResolver(), Settings.System.LOCK_PATTERN_ENABLED);
            } catch (Settings.SettingNotFoundException e) {e.printStackTrace();}

            if (pw_state == 0)
            {
                textView_screenlock_result.setText("Fail");
                textView_screenlock_result.setTextColor(Color.RED);
                //button_screenlock_fix.setTextColor(Color.RED);
                button_screenlock_fix.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder password_repair_ad = new AlertDialog.Builder(settings.this);
                        password_repair_ad.setTitle("Screen Lock");
                        password_repair_ad.setMessage("You have not set screen lock yet！");
                        password_repair_ad.setNegativeButton("Skip", null);
                        password_repair_ad.setPositiveButton("Fix", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int fix) {
                                startActivity(new Intent(Settings.ACTION_SECURITY_SETTINGS));
                            }
                        });
                        password_repair_ad.show();
                    }
                });
            }
            else
            {
                textView_screenlock_result.setText("Pass");
                textView_screenlock_result.setTextColor(Color.BLUE);
                button_screenlock_fix.setText("");
                button_screenlock_fix.setBackgroundColor(00000000);
            }
        }
        else
        {
            textView_screenlock_result.setText("XXXX");
            textView_screenlock_result.setTextColor(Color.GRAY);
            button_screenlock_fix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder password_repair_ad = new AlertDialog.Builder(settings.this);
                    password_repair_ad.setTitle("Screen Lock");
                    password_repair_ad.setMessage("This Constant was Deprecated in API 23！");
                    password_repair_ad.setNegativeButton("Skip", null);
                    password_repair_ad.show();
                }
            });
        }
    }

    public void autolocktime()
    {
        TextView textView_autolocktime_result = (TextView)findViewById(R.id.textView_autolocktime_result);
        Button button_autolocktime_fix = (Button)findViewById(R.id.button_autolocktime_fix);
        String autolock = Settings.System.getString(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT);
        Log.i("autolocktime", autolock);
        if(Integer.parseInt(autolock)>60000)
        {
            textView_autolocktime_result.setText("Fail");
            textView_autolocktime_result.setTextColor(Color.RED);
            //button_autolocktime_fix.setTextColor(Color.RED);
            button_autolocktime_fix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder autolocktime_repair_ad = new AlertDialog.Builder(settings.this);
                    autolocktime_repair_ad.setTitle("Auto-Lock Time");
                    autolocktime_repair_ad.setMessage("Setting Auto-Lock Time, please select [Fix] button！");
                    autolocktime_repair_ad.setNegativeButton("Skip", null);
                    autolocktime_repair_ad.setPositiveButton("Fix", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int fix) {
                            Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, 60000);
                        }
                    });
                    autolocktime_repair_ad.show();
                }
            });
        }
        else
        {
            textView_autolocktime_result.setText("Pass");
            textView_autolocktime_result.setTextColor(Color.BLUE);
            button_autolocktime_fix.setText("");
            button_autolocktime_fix.setBackgroundColor(00000000);
        }
    }

    public void thirdparty()
    {
        TextView textView_thirdparty_result = (TextView)findViewById(R.id.textView_thirdparty_result);
        Button button_thirdparty_fix = (Button)findViewById(R.id.button_thirdparty_fix);
        int thirdparty_state_int = Settings.Secure.getInt(getContentResolver(), Settings.Secure.INSTALL_NON_MARKET_APPS, 0);
        Log.i("thirdparty", String.valueOf(thirdparty_state_int));
        if(thirdparty_state_int <= 1 )
        {
            textView_thirdparty_result.setText("Pass");
            textView_thirdparty_result.setTextColor(Color.BLUE);
            button_thirdparty_fix.setText("");
            button_thirdparty_fix.setBackgroundColor(00000000);
        }
        else
        {
            textView_thirdparty_result.setText("Fail");
            textView_thirdparty_result.setTextColor(Color.RED);
            button_thirdparty_fix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder thirdparty_repair_ad = new AlertDialog.Builder(settings.this);
                    thirdparty_repair_ad.setTitle("Third Party Apps");
                    thirdparty_repair_ad.setMessage("If you do not use the third party apps, please select [Fix] button！");
                    thirdparty_repair_ad.setNegativeButton("Skip", null);
                    thirdparty_repair_ad.setPositiveButton("Fix", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int fix) {
                            startActivity(new Intent(Settings.ACTION_SECURITY_SETTINGS));
                        }
                    });
                    thirdparty_repair_ad.show();
                }
            });
        }
    }

    public void wifi()
    {
        TextView textView_wifi_result = (TextView)findViewById(R.id.textView_wifi_result);
        Button button_wifi_fix = (Button)findViewById(R.id.button_wifi_fix);
        wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled())
        {
            textView_wifi_result.setText("Fail");
            textView_wifi_result.setTextColor(Color.RED);
            //button_wifi_fix.setTextColor(Color.RED);
            button_wifi_fix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder wifi_repair_ad = new AlertDialog.Builder(settings.this);
                    wifi_repair_ad.setTitle("Wi-Fi Setting");
                    wifi_repair_ad.setMessage("If you do not need wireless function, please select [Fix] button!");
                    wifi_repair_ad.setNegativeButton("Skip", null);
                    wifi_repair_ad.setPositiveButton("Fix", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int fix) {
                            wifiManager.setWifiEnabled(false);
                        }
                    });
                    wifi_repair_ad.show();
                }
            });
        }
        else if(!wifiManager.isWifiEnabled())
        {
            textView_wifi_result.setText("Pass");
            textView_wifi_result.setTextColor(Color.BLUE);
            button_wifi_fix.setText("");
            button_wifi_fix.setBackgroundColor(00000000);
        }
        else
        {
            textView_wifi_result.setText("Unknown");
            textView_wifi_result.setTextColor(Color.GREEN);
            button_wifi_fix.setText("");
            button_wifi_fix.setBackgroundColor(00000000);
        }
    }

    public void encrypt()
    {
        TextView textView_encrypt_result = (TextView)findViewById(R.id.textView_encrypt_result);
        Button button_encrypt_fix = (Button)findViewById(R.id.button_encrypt_fix);
        int encryption = MainActivity.devicePolicyManager.getStorageEncryptionStatus();
        Log.i("encrypt", String.valueOf(encryption));
        if(encryption==0 || encryption==1)
        {
            textView_encrypt_result.setText("Fail");
            textView_encrypt_result.setTextColor(Color.RED);
            //button_encrypt_fix.setTextColor(Color.RED);
            button_encrypt_fix.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog.Builder encryptphone_repair_ad = new AlertDialog.Builder(settings.this);
                    encryptphone_repair_ad.setTitle("Encrypt Phone");
                    encryptphone_repair_ad.setMessage("You should encrypt your phone now！");
                    encryptphone_repair_ad.setNegativeButton("Skip", null);
                    encryptphone_repair_ad.setPositiveButton("Fix", new DialogInterface.OnClickListener()
                    {

                        @Override
                        public void onClick(DialogInterface dialog, int fix)
                        {
                            MainActivity.devicePolicyManager.setStorageEncryption(MainActivity.DAN, true);
                        }
                    });
                    encryptphone_repair_ad.show();
                }
            });
        }
        else
        {
            textView_encrypt_result.setText("Pass");
            textView_encrypt_result.setTextColor(Color.BLUE);
            button_encrypt_fix.setText("");
            button_encrypt_fix.setBackgroundColor(00000000);
        }
    }

    public void camera()
    {
        TextView textView_camera_result = (TextView)findViewById(R.id.textView_camera_result);
        Button button_camera_fix = (Button)findViewById(R.id.button_camera_fix);
        if(MainActivity.devicePolicyManager.getCameraDisabled(MainActivity.DAN)!=true)
        {
            textView_camera_result.setText("Fail");
            textView_camera_result.setTextColor(Color.RED);
            //button_camera_fix.setTextColor(Color.RED);
            button_camera_fix.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog.Builder camera_repair_ad = new AlertDialog.Builder(settings.this);
                    camera_repair_ad.setTitle("Disable Camera");
                    camera_repair_ad.setMessage("If you do not need camera, please select [Fix] button！");
                    camera_repair_ad.setNegativeButton("Skip", null);
                    camera_repair_ad.setPositiveButton("Fix", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int fix) {
                            MainActivity.devicePolicyManager.setCameraDisabled(MainActivity.DAN, true);
                        }
                    });
                    camera_repair_ad.show();
                }
            });
        }
        else if(MainActivity.devicePolicyManager.getCameraDisabled(MainActivity.DAN)==true)
        {
            textView_camera_result.setText("Pass");
            textView_camera_result.setTextColor(Color.BLUE);
            button_camera_fix.setText("");
            button_camera_fix.setBackgroundColor(00000000);
        }
        else
        {
            textView_camera_result.setText("Unknown");
            textView_camera_result.setTextColor(Color.GREEN);
            button_camera_fix.setText("");
            button_camera_fix.setBackgroundColor(00000000);
        }
    }

    public void cookie()
    {
        TextView textView_cookie_result = (TextView)findViewById(R.id.textView_cookie_result);
        Button button_cookie_fix = (Button)findViewById(R.id.button_cookie_fix);
        final CookieStore cookieStore = cm.getCookieStore();
        List<HttpCookie> cookieList = cookieStore.getCookies();
        int cookie_size = cookieList.size();
        Log.i("cookie", String.valueOf(cookie_size));
        if(cookie_size!=0)
        {
            textView_cookie_result.setText("Fail");
            textView_cookie_result.setTextColor(Color.RED);
            //button_cookie_fix.setTextColor(Color.RED);
            button_cookie_fix.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog.Builder cookie_repair_ad = new AlertDialog.Builder(settings.this);
                    cookie_repair_ad.setTitle("Cookie Setting");
                    cookie_repair_ad.setMessage("You should delete cookies now！");
                    cookie_repair_ad.setNegativeButton("Skip", null);
                    cookie_repair_ad.setPositiveButton("Fix", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int fix) {
                            //Add fix function
                            boolean cookie = cm.getCookieStore().removeAll();
                            Log.i("cookie", String.valueOf(cookie));
                        }
                    });
                    cookie_repair_ad.show();
                }
            });
        }
        else
        {
            textView_cookie_result.setText("Pass");
            textView_cookie_result.setTextColor(Color.BLUE);
            button_cookie_fix.setText("");
            button_cookie_fix.setBackgroundColor(00000000);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //System.currentTimeMillis()無論何時調用，肯定大於2000
            if((System.currentTimeMillis()-exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "Click Again", Toast.LENGTH_SHORT).show();
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
