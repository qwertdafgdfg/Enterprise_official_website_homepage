package cn.nwinfo.exhibition.translate.demo;

import com.alibaba.fastjson.JSON;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class TransApi {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private String appid;
    private String securityKey;

    public TransApi(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }

    public String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        String str = null;
        try {
            str = HttpGet.post(TRANS_API_HOST, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String date = null;
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(str);//解析
        com.alibaba.fastjson.JSONArray array = jsonObject.getJSONArray("trans_result");//得到其中的数

        int length = array.size();
        for (int i = 0; i < length; i++) {
            com.alibaba.fastjson.JSONObject params1 = JSON.parseObject(array.getString(i));
            String str1 = params1.getString("dst");
            date = str1;
            try {
                str1 = URLDecoder.decode(str1, "utf-8");
                date = str1;
            } catch (Exception e1) {
            }
        }
        return date;
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }

}
