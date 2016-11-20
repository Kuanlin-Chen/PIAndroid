package kkk.taiwan.kuanlin.piandroid;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuanlin on 2016/3/7.
 */
public class calculate extends MainActivity
{
    public static double calculatescore()
    {
        int size = group_permission.length; //樣本數
        double avg_score = 0; //最後平均分數
        double assessment_score = 0; //加總分數
        String word = null;

        for(int i = 0; i < size; i++) {
            word = group_permission[i].toString();

            //若分數清單(ScoreTable)中有對應的值
            if (ScoreTable.containsKey(word)) {
                assessment_score += (double)ScoreTable.get(word);
            }
            //custom或其他權限
            else {
                assessment_score += (double)8;
            }
        }

        //算分
        avg_score = assessment_score/(size);
        return avg_score;
    }

    private static final Map<String, Integer> ScoreTable = new HashMap<String, Integer>();
    static {
        //AAA 9
        ScoreTable.put("android.permission.ACCESS_CHECKIN_PROPERTIES", 5);
        ScoreTable.put("android.permission.ACCESS_COARSE_LOCATION", 8);
        ScoreTable.put("android.permission.ACCESS_FINE_LOCATION", 8);
        ScoreTable.put("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS", 2);
        ScoreTable.put("android.permission.ACCESS_NETWORK_STATE", 2);
        ScoreTable.put("android.permission.ACCESS_NOTIFICATION_POLICY", 2);
        ScoreTable.put("android.permission.ACCESS_WIFI_STATE", 2);
        ScoreTable.put("android.permission.ACCOUNT_MANAGER", 5);
        ScoreTable.put("android.permission.ADD_VOICEMAIL", 8);
        //BBB 29
        ScoreTable.put("android.permission.BATTERY_STATS", 2);
        ScoreTable.put("android.permission.BIND_ACCESSIBILITY_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_APPWIDGET", 5);
        ScoreTable.put("android.permission.BIND_CARRIER_MESSAGING_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_CARRIER_SERVICES", 5);
        ScoreTable.put("android.permission.BIND_CHOOSER_TARGET_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_DEVICE_ADMIN", 5);
        ScoreTable.put("android.permission.BIND_DREAM_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_INCALL_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_INPUT_METHOD", 5);
        ScoreTable.put("android.permission.BIND_MIDI_DEVICE_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_NFC_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_NOTIFICATION_LISTENER_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_PRINT_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_REMOTEVIEWSE", 5);
        ScoreTable.put("android.permission.BIND_TELECOM_CONNECTION_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_TEXT_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_TV_INPUT", 5);
        ScoreTable.put("android.permission.BIND_VOICE_INTERACTION", 5);
        ScoreTable.put("android.permission.BIND_VPN_SERVICE", 5);
        ScoreTable.put("android.permission.BIND_WALLPAPER", 5);
        ScoreTable.put("android.permission.BLUETOOTH", 2);
        ScoreTable.put("android.permission.BLUETOOTH_ADMIN", 2);
        ScoreTable.put("android.permission.BLUETOOTH_PRIVILEGED", 5);
        ScoreTable.put("android.permission.BODY_SENSORS", 5);
        ScoreTable.put("android.permission.BROADCAST_PACKAGE_REMOVED", 10);
        ScoreTable.put("android.permission.BROADCAST_SMS", 5);
        ScoreTable.put("android.permission.BROADCAST_STICKY", 2);
        ScoreTable.put("android.permission.BROADCAST_WAP_PUSH", 5);
        //CCC 13
        ScoreTable.put("android.permission.CALL_PHONE", 10);
        ScoreTable.put("android.permission.CALL_PRIVILEGED", 5);
        ScoreTable.put("android.permission.CAMERA", 8);
        ScoreTable.put("android.permission.CAPTURE_AUDIO_OUTPUT", 5);
        ScoreTable.put("android.permission.CAPTURE_SECURE_VIDEO_OUTPUT", 5);
        ScoreTable.put("android.permission.CAPTURE_VIDEO_OUTPUT", 5);
        ScoreTable.put("android.permission.CHANGE_COMPONENT_ENABLED_STATE", 5);
        ScoreTable.put("android.permission.CHANGE_CONFIGURATION", 5);
        ScoreTable.put("android.permission.CHANGE_NETWORK_STATE", 2);
        ScoreTable.put("android.permission.CHANGE_WIFI_MULTICAST_STATE", 2);
        ScoreTable.put("android.permission.CHANGE_WIFI_STATE", 10);
        ScoreTable.put("android.permission.CLEAR_APP_CACHE", 5);
        ScoreTable.put("android.permission.CONTROL_LOCATION_UPDATES", 5);
        //DDD 5
        ScoreTable.put("android.permission.DELETE_CACHE_FILES", 5);
        ScoreTable.put("android.permission.DELETE_PACKAGES", 10);
        ScoreTable.put("android.permission.DIAGNOSTIC", 5);
        ScoreTable.put("android.permission.DISABLE_KEYGUARD", 10);
        ScoreTable.put("android.permission.DUMP", 5);
        //EEE 1
        ScoreTable.put("android.permission.EXPAND_STATUS_BAR", 10);
        //FFF 2
        ScoreTable.put("android.permission.FACTORY_TEST", 5);
        ScoreTable.put("android.permission.FLASHLIGHT", 2);
        //GGG 5
        ScoreTable.put("android.permission.GET_ACCOUNTS", 2);
        ScoreTable.put("android.permission.GET_ACCOUNTS_PRIVILEGED", 2);
        ScoreTable.put("android.permission.GET_PACKAGE_SIZE", 2);
        ScoreTable.put("android.permission.GET_TASKS", 5);
        ScoreTable.put("android.permission.GLOBAL_SEARCH", 5);
        //III 4
        ScoreTable.put("android.permission.INSTALL_LOCATION_PROVIDER", 5);
        ScoreTable.put("android.permission.INSTALL_PACKAGES", 10);
        ScoreTable.put("android.permission.INSTALL_SHORTCUT", 2);
        ScoreTable.put("android.permission.INTERNET", 2);
        //KKK 1
        ScoreTable.put("android.permission.KILL_BACKGROUND_PROCESSES", 10);
        //LLL 1
        ScoreTable.put("android.permission.LOCATION_HARDWARE", 5);
        //MMM 7
        ScoreTable.put("android.permission.MANAGE_DOCUMENTS", 5);
        ScoreTable.put("android.permission.MASTER_CLEAR", 5);
        ScoreTable.put("android.permission.MEDIA_CONTENT_CONTROL", 5);
        ScoreTable.put("android.permission.MODIFY_AUDIO_SETTINGS", 2);
        ScoreTable.put("android.permission.MODIFY_PHONE_STATE", 5);
        ScoreTable.put("android.permission.MOUNT_FORMAT_FILESYSTEMS", 5);
        ScoreTable.put("android.permission.MOUNT_UNMOUNT_FILESYSTEMS", 10);
        //NNN 1
        ScoreTable.put("android.permission.NFC", 2);
        //PPP 3
        ScoreTable.put("android.permission.PACKAGE_USAGE_STATS", 5);
        ScoreTable.put("android.permission.PERSISTENT_ACTIVITY", 5);
        ScoreTable.put("android.permission.PROCESS_OUTGOING_CALLS", 10);
        //RRR 22
        ScoreTable.put("android.permission.READ_CALENDAR", 8);
        ScoreTable.put("android.permission.READ_CALL_LOG", 8);
        ScoreTable.put("android.permission.READ_CONTACTS", 8);
        ScoreTable.put("android.permission.READ_EXTERNAL_STORAGE", 8);
        ScoreTable.put("android.permission.READ_FRAME_BUFFER", 5);
        ScoreTable.put("android.permission.READ_INPUT_STATE", 5);
        ScoreTable.put("android.permission.READ_LOGS", 10);
        ScoreTable.put("android.permission.READ_PHONE_STATE", 8);
        ScoreTable.put("android.permission.READ_SMS", 10);
        ScoreTable.put("android.permission.READ_SYNC_SETTINGS", 2);
        ScoreTable.put("android.permission.READ_SYNC_STATS", 2);
        ScoreTable.put("android.permission.READ_VOICEMAIL", 5);
        ScoreTable.put("android.permission.REBOOT", 5);
        ScoreTable.put("android.permission.RECEIVE_BOOT_COMPLETED", 2);
        ScoreTable.put("android.permission.RECEIVE_MMS", 10);
        ScoreTable.put("android.permission.RECEIVE_SMS", 10);
        ScoreTable.put("android.permission.RECEIVE_WAP_PUSH", 10);
        ScoreTable.put("android.permission.RECORD_AUDIO", 8);
        ScoreTable.put("android.permission.REORDER_TASKS", 2);
        ScoreTable.put("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", 2);
        ScoreTable.put("android.permission.REQUEST_INSTALL_PACKAGES", 2);
        ScoreTable.put("android.permission.RESTART_PACKAGES", 5);
        //SSS 15
        ScoreTable.put("android.permission.SEND_RESPOND_VIA_MESSAGE", 5);
        ScoreTable.put("android.permission.SEND_SMS", 10);
        ScoreTable.put("android.permission.SET_ALARM", 2);
        ScoreTable.put("android.permission.SET_ALWAYS_FINISH", 2);
        ScoreTable.put("android.permission.SET_ANIMATION_SCALE", 2);
        ScoreTable.put("android.permission.SET_DEBUG_APP", 2);
        ScoreTable.put("android.permission.SET_PREFERRED_APPLICATIONS", 2);
        ScoreTable.put("android.permission.SET_PROCESS_LIMIT", 2);
        ScoreTable.put("android.permission.SET_TIME", 2);
        ScoreTable.put("android.permission.SET_TIME_ZONE", 2);
        ScoreTable.put("android.permission.SET_WALLPAPER", 2);
        ScoreTable.put("android.permission.SET_WALLPAPER_HINTS", 10);
        ScoreTable.put("android.permission.SIGNAL_PERSISTENT_PROCESSES", 2);
        ScoreTable.put("android.permission.STATUS_BAR", 2);
        ScoreTable.put("android.permission.SYSTEM_ALERT_WINDOW", 2);
        //TTT 1
        ScoreTable.put("android.permission.TRANSMIT_IR", 2);
        //UUU 4
        ScoreTable.put("android.permission.UNINSTALL_SHORTCUT", 2);
        ScoreTable.put("android.permission.UPDATE_DEVICE_STATS", 2);
        ScoreTable.put("android.permission.USE_FINGERPRINT", 2);
        ScoreTable.put("android.permission.USE_SIP", 8);
        //VVV 1
        ScoreTable.put("android.permission.VIBRATE", 2);
        //WWW 11
        ScoreTable.put("android.permission.WAKE_LOCK", 2);
        ScoreTable.put("android.permission.WRITE_APN_SETTINGS", 10);
        ScoreTable.put("android.permission.WRITE_CALENDAR", 8);
        ScoreTable.put("android.permission.WRITE_CALL_LOG", 8);
        ScoreTable.put("android.permission.WRITE_CONTACTS", 10);
        ScoreTable.put("android.permission.WRITE_EXTERNAL_STORAGE", 8);
        ScoreTable.put("android.permission.WRITE_GSERVICES", 5);
        ScoreTable.put("android.permission.WRITE_SECURE_SETTINGS", 5);
        ScoreTable.put("android.permission.WRITE_SETTINGS", 5);
        ScoreTable.put("android.permission.WRITE_SYNC_SETTINGS", 2);
        ScoreTable.put("android.permission.WRITE_VOICEMAIL", 5);
        ScoreTable.put("android.permission.WRITE_SMS", 10);
        //
        ScoreTable.put("不需要任何權限,Good!", 0);
    }
}
