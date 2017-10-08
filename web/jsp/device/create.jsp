<%--
  Created by IntelliJ IDEA.
  User: 14318
  Date: 2017/10/6
  Time: 下午 07:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="com.example.JS"
%>
<%
    String url = request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+"?"+request.getQueryString();
    JS js = new JS(url);
%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加设备</title>
    <script src=https://res.wx.qq.com/open/js/jweixin-1.0.0.js></script>
</head>
<body>
    <h2> 搜索设备 </h2>
    <script type="text/javascript" >
        wx.config({
            beta : true,
        //    debug: true,
            appId: "<%=js.getAppId()%>",
            timestamp: "<%=js.getTimeStamp()%>",
            nonceStr: "<%=js.getNonceStr()%>",
            signature: "<%=js.getSignature()%>",
            jsApiList: ['configWXDeviceWiFi']
        });

        wx.ready(function() {
            wx.checkJsApi({
                jsApiList: ['configWXDeviceWiFi'],
                // 需要检测的 JS 接口列表
                success: function(res) {
                    wx.invoke('configWXDeviceWiFi', {}, function(res){
                        var err_msg = res.err_msg;
                        if(err_msg == 'configWXDeviceWiFi:ok') {
                            $('#message').html("配置 WIFI成功");
                            return;
                        } else {
                            $('#message').html("配置 WIFI失败");
                        }
                    });
                }
            });
        });
    </script>

</body>
</html>
