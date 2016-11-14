package kkk.taiwan.kuanlin.piandroid;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by kuanlin on 2016/3/4.
 */
public class permission extends AppCompatActivity {

    GridView gridView_applist;

    //loadApp
    protected List<ResolveInfo> apps;
    //protected List listpermission;
    protected static Drawable appimage;
    protected static String[] group;
    protected static String pkg;

    private long exitTime=0; //返回鍵
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
                intent.setClass(permission.this, MainActivity.class);
                startActivity(intent);
                permission.this.finish();
            }
            else if (sel.equals("Permission"))
            {}
            else if (sel.equals("Intent"))
            {
                Intent intent = new Intent();
                intent.setClass(permission.this, intent.class);
                startActivity(intent);
                permission.this.finish();
            }
            else if (sel.equals("Setting"))
            {
                Intent intent = new Intent();
                intent.setClass(permission.this, settings.class);
                startActivity(intent);
                permission.this.finish();
            }
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_main);

        gridView_applist = (GridView)findViewById(R.id.gridView_applist);

        drawer_layout = (DrawerLayout)findViewById(R.id.drawer_layout);
        frame_layout = (FrameLayout)findViewById(R.id.frame_layout);
        listview_left = (ListView)findViewById(R.id.listview_left);
        ArrayAdapter<String> adapterBalls=
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Balls);
        listview_left.setAdapter(adapterBalls);

        listview_left.setOnItemClickListener(listener);

        loadApp(); //列出所有App
    }

    public void loadApp()
    {
        // 獲取系統所有app訊息
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        new ImageView(permission.this);
        apps = getPackageManager().queryIntentActivities(mainIntent, 0);

        // 把訊息設置到適配器中
        gridView_applist.setAdapter(new AppsAdapter());
    }

    public class AppsAdapter extends BaseAdapter
    {
        public AppsAdapter()
        {}

        @Override
        public int getCount()
        {
            return apps.size();
        }

        @Override
        public Object getItem(int i)
        {
            return apps.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup)
        {
            Button btn;
            if(view == null)
            {
                btn = new Button(permission.this);
                //iv.setScaleX();
                btn.setLayoutParams(new GridView.LayoutParams(200, 200));
            }
            else
            {
                btn = (Button) view;
            }

            ResolveInfo info = apps.get(i);
            btn.setBackground(info.activityInfo.loadIcon(getPackageManager()));

            btn.setId(i);
            btn.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Handle the click here
                    ResolveInfo info = apps.get(i);
                    Log.i("ididid", Integer.toString(i));

                    pkg = info.activityInfo.packageName;
                    appimage = info.activityInfo.loadIcon(getPackageManager());

                    //getPermission
                    try {
                        PackageInfo pinfo =
                                getPackageManager().
                                        getPackageInfo
                                                (pkg, PackageManager.GET_PERMISSIONS);
                        group = pinfo.requestedPermissions;
                    }
                    catch(PackageManager.NameNotFoundException e)
                    {
                        e.printStackTrace();
                    }

                    //開啟新視窗
                    Intent intent = new Intent();
                    intent.setClass(permission.this, listpermission.class);
                    startActivity(intent);
                }
            });

            return btn;
        }
    }

    @Override //覆寫
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
