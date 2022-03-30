package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.About;
import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.service.AboutService;
import cn.nwinfo.exhibition.service.ArticleService;
import cn.nwinfo.exhibition.util.IpUtil;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/about")
public class AboutApi {
    @Autowired
    AboutService aboutService;

    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody About article) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        article.setTime(df.format(new Date()));
        System.out.println("添加文章" + article);
        JSONObject jsonObject = new JSONObject();
        boolean ok = aboutService.add(article);
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
    public Object delete(@RequestBody About article) {
        System.out.println("删除" + article);
        JSONObject jsonObject = new JSONObject();
        boolean ok = aboutService.deleteById(article);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "删除成功！");

        } else {
            jsonObject.put("message", "删除失败！");
        }
        return jsonObject;
    }

    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody About article) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        article.setTime(df.format(new Date()));
        System.out.println("修改" + article);
        JSONObject jsonObject = new JSONObject();
        boolean ok = aboutService.updateById(article);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

    @PassToken
    @GetMapping(value = "/findByHot")
    public Object findByHot() {
        System.out.println("首页");
        return aboutService.findByHot();
    }

    @PassToken
    @GetMapping("/findBySearchStr")
    public Object findBySearchStr(String searchStr) {
        System.out.println("搜索" + searchStr);
        return aboutService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return aboutService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll(HttpServletRequest request) {
        System.out.println("设备=" + IpUtil.getDeviceType(request));
        System.out.println("全部");
        return aboutService.findByAll();
    }

    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("id查询");
        return aboutService.findById(id);
    }


}
