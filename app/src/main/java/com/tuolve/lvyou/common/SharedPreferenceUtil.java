package com.tuolve.lvyou.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.alibaba.fastjson.JSON;

import java.util.Set;

/**
 * 偏好文件读写工具类
 * Created by SCCSS on 16/7/8.
 */
public class SharedPreferenceUtil {

    private SharedPreferences sp;

    public SharedPreferenceUtil(Context context, String name) {
        sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public void set(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    public void set(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    @SuppressWarnings("unused")
    public void set(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    public void set(String key, float value) {
        sp.edit().putFloat(key, value).apply();
    }

    @SuppressWarnings("unused")
    public void set(String key, long value) {
        sp.edit().putLong(key, value).apply();
    }

    @SuppressWarnings("unused")
    public void set(String key, Set<String> value) {
        sp.edit().putStringSet(key, value).apply();
    }

    @SuppressWarnings("unused")
    public void set(String key, Object value) {
        sp.edit().putString(key, JSON.toJSONString(value)).apply();
    }

    @SuppressWarnings("unused")
    public void remove(String key) {
        sp.edit().remove(key).apply();
    }

    @SuppressWarnings("unused")
    public boolean contains(String key) {
        return sp.contains(key);
    }

    public int get(String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    public String get(String key, String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    @SuppressWarnings("unused")
    public boolean get(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    @SuppressWarnings("unused")
    public float get(String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    @SuppressWarnings("unused")
    public long get(String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    @SuppressWarnings("unused")
    public Set<String> get(String key, Set<String> defaultValue) {
        return sp.getStringSet(key, defaultValue);
    }

    @SuppressWarnings("unused")
    public <T> T get(String key, Class<T> type) {
        return JSON.parseObject(key, type);
    }
}
