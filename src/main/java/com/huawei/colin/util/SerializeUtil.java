package com.huawei.colin.util;

import com.sun.istack.internal.NotNull;

import java.io.*;

/**
 * @Author: hudongfeng
 * @Description: Serialize or Unserialize object
 * @Date: 2017/11/28
 */
public class SerializeUtil {

    /**
     * Serialize an Object
     * @param object Object
     * @return Serialized object
     */
    public static byte[] serialize(@NotNull Object object) {
        ObjectOutputStream obs = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            obs = new ObjectOutputStream(bos);
            obs.writeObject(object);
            byte[] byt = bos.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Unserialize the byte[]
     * @param byt byte[]
     * @return Unserialized object
     */
    public static Object unserialize(byte[] byt) {
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = new ByteArrayInputStream(byt);
        try {
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
