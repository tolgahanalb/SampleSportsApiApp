package com.example.tolgahanalbayram.learnfragment.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class SharedPrefHelper {

    private SharedPrefHelper() {
    }

    public static void putStringToShared(Context context, String key, String value) {
        Editor editor = getEditorForWrite(context);
        editor.putString(key, value);
        editor.commit();
    }

    public static void putIntegerToShared(Context context, String key, int value) {
        Editor editor = getEditorForWrite(context);
        editor.putInt(key, value);
        editor.commit();
    }

    public static void putBoolToShared(Context context, String key, boolean value) {
        Editor editor = getEditorForWrite(context);
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean containsKey(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("APP_SCOPE", Context.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }

    public static void removeDataFromShared(Context context, String key) {
        Editor editor = getEditorForWrite(context);
        editor.remove(key);
        editor.commit();
    }

    public static String getStringFromShared(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("APP_SCOPE", Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, null);
    }

    public static int getIntegerFromShared(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("APP_SCOPE", Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }

    public static boolean getBoolFromShared(Context context, String key) {
        return getBoolFromShared(context, key, true);
    }

    public static boolean getBoolFromShared(Context context, String key, boolean defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("APP_SCOPE", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static int getIntegerFromShared(Context context, String key, int defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("APP_SCOPE", Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    private static Editor getEditorForWrite(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("APP_SCOPE", Context.MODE_PRIVATE);
        return sharedPreferences.edit();
    }
}
