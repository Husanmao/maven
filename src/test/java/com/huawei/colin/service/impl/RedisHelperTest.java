package com.huawei.colin.service.impl;

import com.huawei.colin.service.KeyValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2017/11/28
 */
public class RedisHelperTest {

    @Test
    public void set() throws Exception {
        KeyValue keyValue = new RedisHelper();
        String resCode = keyValue.set("name", "John");
        String value = keyValue.get("name");
        assertTrue(value.equals("John"));
    }

    @Test
    public void get() throws Exception {
        KeyValue keyValue = new RedisHelper();
        String value = keyValue.get("name");
        assertTrue(value.equals("John"));
    }

}