package com.huawei.colin.dao;

import com.huawei.colin.util.ExceptionUtil;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.ResourceBundle;

/**
 * @Author: hudongfeng
 * @Description: Redis Provider
 * @Date: 2017/11/27
 */
public class RedisProvider {
    /** Tag */
    public static final String TAG = RedisProvider.class.getSimpleName();

    /** logger */
    private static final Logger LOGGER = Logger.getLogger(RedisProvider.class);

    private static JedisPool jedisPool;

    private static int EXPIRE = 130;

    private static final int REDIS_RETRY_TIME = 3000;   //ms
    private static final int JEDIS_TIME_OUT = 10000;
    private static final int DEFAULT_JEDIS_PORT = 6379;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setBlockWhenExhausted(true);
        jedisPoolConfig.setJmxEnabled(true);
        jedisPoolConfig.setMaxIdle(8);
        jedisPool = new JedisPool(jedisPoolConfig, "localhost", DEFAULT_JEDIS_PORT, JEDIS_TIME_OUT);
    }
    /**
     * Get a jedis
     * @return Jedis
     */
    public static Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (JedisConnectionException jce) {
            ExceptionUtil.getTrace(jce);
            try {
                Thread.sleep(REDIS_RETRY_TIME);
            } catch (InterruptedException e) {
                ExceptionUtil.getTrace(e);
            }
            jedis = jedisPool.getResource();
        }
        return jedis;
    }
}
