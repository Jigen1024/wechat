package com.example;

import com.example.bean.RicoBean;
import com.example.message.TextMessage;
import com.google.gson.Gson;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@WebServlet(name = "Index")
public class Index extends HttpServlet {

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

            if ( type.equals("event") ) {
                String content = null;
                if ( event.equals("CLICK") ) {
                    if ( eventKey.equals("button_test") ) {
                        content = "[Smart]";
                    }
                } else if ( event.equals("subscribe") ) {
                    content = "欢迎关注本公众号";
                }
                TextMessage msg = new TextMessage(toUser, fromUser, content);
                printWriter.print(msg.create());
            } else if ( type.equals("text") ) {
                String content = xml.get("Content");
                content = content.replaceAll("(\r\n|\n|\n\r)", "");
                if ( -1 != content.indexOf("收到不支持的消息类型") ) {
                    content = "讲个笑话";
                }
                String url = Base.URL_TULING;
                url = String.format(url, toUser, content);
                String echo = Base.http_get(url);

                System.out.println("echo = " + echo);

                Gson gson = new Gson();
                RicoBean ricoBean = gson.fromJson(echo, RicoBean.class);
                String text = ricoBean.getText();
                if (null != ricoBean.getUrl()) {
                    text += ("\n" + ricoBean.getUrl());
                }
                TextMessage msg = new TextMessage(toUser, fromUser, text);
                printWriter.print(msg.create());
            } else {
                TextMessage message = new TextMessage(toUser, fromUser, "You didn't see anything!");
                printWriter.print(message.create());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String json = "{" +
//                "    \"device_num\":\"1\"," +
//                "    \"device_list\":[" +
//                "        {" +
//                "            \"id\":\"dev1\"," +
//                "            \"mac\":\"7cb54010fb36\"," +
//                "            \"connect_protocol\":\"4\"," +
//                "            \"auth_key\":\"\"," +
//                "            \"close_strategy\":\"1\"," +
//                "            \"conn_strategy\":\"1\"," +
//                "            \"crypt_method\":\"0\"," +
//                "            \"auth_ver\":\"0\"," +
//                "            \"manu_mac_pos\":\"-1\"," +
//                "            \"ser_mac_pos\":\"-2\"," +
//                "            \"ble_simple_protocol\": \"0\"" +
//                "        }" +
//                "    ]," +
//                "    \"op_type\":\"0\"," +
//                "    \"product_id\": \"41461\"" +
//                "}";
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print(Base.http_post("https://api.weixin.qq.com/device/authorize_device?access_token="
//                                + Base.getAccessToken()
//                                + "&product_id=41461", json));
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print());
        System.out.println("start verification...");
        Verification verification = new Verification();
        PrintWriter printWriter = response.getWriter();
        String result = verification.checkSignature(request.getParameterMap(), "123456");
        System.out.println("result = " + result);
        printWriter.print(result);
    }
}
