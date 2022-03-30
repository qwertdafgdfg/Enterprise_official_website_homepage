package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.CSDToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.Advantage;
import cn.nwinfo.exhibition.entity.Notice;
import cn.nwinfo.exhibition.service.AdvantageService;
import cn.nwinfo.exhibition.service.NoticeService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/advantage")
public class AdvantageApi {
    @Autowired
    AdvantageService advantageService;

    //登录
    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody Advantage advantage) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        advantage.setTime(df.format(new Date()));
        System.out.println("添加" + advantage);
        JSONObject jsonObject = new JSONObject();
        boolean ok = advantageService.add(advantage);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "添加成功！");

        } else {
            jsonObject.put("message", "添加失败！");
        }

        return jsonObject;
    }

    @AdminToken
    @DeleteMapping("/delete")
    public Object delete(@RequestBody Advantage advantage) {
        System.out.println("删除" +  advantage);
        JSONObject jsonObject = new JSONObject();
        boolean ok = advantageService.deleteById(advantage);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "删除成功！");

        } else {
            jsonObject.put("message", "删除失败！");
        }
        return jsonObject;
    }

    @PassToken
    @GetMapping("/findBySearchStr")
    public Object findBySearchStr(String searchStr) {
        System.out.println("搜索" + searchStr);
        return advantageService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return advantageService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return advantageService.findByAll();
    }
    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return advantageService.findById(id);
    }
    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody Advantage advantage) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        advantage.setTime(df.format(new Date()));
        System.out.println("修改" + advantage);
        JSONObject jsonObject = new JSONObject();
        boolean ok = advantageService.updateById(advantage);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
