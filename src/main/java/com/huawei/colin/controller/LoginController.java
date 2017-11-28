package com.huawei.colin.controller;

import com.huawei.colin.bean.User;
import com.huawei.colin.service.impl.LoginService;
import com.huawei.colin.service.impl.SayHi;
import com.huawei.colin.util.WebUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Login controller
 */
@Controller
@RequestMapping(value = "/test")
public class LoginController {

    @Autowired
    private LoginService loginService;
    private static Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. Handle log and info collecting
        System.out.println("login session : " + request.getSession());
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        User user = new User(username, passwd);

        // 2. Call service
        String resp = loginService.login(session, user);

        // 3. Response to client
        WebUtil.responseInfo(response.getWriter(), resp);
    }
}