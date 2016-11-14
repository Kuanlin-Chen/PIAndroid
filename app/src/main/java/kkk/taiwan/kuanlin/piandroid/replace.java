package kkk.taiwan.kuanlin.piandroid;

/**
 * Created by kuanlin on 2016/3/10.
 */
public class replace extends permission{

    public static void replacestring()
    {
        int size = group.length;
        String word = null;

        for(int i = 0; i < size; i++)
        {
            word = group[i].toString();

            switch (word)
            {
                case "android.permission.ACCESS_CHECKIN_PROPERTIES":
                    group[i] = group[i].replace("android.permission.ACCESS_CHECKIN_PROPERTIES", "存取登入資料");
                    break;
                case "android.permission.ACCESS_COARSE_LOCATION":
                    group[i] = group[i].replace("android.permission.ACCESS_COARSE_LOCATION", "存取概略位置");
                    break;
                case "android.permission.ACCESS_FINE_LOCATION":
                    group[i] = group[i].replace("android.permission.ACCESS_FINE_LOCATION", "存取精確位置");
                    break;
                case "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS":
                    group[i] = group[i].replace("android.permission.ACCESS_LOCATION_EXTRA_COMMANDS", "允許其他命令存取位置");
                    break;
                case "android.permission.ACCESS_NETWORK_STATE":
                    group[i] = group[i].replace("android.permission.ACCESS_NETWORK_STATE", "檢視網路狀態");
                    break;
                case "android.permission.ACCESS_NOTIFICATION_POLICY":
                    group[i] = group[i].replace("android.permission.ACCESS_NOTIFICATION_POLICY", "存取警告資訊");
                    break;
                case "android.permission.ACCESS_WIFI_STATE":
                    group[i] = group[i].replace("android.permission.ACCESS_WIFI_STATE", "檢視無線網路(Wi-Fi)資訊");
                    break;
                case "android.permission.ACCOUNT_MANAGER":
                    group[i] = group[i].replace("android.permission.ACCOUNT_MANAGER", "使用帳號管理員");
                    break;
                case "android.permission.ADD_VOICEMAIL":
                    group[i] = group[i].replace("android.permission.ADD_VOICEMAIL", "加入語音信箱");
                    break;
                case "android.permission.BATTERY_STATS":
                    group[i] = group[i].replace("android.permission.BATTERY_STATS", "讀取電池統計資料");
                    break;
                case "android.permission.BIND_ACCESSIBILITY_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_ACCESSIBILITY_SERVICE", "連結無障礙服務,需被AccessibilityService呼叫");
                    break;
                case "android.permission.BIND_APPWIDGET":
                    group[i] = group[i].replace("android.permission.BIND_APPWIDGET", "通知哪些應用程式可存取App小工具資訊");
                    break;
                case "android.permission.BIND_CARRIER_MESSAGING_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_CARRIER_MESSAGING_SERVICE", "系統允許廠商APP擁有權限連結至訊息服務,API 23 已棄用");
                    break;
                case "android.permission.BIND_CARRIER_SERVICES":
                    group[i] = group[i].replace("android.permission.BIND_CARRIER_SERVICES", "系統允許廠商APP擁有權限連結至服務");
                    break;
                case "android.permission.BIND_CHOOSER_TARGET_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_CHOOSER_TARGET_SERVICE", "選擇目標服務,需被ChooserTargetService呼叫");
                    break;
                case "android.permission.BIND_DEVICE_ADMIN":
                    group[i] = group[i].replace("android.permission.BIND_DEVICE_ADMIN", "連結裝置管理員,需被Device administration呼叫");
                    break;
                case "android.permission.BIND_DREAM_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_DREAM_SERVICE", "連結夢想服務,需被DreamService呼叫");
                    break;
                case "android.permission.BIND_INCALL_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_INCALL_SERVICE", "連結INCALL服務,需被InCallService呼叫");
                    break;
                case "android.permission.BIND_INPUT_METHOD":
                    group[i] = group[i].replace("android.permission.BIND_INPUT_METHOD", "連結輸入方法,需被InputMethodService呼叫");
                    break;
                case "android.permission.BIND_MIDI_DEVICE_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_MIDI_DEVICE_SERVICE", "連結MIDI裝置服務,需被MidiDeviceService呼叫");
                    break;
                case "android.permission.BIND_NFC_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_NFC_SERVICE", "連結NFC服務,需被HostApduService或OffHostApduService呼叫");
                    break;
                case "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_NOTIFICATION_LISTENER_SERVICE", "連結通知監聽器服務,需被NotificationListenerService呼叫");
                    break;
                case "android.permission.BIND_PRINT_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_PRINT_SERVICE", "連結印刷服務,需被PrintService呼叫");
                    break;
                case "android.permission.BIND_REMOTEVIEWSE":
                    group[i] = group[i].replace("android.permission.BIND_REMOTEVIEWSE", "連結遠端視圖服務,需被RemoteViewsService呼叫");
                    break;
                case "android.permission.BIND_TELECOM_CONNECTION_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_TELECOM_CONNECTION_SERVICE", "連結電信連結服務,需被ConnectionService呼叫");
                    break;
                case "android.permission.BIND_TEXT_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_TEXT_SERVICE", "連結文本服務,需被TextService呼叫");
                    break;
                case "android.permission.BIND_TV_INPUT":
                    group[i] = group[i].replace("android.permission.BIND_TV_INPUT", "連結TV輸入服務,需被TvInputService呼叫");
                    break;
                case "android.permission.BIND_VOICE_INTERACTION":
                    group[i] = group[i].replace("android.permission.BIND_VOICE_INTERACTION", "連結語音互動服務,需被VoiceInteractionService呼叫");
                    break;
                case "android.permission.BIND_VPN_SERVICE":
                    group[i] = group[i].replace("android.permission.BIND_VPN_SERVICE", "連結VPN服務,需被VpnService呼叫");
                    break;
                case "android.permission.BIND_WALLPAPER":
                    group[i] = group[i].replace("android.permission.BIND_WALLPAPER", "連結桌布,需被WallpaperService呼叫");
                    break;
                case "android.permission.BLUETOOTH":
                    group[i] = group[i].replace("android.permission.BLUETOOTH", "連結已配對的藍牙裝置");
                    break;
                case "android.permission.BLUETOOTH_ADMIN":
                    group[i] = group[i].replace("android.permission.BLUETOOTH_ADMIN", "尋找和配對藍牙裝置");
                    break;
                case "android.permission.BLUETOOTH_PRIVILEGED":
                    group[i] = group[i].replace("android.permission.BLUETOOTH_PRIVILEGED", "不經過使用者配對藍牙裝置,且允許存取電話簿與簡訊");
                    break;
                case "android.permission.BODY_SENSORS":
                    group[i] = group[i].replace("android.permission.BODY_SENSORS", "從感測器存取使用者資料,例如：心跳");
                    break;
                case "android.permission.BROADCAST_PACKAGE_REMOVED":
                    group[i] = group[i].replace("android.permission.BROADCAST_PACKAGE_REMOVED", "廣播應用程式已被移除的訊息");
                    break;
                case "android.permission.BROADCAST_SMS":
                    group[i] = group[i].replace("android.permission.BROADCAST_SMS", "廣播簡訊收據");
                    break;
                case "android.permission.BROADCAST_STICKY":
                    group[i] = group[i].replace("android.permission.BROADCAST_STICKY", "廣播Sticky意圖");
                    break;
                case "android.permission.BROADCAST_WAP_PUSH":
                    group[i] = group[i].replace("android.permission.BROADCAST_WAP_PUSH", "廣播WAP_PUSH收據通知");
                    break;
                case "android.permission.CALL_PHONE":
                    group[i] = group[i].replace("android.permission.CALL_PHONE", "不經過使用者確認開啟電話");
                    break;
                case "android.permission.CALL_PRIVILEGED":
                    group[i] = group[i].replace("android.permission.CALL_PRIVILEGED", "不經過使用者確認呼叫電話號碼,包括緊急號碼");
                    break;
                case "android.permission.CAMERA":
                    group[i] = group[i].replace("android.permission.CAMERA", "取得照相功能");
                    break;
                case "android.permission.CAPTURE_AUDIO_OUTPUT":
                    group[i] = group[i].replace("android.permission.CAPTURE_AUDIO_OUTPUT", "擷取音頻輸出");
                    break;
                case "android.permission.CAPTURE_SECURE_VIDEO_OUTPUT":
                    group[i] = group[i].replace("android.permission.CAPTURE_SECURE_VIDEO_OUTPUT", "擷取安全影像輸出");
                    break;
                case "android.permission.CAPTURE_VIDEO_OUTPUT":
                    group[i] = group[i].replace("android.permission.CAPTURE_VIDEO_OUTPUT", "擷取影像輸出");
                    break;
                case "android.permission.CHANGE_COMPONENT_ENABLED_STATE":
                    group[i] = group[i].replace("android.permission.CHANGE_COMPONENT_ENABLED_STATE", "改變應用程式元件開啟狀態");
                    break;
                case "android.permission.CHANGE_CONFIGURATION":
                    group[i] = group[i].replace("android.permission.CHANGE_CONFIGURATION", "修改最近的設定,例如：語言環境");
                    break;
                case "android.permission.CHANGE_NETWORK_STATE":
                    group[i] = group[i].replace("android.permission.CHANGE_NETWORK_STATE", "改變網路連線狀態");
                    break;
                case "android.permission.CHANGE_WIFI_MULTICAST_STATE":
                    group[i] = group[i].replace("android.permission.CHANGE_WIFI_MULTICAST_STATE", "進入無線網路(Wi-Fi)Multicast模式");
                    break;
                case "android.permission.CHANGE_WIFI_STATE":
                    group[i] = group[i].replace("android.permission.CHANGE_WIFI_STATE", "改變無線網路(Wi-Fi)連線狀態");
                    break;
                case "android.permission.CLEAR_APP_CACHE":
                    group[i] = group[i].replace("android.permission.CLEAR_APP_CACHE", "清空裝置上應用程式的快取(cache)");
                    break;
                case "android.permission.CONTROL_LOCATION_UPDATES":
                    group[i] = group[i].replace("android.permission.CONTROL_LOCATION_UPDATES", "從無線電開啟/關閉位置更新通知");
                    break;
                case "android.permission.DELETE_CACHE_FILES":
                    group[i] = group[i].replace("android.permission.DELETE_CACHE_FILES", "刪除快取(cache)檔案");
                    break;
                case "android.permission.DELETE_PACKAGES":
                    group[i] = group[i].replace("android.permission.DELETE_PACKAGES", "刪除Package(系統權限)");
                    break;
                case "android.permission.DIAGNOSTIC":
                    group[i] = group[i].replace("android.permission.DIAGNOSTIC", "診斷資源(系統權限)");
                    break;
                case "android.permission.DISABLE_KEYGUARD":
                    group[i] = group[i].replace("android.permission.DISABLE_KEYGUARD", "關閉鍵盤保護");
                    break;
                case "android.permission.DUMP":
                    group[i] = group[i].replace("android.permission.DUMP", "從系統服務Dump資訊(系統權限)");
                    break;
                case "android.permission.EXPAND_STATUS_BAR":
                    group[i] = group[i].replace("android.permission.EXPAND_STATUS_BAR", "擴充/縮減狀態列");
                    break;
                case "android.permission.FACTORY_TEST":
                    group[i] = group[i].replace("android.permission.FACTORY_TEST", "以廠商身份測試應用程式,以root身份執行程式");
                    break;
                case "android.permission.FLASHLIGHT":
                    group[i] = group[i].replace("android.permission.FLASHLIGHT", "存取手電筒");
                    break;
                case "android.permission.GET_ACCOUNTS":
                    group[i] = group[i].replace("android.permission.GET_ACCOUNTS", "從帳戶服務存取帳戶清單");
                    break;
                case "android.permission.GET_ACCOUNTS_PRIVILEGED":
                    group[i] = group[i].replace("android.permission.GET_ACCOUNTS_PRIVILEGED", "從帳戶服務存取帳戶清單");
                    break;
                case "android.permission.GET_PACKAGE_SIZE":
                    group[i] = group[i].replace("android.permission.GET_PACKAGE_SIZE", "尋找Package使用的空間");
                    break;
                case "android.permission.GET_TASKS":
                    group[i] = group[i].replace("android.permission.GET_TASKS", "取得任務,API 21 已棄用");
                    break;
                case "android.permission.GLOBAL_SEARCH":
                    group[i] = group[i].replace("android.permission.GLOBAL_SEARCH", "允許全球搜尋系統透過content provider存取他們的資料");
                    break;
                case "android.permission.INSTALL_LOCATION_PROVIDER":
                    group[i] = group[i].replace("android.permission.INSTALL_LOCATION_PROVIDER", "在位置管理員安裝位置提供器");
                    break;
                case "android.permission.INSTALL_PACKAGES":
                    group[i] = group[i].replace("android.permission.INSTALL_PACKAGES", "安裝Package(系統權限)");
                    break;
                case "android.permission.INSTALL_SHORTCUT":
                    group[i] = group[i].replace("android.permission.INSTALL_SHORTCUT", "安裝捷徑在主畫面");
                    break;
                case "android.permission.INTERNET":
                    group[i] = group[i].replace("android.permission.INTERNET", "開啟網路通道");
                    break;
                case "android.permission.KILL_BACKGROUND_PROCESSES":
                    group[i] = group[i].replace("android.permission.KILL_BACKGROUND_PROCESSES", "允許呼叫killBackgroundProcesses");
                    break;
                case "android.permission.LOCATION_HARDWARE":
                    group[i] = group[i].replace("android.permission.LOCATION_HARDWARE", "允許使用硬體位置功能,例如：地理圍欄API");
                    break;
                case "android.permission.MANAGE_DOCUMENTS":
                    group[i] = group[i].replace("android.permission.MANAGE_DOCUMENTS", "管理文件的存取權限");
                    break;
                case "android.permission.MASTER_CLEAR":
                    group[i] = group[i].replace("android.permission.MASTER_CLEAR", "MASTER_CLEAR(系統權限)");
                    break;
                case "android.permission.MEDIA_CONTENT_CONTROL":
                    group[i] = group[i].replace("android.permission.MEDIA_CONTENT_CONTROL", "取得播放的內容和控制權");
                    break;
                case "android.permission.MODIFY_AUDIO_SETTINGS":
                    group[i] = group[i].replace("android.permission.MODIFY_AUDIO_SETTINGS", "修改音頻設定");
                    break;
                case "android.permission.MODIFY_PHONE_STATE":
                    group[i] = group[i].replace("android.permission.MODIFY_PHONE_STATE", "修改電話狀態,例如：Power On");
                    break;
                case "android.permission.MOUNT_FORMAT_FILESYSTEMS":
                    group[i] = group[i].replace("android.permission.MOUNT_FORMAT_FILESYSTEMS", "格式化可拆卸的儲存");
                    break;
                case "android.permission.MOUNT_UNMOUNT_FILESYSTEMS":
                    group[i] = group[i].replace("android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "掛載/卸載可拆卸的儲存");
                    break;
                case "android.permission.NFC":
                    group[i] = group[i].replace("android.permission.NFC", "透過NFC操作I/O");
                    break;
                case "android.permission.PACKAGE_USAGE_STATS":
                    group[i] = group[i].replace("android.permission.PACKAGE_USAGE_STATS", "蒐集元件使用統計");
                    break;
                case "android.permission.PERSISTENT_ACTIVITY":
                    group[i] = group[i].replace("android.permission.PERSISTENT_ACTIVITY", "永久活動,API 9 已棄用");
                    break;
                case "android.permission.PROCESS_OUTGOING_CALLS":
                    group[i] = group[i].replace("android.permission.PROCESS_OUTGOING_CALLS", "撥號時可查看號碼,可重新定向至不同號碼或中斷撥號");
                    break;
                case "android.permission.READ_CALENDAR":
                    group[i] = group[i].replace("android.permission.READ_CALENDAR", "讀取使用者的行事曆資料");
                    break;
                case "android.permission.READ_CALL_LOG":
                    group[i] = group[i].replace("android.permission.READ_CALL_LOG", "讀取使用者的Call Log");
                    break;
                case "android.permission.READ_CONTACTS":
                    group[i] = group[i].replace("android.permission.READ_CONTACTS", "讀取使用者的聯絡人資料");
                    break;
                case "android.permission.READ_EXTERNAL_STORAGE":
                    group[i] = group[i].replace("android.permission.READ_EXTERNAL_STORAGE", "讀取寫入外部儲存空間內容");
                    break;
                case "android.permission.READ_FRAME_BUFFER":
                    group[i] = group[i].replace("android.permission.READ_FRAME_BUFFER", "可擷取螢幕畫面,存取框架緩衝(Frame Buffer)資料");
                    break;
                case "android.permission.READ_INPUT_STATE":
                    group[i] = group[i].replace("android.permission.READ_INPUT_STATE", "讀取輸入狀態,API 16 已棄用");
                    break;
                case "android.permission.READ_LOGS":
                    group[i] = group[i].replace("android.permission.READ_LOGS", "讀取低階系統Log檔案");
                    break;
                case "android.permission.READ_PHONE_STATE":
                    group[i] = group[i].replace("android.permission.READ_PHONE_STATE", "讀取電話狀態");
                    break;
                case "android.permission.READ_SMS":
                    group[i] = group[i].replace("android.permission.READ_SMS", "讀取簡訊訊息");
                    break;
                case "android.permission.READ_SYNC_SETTINGS":
                    group[i] = group[i].replace("android.permission.READ_SYNC_SETTINGS", "讀取同步設定");
                    break;
                case "android.permission.READ_SYNC_STATS":
                    group[i] = group[i].replace("android.permission.READ_SYNC_STATS", "讀取同步狀態");
                    break;
                case "android.permission.READ_VOICEMAIL":
                    group[i] = group[i].replace("android.permission.READ_VOICEMAIL", "讀取語音郵件");
                    break;
                case "android.permission.REBOOT":
                    group[i] = group[i].replace("android.permission.REBOOT", "重開機裝置");
                    break;
                case "android.permission.RECEIVE_BOOT_COMPLETED":
                    group[i] = group[i].replace("android.permission.RECEIVE_BOOT_COMPLETED", "接收[開機已完成]的訊息");
                    break;
                case "android.permission.RECEIVE_MMS":
                    group[i] = group[i].replace("android.permission.RECEIVE_MMS", "監控進入的多媒體簡訊");
                    break;
                case "android.permission.RECEIVE_SMS":
                    group[i] = group[i].replace("android.permission.RECEIVE_SMS", "接收簡訊");
                    break;
                case "android.permission.RECEIVE_WAP_PUSH":
                    group[i] = group[i].replace("android.permission.RECEIVE_WAP_PUSH", "接收WAP PUSH訊息");
                    break;
                case "android.permission.RECORD_AUDIO":
                    group[i] = group[i].replace("android.permission.RECORD_AUDIO", "紀錄音頻");
                    break;
                case "android.permission.REORDER_TASKS":
                    group[i] = group[i].replace("android.permission.REORDER_TASKS", "改變Z-order的任務");
                    break;
                case "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS":
                    group[i] = group[i].replace("android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", "允許應用程式使用[動作要求忽略電池優化]功能");
                    break;
                case "android.permission.REQUEST_INSTALL_PACKAGES":
                    group[i] = group[i].replace("android.permission.REQUEST_INSTALL_PACKAGES", "要求安裝Packages");
                    break;
                case "android.permission.RESTART_PACKAGES":
                    group[i] = group[i].replace("android.permission.RESTART_PACKAGES", "重新啟動Packages,API 8 已棄用");
                    break;
                case "android.permission.SEND_RESPOND_VIA_MESSAGE":
                    group[i] = group[i].replace("android.permission.SEND_RESPOND_VIA_MESSAGE", "在電話近來時透過訊息傳送要求給其他應用程式");
                    break;
                case "android.permission.SEND_SMS":
                    group[i] = group[i].replace("android.permission.SEND_SMS", "傳送簡訊");
                    break;
                case "android.permission.SET_ALARM":
                    group[i] = group[i].replace("android.permission.SET_ALARM", "廣播意圖要使用者設定鬧鐘");
                    break;
                case "android.permission.SET_ALWAYS_FINISH":
                    group[i] = group[i].replace("android.permission.SET_ALWAYS_FINISH", "控制應用程式被推至背景時,會立即結束");
                    break;
                case "android.permission.SET_ANIMATION_SCALE":
                    group[i] = group[i].replace("android.permission.SET_ANIMATION_SCALE", "修改動畫縮放條件");
                    break;
                case "android.permission.SET_DEBUG_APP":
                    group[i] = group[i].replace("android.permission.SET_DEBUG_APP", "設定應用程式為除錯狀態");
                    break;
                case "android.permission.SET_PREFERRED_APPLICATIONS":
                    group[i] = group[i].replace("android.permission.SET_PREFERRED_APPLICATIONS", "設定應用程式偏好,API 7 已棄用");
                    break;
                case "android.permission.SET_PROCESS_LIMIT":
                    group[i] = group[i].replace("android.permission.SET_PROCESS_LIMIT", "設定可同時運行應用程式的最大數量");
                    break;
                case "android.permission.SET_TIME":
                    group[i] = group[i].replace("android.permission.SET_TIME", "設定系統時間");
                    break;
                case "android.permission.SET_TIME_ZONE":
                    group[i] = group[i].replace("android.permission.SET_TIME_ZONE", "設定系統時區");
                    break;
                case "android.permission.SET_WALLPAPER":
                    group[i] = group[i].replace("android.permission.SET_WALLPAPER", "設定桌布");
                    break;
                case "android.permission.SET_WALLPAPER_HINTS":
                    group[i] = group[i].replace("android.permission.SET_WALLPAPER_HINTS", "設定桌布提示");
                    break;
                case "android.permission.SIGNAL_PERSISTENT_PROCESSES":
                    group[i] = group[i].replace("android.permission.SIGNAL_PERSISTENT_PROCESSES", "要求訊號,傳送給所有的永久處理程序");
                    break;
                case "android.permission.STATUS_BAR":
                    group[i] = group[i].replace("android.permission.STATUS_BAR", "可開啟,關閉,不使用狀態列和圖標");
                    break;
                case "android.permission.SYSTEM_ALERT_WINDOW":
                    group[i] = group[i].replace("android.permission.SYSTEM_ALERT_WINDOW", "開啟視窗警報,在任何應用程式之上");
                    break;
                case "android.permission.TRANSMIT_IR":
                    group[i] = group[i].replace("android.permission.TRANSMIT_IR", "使用裝置的IR發射器");
                    break;
                case "android.permission.UNINSTALL_SHORTCUT":
                    group[i] = group[i].replace("android.permission.UNINSTALL_SHORTCUT", "解除安裝在主畫面的捷徑");
                    break;
                case "android.permission.UPDATE_DEVICE_STATS":
                    group[i] = group[i].replace("android.permission.UPDATE_DEVICE_STATS", "更新裝置的統計資料");
                    break;
                case "android.permission.USE_FINGERPRINT":
                    group[i] = group[i].replace("android.permission.USE_FINGERPRINT", "使用指紋硬體");
                    break;
                case "android.permission.USE_SIP":
                    group[i] = group[i].replace("android.permission.USE_SIP", "使用SIP服務");
                    break;
                case "android.permission.VIBRATE":
                    group[i] = group[i].replace("android.permission.VIBRATE", "存取震動");
                    break;
                case "android.permission.WAKE_LOCK":
                    group[i] = group[i].replace("android.permission.WAKE_LOCK", "使用電源管理員的喚醒鎖保持處理器持續");
                    break;
                case "android.permission.WRITE_APN_SETTINGS":
                    group[i] = group[i].replace("android.permission.WRITE_APN_SETTINGS", "寫入APN設定");
                    break;
                case "android.permission.WRITE_CALENDAR":
                    group[i] = group[i].replace("android.permission.WRITE_CALENDAR", "寫入使用者的行事曆資料");
                    break;
                case "android.permission.WRITE_CALL_LOG":
                    group[i] = group[i].replace("android.permission.WRITE_CALL_LOG", "寫入(不能讀)使用者的聯絡人資料");
                    break;
                case "android.permission.WRITE_CONTACTS":
                    group[i] = group[i].replace("android.permission.WRITE_CONTACTS", "寫入使用者的聯絡人資料");
                    break;
                case "android.permission.WRITE_EXTERNAL_STORAGE":
                    group[i] = group[i].replace("android.permission.WRITE_EXTERNAL_STORAGE", "讀取/寫入外部儲存空間內容");
                    break;
                case "android.permission.WRITE_GSERVICES":
                    group[i] = group[i].replace("android.permission.WRITE_GSERVICES", "修改Google服務地圖");
                    break;
                case "android.permission.WRITE_SECURE_SETTINGS":
                    group[i] = group[i].replace("android.permission.WRITE_SECURE_SETTINGS", "讀取/寫入安全系統設定");
                    break;
                case "android.permission.WRITE_SETTINGS":
                    group[i] = group[i].replace("android.permission.WRITE_SETTINGS", "讀取/寫入系統設定");
                    break;
                case "android.permission.WRITE_SYNC_SETTINGS":
                    group[i] = group[i].replace("android.permission.WRITE_SYNC_SETTINGS", "寫入同步設定");
                    break;
                case "android.permission.WRITE_VOICEMAIL":
                    group[i] = group[i].replace("android.permission.WRITE_VOICEMAIL", "修改或移除已存在的語音郵件");
                    break;

                case "null":
                    group[i] = group[i].replace("null", "不需要任何權限~Good!");
                    break;

                default:
                    group[i] = group[i];
                    break;
            }
        }
    }
}
