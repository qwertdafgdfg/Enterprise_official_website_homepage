package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.Example;
import cn.nwinfo.exhibition.service.ArticleService;
import cn.nwinfo.exhibition.service.ExampleService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/example")
public class ExampleApi {
    @Autowired
    ExampleService exampleService;

    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody Example example) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        example.setTime(df.format(new Date()));
        System.out.println("添加文章" + example);
        JSONObject jsonObject = new JSONObject();
        boolean ok = exampleService.add(example);
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
    public Object delete(@RequestBody Example example) {
        System.out.println("删除" + example);
        JSONObject jsonObject = new JSONObject();
        boolean ok = exampleService.deleteById(example);
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
    public Object updateById(@RequestBody Example example) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        example.setTime(df.format(new Date()));
        System.out.println("修改" + example);
        JSONObject jsonObject = new JSONObject();
        boolean ok = exampleService.updateById(example);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

    @PassToken
    @GetMapping("/findBySearchStr")
    public Object findBySearchStr(String searchStr) {
        System.out.println("搜索" + searchStr);
        return exampleService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery, Example example) {
        String cid = example.getC_id();
        if (cid == null ||cid == "" || cid.equals("0") || cid.equals("")) {
            example.setC_id(null);
        }
        System.out.println("案例分页2" + pageQuery + example);
        return exampleService.findPage(example, pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return exampleService.findByAll();
    }

    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("id查询");
        return exampleService.findById(id);
    }

    @PassToken
    @GetMapping(value = "/findByHot")
    public Object findByHot() {
        System.out.println("首页");
        return exampleService.findByHot();
    }


}
