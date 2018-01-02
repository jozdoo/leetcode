package com.jozdoo.leetcode;

import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeandDecodeTinyURL535 {
    public static void main(String[] args) {
        EncodeandDecodeTinyURL535 encodeandDecodeTinyURL535 = new EncodeandDecodeTinyURL535();
        String encode = encodeandDecodeTinyURL535.encode("www.baidu.com");
        String decode = encodeandDecodeTinyURL535.decode(encode);
        System.out.println(encode);
        System.out.println(decode);
    }
    Map<String,String> map = new HashMap<>();
    Random random = new Random();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key=null;
        while (key==null||map.containsKey(key)) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < 6; i++) {
                stringBuffer.append((char) ((int)'a'+random.nextInt(26)));
            }
            key = stringBuffer.toString();
        }
        map.put(key,longUrl);
        return "http://tinyurl.com/"+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String substring = shortUrl.substring(19);
        return map.get(substring);
    }
}
