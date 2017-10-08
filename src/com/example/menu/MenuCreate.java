package com.example.menu;

import com.example.Base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class MenuCreate extends MenuAdapter{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IMenu menu = new MenuCreate();
        resp.setContentType("text/html, charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(menu.create());
    }

    @Override
    public String create() throws IOException {
        String menu = "../webapps/wechat/data/menuStyle.json";
        File file = new File(menu);
        FileInputStream stream = new FileInputStream(file);
        byte[] content = new byte[(int) file.length()];
        stream.read(content);
        String style = new String(content, "utf-8");
        return Base.http_post(Base.URL_CREATE_MENU + Base.getAccessToken(), style);
    }
}
