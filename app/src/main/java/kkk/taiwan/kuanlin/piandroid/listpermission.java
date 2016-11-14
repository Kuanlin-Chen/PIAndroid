package kkk.taiwan.kuanlin.piandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by kuanlin on 2016/3/8.
 */
public class listpermission extends permission
{
    ImageView imageView_icon;
    TextView textView_score;
    Button button_list;
    Button button_define;
    Button button_back;
    ListView listView_permission;

    ArrayAdapter<String> padapter;
    ArrayAdapter<ActivityInfo> intentadapter;
    private String[] define = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listpermission);

        imageView_icon = (ImageView)findViewById(R.id.imageView_icon);
        textView_score = (TextView)findViewById(R.id.textView_score);
        button_list = (Button)findViewById(R.id.button_list);
        button_define = (Button)findViewById(R.id.button_define);
        button_back = (Button)findViewById(R.id.button_back);
        listView_permission = (ListView)findViewById(R.id.listView_permission);

        imageView_icon.setBackground(appimage);

        //取得評分
        Cursor res_onescore = MainActivity.PiaDb.getOneScore(permission.pkg);
        res_onescore.moveToFirst(); //把指標移到第一筆資料
        double onescore = res_onescore.getDouble(0);
        DecimalFormat df = new DecimalFormat("#.###"); //只顯示到小數點後第三位
        String string_score = df.format(onescore);
        if (onescore>=5) {
            textView_score.setTextColor(Color.RED);
            textView_score.setText(" "+string_score);
        }
        else {
            textView_score.setTextColor(Color.BLUE);
            textView_score.setText(" "+string_score);
        }

        button_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (group == null) {
                    group = new String[1];
                    group[0] = "Do not need any permission!";
                }
                //replace.replacestring(); //轉中文
                padapter = new ArrayAdapter<String>
                        (kkk.taiwan.kuanlin.piandroid.listpermission.this, android.R.layout.simple_list_item_1, group);
                listView_permission.setAdapter(padapter);
                itemclick();
            }
        });

        button_define.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v) {
                define = new String[4];
                define[0] = "[Normal]:\nA lower-risk permission that gives requesting applications access to isolated application-level features, with minimal risk to other applications, the system, or the user.";
                define[1] = "[Dangerous]:\nA higher-risk permission that would give a requesting application access to private user data or control over the device that can negatively impact the user.";
                define[2] = "[Signature]:\nA permission that the system grants only if the requesting application is signed with the same certificate as the application that declared the permission.";
                define[3] = "[SignatureOrSystem]:\nA permission that the system grants only to applications that are in the Android system image or that are signed with the same certificate as the application that declared the permission.";

                padapter = new ArrayAdapter<String>(kkk.taiwan.kuanlin.piandroid.listpermission.this, android.R.layout.simple_list_item_1, define);
                listView_permission.setAdapter(padapter);
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    public void itemclick()
    {
        listView_permission.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemclick = padapter.getItem(position);
                Log.i("itemclick", itemclick);
                if(itemclick.equals("Camera")) {
                    AlertDialog.Builder password_repair_ad = new AlertDialog.Builder(listpermission.this);
                    password_repair_ad.setTitle("Camera");
                    password_repair_ad.setMessage("Close camera?");
                    password_repair_ad.setNegativeButton("Skip", null);
                    password_repair_ad.setPositiveButton("Revoke", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int fix) {
                                    try {
                                        //必須安裝在system/priv-app/目錄底下才能使用
                                        Process p = Runtime.getRuntime().exec("pm revoke "+permission.pkg+" android.permission.CAMERA");
                                    }catch (IOException e){
                                        Log.i("itemclick", e.getMessage());
                                    }
                                }
                            }

                    );
                        password_repair_ad.show();
                    }
                }
        });
    }

    @Override //覆寫
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            //返回鍵返回上一頁
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
        return true;
    }
}
