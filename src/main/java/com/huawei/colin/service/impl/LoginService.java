package com.huawei.colin.service.impl;

import com.huawei.colin.bean.User;
import com.huawei.colin.service.KeyValue;
import com.huawei.colin.util.PropertiesUtil;
import com.huawei.colin.util.ResponseUtil;
import com.huawei.colin.util.SerializeUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Author: hudongfeng
 * @Description:
 * @Date: 2017/11/28
 */
@Service("LoginService")
public class LoginService {

    /** logger */
    private static final Logger LOGGER = Logger.getLogger(LoginService.class);

    /** expire time for session */
    private static final int expire_time = Integer.parseInt(PropertiesUtil.getProperties("expire.time"));

    public LoginService() {

    }

    /**
     * login check, session expired or user has never login
     * @param session User session
     * @param user User
     * @return Login status
     */
    public String login(HttpSession session, User user) {
        // 1. check if we have cache the session
        KeyValue keyValue = new RedisHelper();
        String session_serial = session.getId();
        String resCode = keyValue.get(session_serial);
        if (null == resCode) {
            LOGGER.info("New User " + user.toString());
            String res = keyValue.setex(session_serial.getBytes(), expire_time, SerializeUtil.serialize(user));
        }
        return ResponseUtil.LoginStatus.SUCCEED.toString();
    }
}
