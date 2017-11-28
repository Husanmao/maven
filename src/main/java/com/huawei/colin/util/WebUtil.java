package com.huawei.colin.util;

import com.sun.istack.internal.NotNull;

import java.io.PrintWriter;

/**
 * @Author: hudongfeng
 * @Description: Return message to the client
 * @Date: 2017/11/28
 */
public final class WebUtil {

    /**
     * Return message to the client through PrintWriter
     * @param pw HttpServletResponse.getWriter()
     * @param resp Message to return to the client
     */
    public static void responseInfo(@NotNull PrintWriter pw, String resp) {
        if (null != resp) {
            pw.print(resp);
        }
        pw.close();
    }
}
