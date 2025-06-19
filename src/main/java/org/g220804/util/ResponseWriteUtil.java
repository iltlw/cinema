package org.g220804.util;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseWriteUtil
{
    public static void responseWrite(HttpServletResponse httpServletResponse, String msg) throws IOException
    {
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().write(msg);
    }
}
