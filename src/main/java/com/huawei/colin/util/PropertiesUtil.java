package com.huawei.colin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * @Author: hudongfeng
 * @Description: Properties util for get properties value
 * @Date: 2017/11/28
 */
public final class PropertiesUtil {

    private static final String PROPERTIES_SUFFIX = ".properties";
    private static Properties properties = new Properties();
    private static long parsing_time = 0L;
    private static final String SEPARATOR = File.separator;

    static {
        System.out.println("parsing properties file");
         URL root_url = PropertiesUtil.class.getClassLoader().getResource("");
         if (null != root_url) {
             String root_dir = root_url.getPath();
             File file = new File(root_dir);
             long start = System.currentTimeMillis();
             readProperties(file);
             parsing_time = System.currentTimeMillis() - start;
         }
    }

    /**
     * Parsing all properties file
     * @param file File
     */
    private static void readProperties(File file) {
         if (null == file)
             throw new NullPointerException("file can't be null");

         if (file.isFile()) {
             String file_name = file.getAbsolutePath();
             if (file_name.endsWith(PROPERTIES_SUFFIX)) {
                 try {
                     properties.load(new FileInputStream(file));
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         } else if (file.isDirectory()) {
             String[] file_list = file.list();
             if (null != file_list) {
                 for (String files : file_list) {
                     if (files != null) readProperties(new File(file.getAbsolutePath() + SEPARATOR + files));
                 }
             }
         }
    }

    /**
     * Get key value
     * @param key Key
     * @return null if key is null, otherwise get its value from properties
     */
    public static String getProperties(String key) {
        return null == key ? null : properties.getProperty(key);
    }

    /**
     * Get all key-values in properties
     * @return All key-values
     */
    public static Map<String, String> getAllKeys() {
        Map<String, String> map = new HashMap<String, String>();
        properties.forEach((key, value) -> {
            map.put((String)key, (String)value);
        });
        return map;
    }

    /**
     * Get parsing time
     * @return Parsing time in MillisSeconds
     */
    public static long getParsing_time() {
        return parsing_time;
    }
}
