package com.huawei.colin.service;

/**
 * @Author: hudongfeng
 * @Description: Key-Value from database
 * @Date: 2017/11/28
 */
public interface KeyValue {

    String get(String key);

    String set(String key, String value);

    String set(byte[] session, byte[] user);

    String setex(byte[] session, int expire_time, byte[] user);
}
