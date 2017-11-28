package com.huawei.colin.util;

import com.sun.istack.internal.NotNull;
import org.jetbrains.annotations.Contract;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author: hudongfeng
 * @Description: Util for exceptions
 * @Date: 2017/11/27
 */
public final class ExceptionUtil {

    /**
     * Get the exception trace
     * @param throwable Exception
     * @return Trace
     */

    @Contract(pure = true)
    public static String getTrace(@NotNull Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter pw = new PrintWriter(stringWriter);
        throwable.printStackTrace(pw);
        return stringWriter.getBuffer().toString();
    }
}
