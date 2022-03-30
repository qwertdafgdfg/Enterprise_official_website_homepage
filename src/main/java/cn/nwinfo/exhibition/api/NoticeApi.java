package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.CSDToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.MessageBoard;
import cn.nwinfo.exhibition.entity.Notice;
import cn.nwinfo.exhibition.service.MessageBoardService;
import cn.nwinfo.exhibition.service.NoticeService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/notice")
public class NoticeApi {
    @Autowired
    NoticeService noticeService;

    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody Notice notice) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        notice.setTime(df.format(new Date()));
        System.out.println("添加" + notice);
        JSONObject jsonObject = new JSONObject();
        boolean ok = noticeService.add(notice);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "添加成功！");

        } else {
            jsonObject.put("message", "添加失败！");
        }

        return jsonObject;
    }

    @SuperAdminToken
    @DeleteMapping("/delete")
    public Object delete(@RequestBody Notice notice) {
        System.out.println("删除" +  notice);
        JSONObject jsonObject = new JSONObject();
        boolean ok = noticeService.deleteById(notice);
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
        return noticeService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return noticeService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return noticeService.findByAll();
    }
    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return noticeService.findById(id);
    }
    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody Notice notice) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        notice.setTime(df.format(new Date()));
        System.out.println("修改" + notice);
        JSONObject jsonObject = new JSONObject();
        boolean ok = noticeService.updateById(notice);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
