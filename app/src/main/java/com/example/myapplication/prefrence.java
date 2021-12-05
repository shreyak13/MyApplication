package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class prefrence {
    private static final String DATA_LOGIN="status_login",
    Data_AS="as";

    private  static SharedPreferences getSharedReferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);

    }
    public static void setData_AS(Context context,String data){
        SharedPreferences.Editor editor=getSharedReferences(context).edit();
        editor.putString(Data_AS,data);
        editor.apply();
    }

    public static String getData_AS(Context context){
        return getSharedReferences(context).getString(Data_AS,"");

    }
    public static void setDataLogin(Context context, boolean status){
        SharedPreferences.Editor editor=getSharedReferences(context).edit();
        editor.putBoolean(DATA_LOGIN,status);
        editor.apply();
    }
    public static boolean getDataLogin(Context context){
        return getSharedReferences(context).getBoolean(DATA_LOGIN,false);
    }
    public static void clearData(Context context){
        SharedPreferences.Editor editor=getSharedReferences(context).edit();
        editor.remove(Data_AS);
        editor.remove(DATA_LOGIN);
        editor.apply();
    }

}
