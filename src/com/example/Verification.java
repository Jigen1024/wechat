package com.example;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;

public class Verification {

    public String checkSignature(Map<String, String[]> params, String token) {
        if (params.isEmpty()) {
            return null;
        }
        if (params.containsKey("signature")
                && params.containsKey("timestamp")
                && params.containsKey("nonce")
                && params.containsKey("echostr")) {
            ArrayList<String> list = new ArrayList<>();
            list.add(params.get("timestamp")[0]);
            list.add(params.get("nonce")[0]);
            list.add(token);
            Collections.sort(list);
            String str = list.get(0) + list.get(1) + list.get(2);
            String result = DigestUtils.sha1Hex(str);
            if (result.equals(params.get("signature")[0])) {
                return params.get("echostr")[0];
            }
        }
        return null;
    }
}
