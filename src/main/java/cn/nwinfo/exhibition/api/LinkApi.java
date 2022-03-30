package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.CSDToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.entity.Notice;
import cn.nwinfo.exhibition.service.LinkService;
import cn.nwinfo.exhibition.service.NoticeService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/link")
public class LinkApi {
    @Autowired
    LinkService linkService;

    //登录
    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody Link link) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        link.setTime(df.format(new Date()));
        System.out.println("添加" + link);
        JSONObject jsonObject = new JSONObject();
        boolean ok = linkService.add(link);
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
    public Object delete(@RequestBody Link link) {
        System.out.println("删除" +  link);
        JSONObject jsonObject = new JSONObject();
        boolean ok = linkService.deleteById(link);
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
        return linkService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return linkService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return linkService.findByAll();
    }
    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return linkService.findById(id);
    }
    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody Link link) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        link.setTime(df.format(new Date()));
        System.out.println("修改" + link);
        JSONObject jsonObject = new JSONObject();
        boolean ok = linkService.updateById(link);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
