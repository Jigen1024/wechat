package com.example;

import com.example.bean.RicoBean;
import com.example.device.Device;
import com.example.message.TextMessage;
import com.google.gson.Gson;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Hardware extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/xml, charset=utf-8");

        BufferedReader bufferedReader = request.getReader();
        String line = null;
        String data = "";
        while ( (line = bufferedReader.readLine()) != null) {
            data += line;
        }
        System.out.println("recv = " + data);

        PrintWriter printWriter = response.getWriter();

        Map<String, String> xml = null;
        try {
            xml = Base.parseXml(data);
            String toUser = xml.get("FromUserName");
            String fromUser = xml.get("ToUserName");
            String type = xml.get("MsgType");
            String event = xml.get("Event");
            String eventKey = xml.get("EventKey");

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String value : values) {
                System.out.println(key + " : " + value);
            }
        }
    }
}
