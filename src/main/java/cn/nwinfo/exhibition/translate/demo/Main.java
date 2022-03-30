package cn.nwinfo.exhibition.translate.demo;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20200119000376719";
    private static final String SECURITY_KEY = "fG26yzXkv9JLfHBr0nQa";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "How are you";
        try {
            query = new String(query.getBytes("iso8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String str=api.getTransResult(query, "auto", "zh");
        System.out.println(str);

        System.out.println(str);

    }

}
