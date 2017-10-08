package com.example.device;

import com.example.Base;

import java.io.IOException;

public class Device {

    public String Register() throws IOException {
        String url = String.format(Base.URL_REG_DEVICE, "41467", Base.getAccessToken());
        return Base.http_get(url);
    }

    public String Auth() throws IOException {
        String json = "{\n" +
                "    \"device_num\":\"1\"," +
                "    \"device_list\":[" +
                "    {" +
                "    \"id\":\"gh_e965d28be811_1a3cac3a5f2220a6\"," +
                "    \"mac\":\"5CCF7FA3BC07\"," +
                "    \"connect_protocol\":\"4\"," +
                "    \"auth_key\":\"\"," +
                "    \"close_strategy\":\"1\"," +
                "    \"conn_strategy\":\"1\"," +
                "    \"crypt_method\":\"0\"," +
                "    \"auth_ver\":\"0\"," +
                "    \"manu_mac_pos\":\"-1\"," +
                "    \"ser_mac_pos\":\"-2\"," +
                "    \"ble_simple_protocol\": \"0\"" +
                "}" +
                "]," +
                "\"op_type\":\"1\"" +
                "}";
        return Base.http_post(Base.URL_AUTH_DEVICE + Base.getAccessToken(), json);
    }
}
