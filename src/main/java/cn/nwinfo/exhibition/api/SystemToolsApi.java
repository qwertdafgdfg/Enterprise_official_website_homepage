package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.translate.demo.TransApi;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/systemTools")
public class SystemToolsApi {

    @Value("${baiduTranslate.appid}")
    String APP_ID;
    @Value("${baiduTranslate.securityKey}")
    String SECURITY_KEY;

    @PostMapping("rewrite")
    @AdminToken
    public Object test(@RequestBody String query) {
        System.out.println(query.length() * 2);
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        com.alibaba.fastjson.JSONObject jsonObject = JSON.parseObject(query);//解析
        query = jsonObject.getString("query");//得到其中的数
        String[] ss = query.split("\n|\r");
        String data = "12";
        String data1 = "";
        for (String str : ss) {
            System.out.println(str);
            str = str.replaceAll("\r|\n", "");
            if (str.equals("") || str.equals(" ") || str == null) {
                continue;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
                ;
            } catch (InterruptedException ie) {
            }
            data = api.getTransResult(str, "auto", "en");
            try {
                TimeUnit.SECONDS.sleep(1);
                ;
            } catch (InterruptedException ie) {
            }
            System.out.println("英文" + data);
            String line="";
            if (data1 != ""){
                line="\n\n";
            }
            data1 = data1 + line + api.getTransResult(data, "auto", "zh");

        }
        JSONObject jsonObject1 = new JSONObject();
        System.out.println(query.length() * 2);
        jsonObject1.put("ok", true);
        jsonObject1.put("content", data1);
        return jsonObject1;
    }
}
