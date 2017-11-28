package com.huawei.colin.service.impl;

import com.huawei.colin.dao.RedisProvider;
import com.huawei.colin.service.KeyValue;
import redis.clients.jedis.Jedis;

/**
 * @Author: hudongfeng
 * @Description: Redis Helper
 * @Date: 2017/11/27
 */
public class RedisHelper extends RedisProvider implements KeyValue {



    /**
     * Set key value in jedis
     * @param key Map-Key
     * @param value Map-Value
     * @return Status code reply
     */
    public String set(String key, String value) {
        Jedis jedis = getJedis();
        String resultCode = jedis.set(key, value);
        jedis.close();
        return resultCode;
    }

    /**
     * Get the value of key
     * @param key Map-Key
     * @return Bulk reply
     */
    public String get(String key) {
        Jedis jedis = getJedis();
        String res = jedis.get(key);
        jedis.close();
        return res;
    }

    /**
     * Map session - user(serialized)
     * @param session HttpSession.getBytes
     * @param user Serialized user
     * @return Status code reply
     */
    public String set(byte[] session, byte[] user) {
        Jedis jedis = getJedis();
        String res = jedis.set(session, user);
        jedis.close();
        return res;
    }

    /**
     * Set value with expire time
     * @param session
     * @param expire_time
     * @param user
     * @return
     */
    public String setex(byte[] session, int expire_time, byte[] user) {
        Jedis jedis = getJedis();
        String res = jedis.setex(session, expire_time, user);
        jedis.close();
        return res;
    }
}
