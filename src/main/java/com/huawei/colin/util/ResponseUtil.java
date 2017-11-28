package com.huawei.colin.util;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2017/11/28
 */
public final class ResponseUtil {

    // login status code
    public enum LoginStatus {
        SUCCEED(1),
        FAILED(2),
        EXCEPTION(3),
        AGAIN(4);

        private int code;

        private LoginStatus(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            switch (this.code){
                case 1:
                    return "Login Succeed";
                case 2:
                    return "Login failed";
                case 4:
                    return "Login again";
                case 3:
                default:
                    return "Login exception";
            }
        }
    };
}
