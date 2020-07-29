package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie")
public class ServletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] crr = req.getCookies();
        boolean isFirst = true;
        resp.setContentType("text/html;charset=utf-8");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(crr != null)
        for(Cookie c : crr) {
            if (c.getName().equals("time")) {
                c.setValue(URLEncoder.encode(f.format(new Date()),"utf-8"));
                resp.getOutputStream().write(URLDecoder.decode(c.getValue()).getBytes());
                c.setMaxAge(60);
                isFirst = false;
                break;
            }
        }
        if(isFirst){
            resp.addCookie(new Cookie("time",URLEncoder.encode(f.format(new Date()),"utf-8")));
            resp.getOutputStream().write("你好!".getBytes("UTF-8"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
