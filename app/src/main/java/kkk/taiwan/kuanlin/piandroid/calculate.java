package kkk.taiwan.kuanlin.piandroid;

/**
 * Created by kuanlin on 2016/3/7.
 */
public class calculate extends MainActivity
{
    public static double calculatescore()
    {
        int size = group_permission.length; //樣本數
        int custom = 0; //不計算custom permission
        double avg_score = 0; //最後平均分數
        String word = null;

        double assessment_score = 0; //計算 一般 簽章 系統權限 分數
        double dangerous_score = 0;  //計算 危險權限 分數
        int dangerous_permission = 0; //危險權限數量
        double weights = 1; //權重
        //MainActivity.per_number += size;
        //MainActivity.apps_number += 1;

        for(int i = 0; i < size; i++)
        {
            word = group_permission[i].toString();

            switch (word)
            {
                case "android.permission.ACCESS_CHECKIN_PROPERTIES":
                    assessment_score += 5;
                    break;
                case "android.permission.ACCESS_COARSE_LOCATION":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.ACCESS_FINE_LOCATION":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS":
                    assessment_score += 2;
                    break;
                case "android.permission.ACCESS_NETWORK_STATE":
                    assessment_score += 2;
                    break;
                case "android.permission.ACCESS_NOTIFICATION_POLICY":
                    assessment_score += 2;
                    break;
                case "android.permission.ACCESS_WIFI_STATE":
                    assessment_score += 2;
                    break;
                case "android.permission.ACCOUNT_MANAGER":
                    assessment_score += 5;
                    break;
                case "android.permission.ADD_VOICEMAIL":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.BATTERY_STATS":
                    assessment_score += 2;
                    break;
                case "android.permission.BIND_ACCESSIBILITY_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_APPWIDGET":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_CARRIER_MESSAGING_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_CARRIER_SERVICES":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_CHOOSER_TARGET_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_DEVICE_ADMIN":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_DREAM_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_INCALL_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_INPUT_METHOD":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_MIDI_DEVICE_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_NFC_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_PRINT_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_REMOTEVIEWSE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_TELECOM_CONNECTION_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_TEXT_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_TV_INPUT":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_VOICE_INTERACTION":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_VPN_SERVICE":
                    assessment_score += 5;
                    break;
                case "android.permission.BIND_WALLPAPER":
                    assessment_score += 5;
                    break;
                case "android.permission.BLUETOOTH":
                    assessment_score += 2;
                    break;
                case "android.permission.BLUETOOTH_ADMIN":
                    assessment_score += 2;
                    break;
                case "android.permission.BLUETOOTH_PRIVILEGED":
                    assessment_score += 5;
                    break;
                case "android.permission.BODY_SENSORS":
                    assessment_score += 5;
                    break;
                case "android.permission.BROADCAST_PACKAGE_REMOVED": //20
                    assessment_score += 10;
                    break;
                case "android.permission.BROADCAST_SMS":
                    assessment_score += 5;
                    break;
                case "android.permission.BROADCAST_STICKY":
                    assessment_score += 2;
                    break;
                case "android.permission.BROADCAST_WAP_PUSH":
                    assessment_score += 5;
                    break;
                case "android.permission.CALL_PHONE": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.CALL_PRIVILEGED":
                    assessment_score += 5;
                    break;
                case "android.permission.CAMERA":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.CAPTURE_AUDIO_OUTPUT":
                    assessment_score += 5;
                    break;
                case "android.permission.CAPTURE_SECURE_VIDEO_OUTPUT":
                    assessment_score += 5;
                    break;
                case "android.permission.CAPTURE_VIDEO_OUTPUT":
                    assessment_score += 5;
                    break;
                case "android.permission.CHANGE_COMPONENT_ENABLED_STATE":
                    assessment_score += 5;
                    break;
                case "android.permission.CHANGE_CONFIGURATION":
                    assessment_score += 5;
                    break;
                case "android.permission.CHANGE_NETWORK_STATE":
                    assessment_score += 2;
                    break;
                case "android.permission.CHANGE_WIFI_MULTICAST_STATE":
                    assessment_score += 2;
                    break;
                case "android.permission.CHANGE_WIFI_STATE": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.CLEAR_APP_CACHE":
                    assessment_score += 5;
                    break;
                case "android.permission.CONTROL_LOCATION_UPDATES":
                    assessment_score += 5;
                    break;
                case "android.permission.DELETE_CACHE_FILES":
                    assessment_score += 5;
                    break;
                case "android.permission.DELETE_PACKAGES": //20
                    assessment_score += 10;
                    break;
                case "android.permission.DIAGNOSTIC":
                    assessment_score += 5;
                    break;
                case "android.permission.DISABLE_KEYGUARD": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.DUMP":
                    assessment_score += 5;
                    break;
                case "android.permission.EXPAND_STATUS_BAR": //20
                    assessment_score += 10;
                    break;
                case "android.permission.FACTORY_TEST":
                    assessment_score += 5;
                    break;
                case "android.permission.FLASHLIGHT":
                    assessment_score += 2;
                    break;
                case "android.permission.GET_ACCOUNTS":
                    assessment_score += 2;
                    break;
                case "android.permission.GET_ACCOUNTS_PRIVILEGED":
                    assessment_score += 2;
                    break;
                case "android.permission.GET_PACKAGE_SIZE":
                    assessment_score += 2;
                    break;
                case "android.permission.GET_TASKS":
                    assessment_score += 5;
                    break;
                case "android.permission.GLOBAL_SEARCH":
                    assessment_score += 5;
                    break;
                case "android.permission.INSTALL_LOCATION_PROVIDER":
                    assessment_score += 5;
                    break;
                case "android.permission.INSTALL_PACKAGES": //20
                    assessment_score += 10;
                    break;
                case "android.permission.INSTALL_SHORTCUT":
                    assessment_score += 2;
                    break;
                case "android.permission.INTERNET":
                    assessment_score += 2;
                    break;
                case "android.permission.KILL_BACKGROUND_PROCESSES": //20
                    assessment_score += 10;
                    break;
                case "android.permission.LOCATION_HARDWARE":
                    assessment_score += 5;
                    break;
                case "android.permission.MANAGE_DOCUMENTS":
                    assessment_score += 5;
                    break;
                case "android.permission.MASTER_CLEAR":
                    assessment_score += 5;
                    break;
                case "android.permission.MEDIA_CONTENT_CONTROL":
                    assessment_score += 5;
                    break;
                case "android.permission.MODIFY_AUDIO_SETTINGS":
                    assessment_score += 2;
                    break;
                case "android.permission.MODIFY_PHONE_STATE":
                    assessment_score += 5;
                    break;
                case "android.permission.MOUNT_FORMAT_FILESYSTEMS":
                    assessment_score += 5;
                    break;
                case "android.permission.MOUNT_UNMOUNT_FILESYSTEMS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.NFC":
                    assessment_score += 2;
                    break;
                case "android.permission.PACKAGE_USAGE_STATS":
                    assessment_score += 5;
                    break;
                case "android.permission.PERSISTENT_ACTIVITY":
                    assessment_score += 5;
                    break;
                case "android.permission.PROCESS_OUTGOING_CALLS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.READ_CALENDAR":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.READ_CALL_LOG":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.READ_CONTACTS":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.READ_EXTERNAL_STORAGE":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.READ_FRAME_BUFFER":
                    assessment_score += 5;
                    break;
                case "android.permission.READ_INPUT_STATE":
                    assessment_score += 5;
                    break;
                case "android.permission.READ_LOGS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.READ_PHONE_STATE":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.READ_SMS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.READ_SYNC_SETTINGS":
                    assessment_score += 2;
                    break;
                case "android.permission.READ_SYNC_STATS":
                    assessment_score += 2;
                    break;
                case "android.permission.READ_VOICEMAIL":
                    assessment_score += 5;
                    break;
                case "android.permission.REBOOT":
                    assessment_score += 5;
                    break;
                case "android.permission.RECEIVE_BOOT_COMPLETED":
                    assessment_score += 2;
                    break;
                case "android.permission.RECEIVE_MMS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.RECEIVE_SMS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.RECEIVE_WAP_PUSH": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.RECORD_AUDIO":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.REORDER_TASKS":
                    assessment_score += 2;
                    break;
                case "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS":
                    assessment_score += 2;
                    break;
                case "android.permission.REQUEST_INSTALL_PACKAGES":
                    assessment_score += 2;
                    break;
                case "android.permission.RESTART_PACKAGES":
                    assessment_score += 5;
                    break;
                case "android.permission.SEND_RESPOND_VIA_MESSAGE":
                    assessment_score += 5;
                    break;
                case "android.permission.SEND_SMS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.SET_ALARM":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_ALWAYS_FINISH":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_ANIMATION_SCALE":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_DEBUG_APP":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_PREFERRED_APPLICATIONS":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_PROCESS_LIMIT":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_TIME":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_TIME_ZONE":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_WALLPAPER":
                    assessment_score += 2;
                    break;
                case "android.permission.SET_WALLPAPER_HINTS": //20
                    assessment_score += 10;
                    break;
                case "android.permission.SIGNAL_PERSISTENT_PROCESSES":
                    assessment_score += 2;
                    break;
                case "android.permission.STATUS_BAR":
                    assessment_score += 2;
                    break;
                case "android.permission.SYSTEM_ALERT_WINDOW":
                    assessment_score += 2;
                    break;
                case "android.permission.TRANSMIT_IR":
                    assessment_score += 2;
                    break;
                case "android.permission.UNINSTALL_SHORTCUT":
                    assessment_score += 2;
                    break;
                case "android.permission.UPDATE_DEVICE_STATS":
                    assessment_score += 2;
                    break;
                case "android.permission.USE_FINGERPRINT":
                    assessment_score += 2;
                    break;
                case "android.permission.USE_SIP":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.VIBRATE":
                    assessment_score += 2;
                    break;
                case "android.permission.WAKE_LOCK":
                    assessment_score += 2;
                    break;
                case "android.permission.WRITE_APN_SETTINGS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.WRITE_CALENDAR":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.WRITE_CALL_LOG":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.WRITE_CONTACTS": //20
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;
                case "android.permission.WRITE_EXTERNAL_STORAGE":
                    dangerous_score += 8;
                    dangerous_permission += 1;
                    break;
                case "android.permission.WRITE_GSERVICES":
                    assessment_score += 5;
                    break;
                case "android.permission.WRITE_SECURE_SETTINGS":
                    assessment_score += 5;
                    break;
                case "android.permission.WRITE_SETTINGS":
                    assessment_score += 5;
                    break;
                case "android.permission.WRITE_SYNC_SETTINGS":
                    assessment_score += 2;
                    break;
                case "android.permission.WRITE_VOICEMAIL":
                    assessment_score += 5;
                    break;
                case "android.permission.WRITE_SMS": //新增
                    dangerous_score += 10;
                    dangerous_permission += 1;
                    break;

                case "不需要任何權限,Good!":
                    assessment_score += 0;
                    break;

                default:
                    assessment_score += 8;
                    custom +=1;
                    break;
            }
        }


        if(dangerous_permission>=7) {
            weights = 1;
            //size += dangerous_permission;
        }

        if(assessment_score+dangerous_score==0)
        {
            //若全是custompermission,算式會出現0除以0
            //Invalid"非數值"
            avg_score = 0;
        }else{
            avg_score = ((assessment_score+dangerous_score)*weights)/(size);
        }
        return avg_score;
    }
}
