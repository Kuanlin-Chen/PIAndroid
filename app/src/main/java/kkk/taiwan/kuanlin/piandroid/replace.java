package kkk.taiwan.kuanlin.piandroid;

import android.provider.Settings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuanlin on 2016/5/16.
 */
public class replace extends intent {

    static int size = splitlog.length;
    static String word = null;
    static String action = null;
    static String datetime = null;

    public static void replace() {

        for (int i = 0; i < size; i++) {

            word = splitlog[i].toString();
            String[] tmp;
            tmp = splitlog[i].toString().split(" ");
            datetime = "日期 "+tmp[0].toString()+" 時間 "+tmp[1].toString()+"\n";

            //Standard Activity Actions
            if(word.contains("android.intent.action.MAIN")){
                action = "從主要入口開始";
            }
            else if(word.contains("android.intent.action.VIEW")){
                action = "展示資料給使用者";
            }
            else if(word.contains("android.intent.action.ATTACH_DATA")) {
                action = "用來表示某資料該被哪個地方附帶";
            }
            else if(word.contains("android.intent.action.EDIT")) {
                action = "提供可編輯的權限";
            }
            else if(word.contains("android.intent.action.PICK")){
                action = "從資料中挑出項目並回傳";
            }
            else if(word.contains("android.intent.action.CHOOSER")) {
                action = "顯示活動選擇器，允許使用者選擇";
            }
            else if(word.contains("android.intent.action.GET_CONTENT")) {
                action = "允許使用者選擇特定種類的資料並回傳";
            }
            else if(word.contains("android.intent.action.DIAL")) {
                action = "撥號";
            }
            else if(word.contains("android.intent.action.CALL")) {
                action = "實現通話";
            }
            else if(word.contains("android.intent.action.SEND")) {
                action = "傳遞資料給其他人";
            }
            else if(word.contains("android.intent.action.SENDTO")){
                action = "傳遞訊息給資料指定的人";
            }
            else if(word.contains("android.intent.action.ANSWER")) {
                action = "處理來電";
            }
            else if(word.contains("android.intent.action.INSERT")){
                action = "插入一個空項目給容器(Container)";
            }
            else if(word.contains("android.intent.action.DELETE")) {
                action = "刪除容器(Container)給的資料";
            }
            else if(word.contains("android.intent.action.RUN")){
                action = "運行資料";
            }
            else if(word.contains("android.intent.action.SYNC")){
                action = "實現資料同步化";
            }
            else if(word.contains("android.intent.action.PICK_ACTIVITY")){
                action = "挑選一個Activity給Intent並回傳";
            }
            else if(word.contains("android.intent.action.SEARCH")){
                action = "實現搜尋";
            }
            else if(word.contains("android.intent.action.WEB_SEARCH")){
                action = "實現Web搜尋";
            }
            else if(word.contains("android.intent.action.FACTORY_TEST")) {
                action = "開啟工廠測試主要入口";
            }
            //Standard Broadcast Actions
            else if(word.contains("android.intent.action.TIME_TICK")){
                action = "最近的時間已改變";
            }
            else if(word.contains("android.intent.action.TIME_SET")){
                action = "時間已設定";
            }
            else if(word.contains("android.intent.action.TIMEZONE_CHANGED")){
                action = "時區已改變";
            }
            else if(word.contains("android.intent.action.BOOT_COMPLETED")) {
                action = "廣播系統已完成開機的訊息";
            }
            else if(word.contains("android.intent.action.PACKAGE_ADDED")) {
                action = "一個已存在的Package已經被安裝";
            }
            else if(word.contains("android.intent.action.PACKAGE_CHANGED")) {
                action = "正在更改Package";
            }
            else if(word.contains("android.intent.action.PACKAGE_REMOVED")) {
                action = "一個已存在的Package已經被移除";
            }
            else if(word.contains("android.intent.action.PACKAGE_RESTARTED")){
                action = "使用者重開Package且所有程序已中斷";
            }
            else if(word.contains("android.intent.action.PACKAGE_DATA_CLEARED")){
                action = "使用者已清除Package的資料";
            }
            else if(word.contains("android.intent.action.UID_REMOVED")){
                action = "使用者ID已從系統被移除";
            }
            else if(word.contains("android.intent.action.BATTERY_CHANGED")) {
                action = "廣播電池的狀態,層級,和其他資訊";
            }
            else if(word.contains("android.intent.action.ACTION_POWER_CONNECTED")){
                action = "外部電源已連接至裝置";
            }
            else if(word.contains("android.intent.action.ACTION_POWER_DISCONNECTED")){
                action = "外部電源已拔除";
            }
            else if(word.contains("android.intent.action.ACTION_SHUTDOWN")){
                action = "裝置正在關閉";
            }

            //額外的Intent翻譯
            //AAAAA
            else if(word.contains("android.intent.action.AIRPLANE_MODE")) {
                action = "使用者開啟或關閉手機飛航模式";
            }
            else if(word.contains("android.intent.action.ALL_APPS")) {
                action = "列出所有可取得之應用程式";
            }
            else if(word.contains("android.intent.action.APPLICATION_RESTRICTIONS_CHANGED")) {
                action = "應用程式的限制已改變";
            }
            else if(word.contains("android.intent.action.APP_ERROR")) {
                action = "回傳應用程式Crash資訊給Google Play";
            }
            else if(word.contains("android.intent.action.ASSIST")) {
                action = "實現協助動作";
            }
            //BBBBB
            else if(word.contains("android.intent.action.BATTERY_LOW")) {
                action = "表示裝置電量過低";
            }
            else if(word.contains("android.intent.action.BATTERY_OKAY")) {
                action = "表示裝置電量已從過低恢復至正常";
            }
            else if(word.contains("android.intent.action.BUG_REPORT")) {
                action = "顯示回傳Bug的活動";
            }
            //CCCCC
            else if(word.contains("android.intent.action.CALL_BUTTON")) {
                action = "使用者按下[通話]鍵";
            }
            else if(word.contains("android.intent.action.CAMERA_BUTTON")) {
                action = "使用者按下[拍照]鍵";
            }
            else if(word.contains("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                action = "使用者關閉對話視窗(Dialog)時顯示廣播";
            }
            else if(word.contains("android.intent.action.CONFIGURATION_CHANGED")) {
                action = "最近裝置的組態設定已改變";
            }
            else if(word.contains("android.intent.action.CREATE_DOCUMENT")) {
                action = "允許使用者創建新文件";
            }
            else if(word.contains("android.intent.action.CREATE_SHORTCUT")) {
                action = "創建一個捷徑";
            }
            //DDDDD
            else if(word.contains("android.intent.action.DATE_CHANGED")) {
                action = "資料已改變";
            }
            else if(word.contains("android.intent.action.DEFAULT")) {
                action = "展示資料給使用者";
            }
            else if(word.contains("android.intent.action.DEVICE_STORAGE_LOW")) {
                action = "表示裝置的記憶體不夠用";
            }
            else if(word.contains("android.intent.action.DEVICE_STORAGE_OK")) {
                action = "表示裝置的記憶體已從不夠用恢復至正常";
            }
            else if(word.contains("android.intent.action.DOCK_EVENT")) {
                action = "廣播裝置的實體埠口連接狀態";
            }
            else if(word.contains("android.intent.action.DREAMING_STARTED")) {
                action = "系統開始Dreaming";
            }
            else if(word.contains("android.intent.action.DREAMING_STOPPED")) {
                action = "系統停止Dreaming";
            }
            //EEEEE
            else if(word.contains("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE")) {
                action = "開放部份資源可被取得";
            }
            else if(word.contains("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE")) {
                action = "部份資源不可被取得";
            }
            //GGGGG
            else if(word.contains("android.intent.action.GET_RESTRICTION_ENTRIES")) {
                action = "廣播限制給特定應用程式並加在受限制的使用者";
            }
            else if(word.contains("android.intent.action.GTALK_CONNECTED")) {
                action = "GTalk連線已建立";
            }
            else if(word.contains("android.intent.action.GTALK_DISCONNECTED")) {
                action = "GTalk連線已中斷";
            }
            //PPPPP
            else if(word.contains("android.intent.action.PACKAGE_REPLACED")) {
                action = "新版本取代原有版本";
            }
            else{
                action = "未知";
            }
            //合併
            splitlog[i] = datetime + action;
        }
    }
}
