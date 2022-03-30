package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.CSDToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.Visitor;
import cn.nwinfo.exhibition.service.ArticleService;
import cn.nwinfo.exhibition.service.VisitorService;
import cn.nwinfo.exhibition.util.AddressResult;
import cn.nwinfo.exhibition.util.AddressUtils;
import cn.nwinfo.exhibition.util.IpUtil;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

@RestController
@RequestMapping("api/visitor")
public class VisitorApi {
    @Autowired
    VisitorService visitorService;

    @PassToken
    @GetMapping("/add")
    public Object add(HttpServletRequest request) {
        Visitor visitor = new Visitor();
//        String ip = "221.216.64.183";
        String ip = IpUtil.getIpAddr(request);
        String eevice = IpUtil.getDeviceType(request);

        System.out.println("设备=" + eevice);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

        AddressUtils addressUtils = new AddressUtils();
        AddressResult address = new AddressResult();
        try {
            for (int i = 0; i < 5; i++) {
                address = addressUtils.getAddress("ip=" + ip, "utf-8");
                if (address != null) {
                    break;
                }
            }

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(address);
        visitor = visitorService.findByIp(ip);
        System.out.println("设备0=>>>>>>>" + visitor);
        JSONObject jsonObject = new JSONObject();
//        修改点击量
        if (visitor != null) {
            int tmp = Integer.parseInt(visitor.getClicks());
            tmp++;
            visitor.setClicks(tmp + "");
            visitor.setTime(df.format(new Date()));
            visitor.setEevice(eevice);
            visitorService.updateById(visitor);
            jsonObject.put("ok", true);
            jsonObject.put("message", "添加成功！");
            return jsonObject;
        }
        Visitor visitor1 = new Visitor();
        visitor1.setIp(address.getIp());
        visitor1.setAddress(address.getCountry()+"，"+address.getRegion()+"，"+address.getCity()+"，"+address.getCounty());

        visitor1.setRegion(address.getRegion());
        visitor1.setCity(address.getCity());
        visitor1.setCountry(address.getCountry());
        visitor1.setArea(address.getArea());
        visitor1.setIsp(address.getIsp());
        visitor1.setCounty(address.getCounty());
        visitor1.setClicks("1");

        visitor1.setEevice(eevice);

        visitor1.setTime(df.format(new Date()));

        System.out.println("添加访客5" + visitor1);

        boolean ok = visitorService.add(visitor1);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "添加成功！");

        } else {
            jsonObject.put("message", "添加失败！");
        }

        return jsonObject;
    }

    @CSDToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return visitorService.findPage(pageQuery);
    }

    @CSDToken
    @GetMapping(value = "/findVisitorVolume")
    public Object findVisitorVolume() {
        System.out.println("查询各省份点击量");
        List<Visitor> visitorList = new ArrayList<>();
        List<Object> list = new ArrayList<>();
        String province[] = {"北京", "天津", "河北", "山西", "内蒙古",
                "宁夏", "青海", "陕西", "甘肃", "新疆", "辽宁", "吉林",
                "黑龙江","山东", "江苏", "上海", "浙江", "安徽", "福建",
                "江西","河南", "湖南", "湖北","四川", "贵州", "云南",
                "重庆", "西藏","广东", "广西", "海南","香港", "澳门", "台湾"};
        int number[] = new int[34];
        Map<String, Object> map = new HashMap<String, Object>();
        visitorList = visitorService.findByAll();
        JSONObject jsonObject = new JSONObject();
        int clicks = 0;
        for (Visitor str : visitorList) {
            String address = str.getRegion();
            for (int i = 0; i < province.length; i++) {
                if (province[i].equals(address)) {
                    clicks=number[i];
                    clicks += Integer.parseInt(str.getClicks());
                    number[i] = clicks;
                    clicks = 0;
                }
            }
        }
        map.put("address", province);
        map.put("number", number);
        jsonObject.put("ok", true);
        jsonObject.put("visitorVolume", map);

        return jsonObject;
    }

}
