package org.g220804.handlers;

import com.alibaba.fastjson.JSON;
import org.g220804.http.AppInfo;
import org.g220804.http.HttpCode;
import org.g220804.util.ResponseJson;
import org.g220804.util.ResponseWriteUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminSessionHandler implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        HttpSession session = request.getSession();
        if(session.getAttribute(AppInfo.SESSION_ADMIN) == null)
        {
            ResponseWriteUtil.responseWrite(response, JSON.toJSONString(ResponseJson.getInstance(HttpCode.NOTLOGIN, null)));
            return false;
        }
        return true;
    }
}
