package kkk.taiwan.kuanlin.piandroid;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by kuanlin on 2016/3/10.
 */

public class myAdmin extends DeviceAdminReceiver {

    void showToast(Context context, String msg) {
        //String status = context.getString(R.string.admin_receiver_status, msg);
        Toast.makeText(context, "裝置政策管理員", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        showToast(context, "admin_receiver_status_enabled");
    }

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        CharSequence disable_warning = "Are you sure？";
        return disable_warning;
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        showToast(context, "Stop DevicePolicyManager");
    }

    @Override
    public void onPasswordChanged(Context context, Intent intent) {
        showToast(context, "admin_receiver_status_pw_changed");
    }
}
