package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.annotation.UserLoginToken;
import cn.nwinfo.exhibition.entity.*;
import cn.nwinfo.exhibition.service.*;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/articleCategory")
public class ArticleCategoryApi {
    @Autowired
    ArticleCategoryService articleCategoryService;

    //登录
    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody ArticleCategory articleCategory) {
        System.out.println("添加" + articleCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = articleCategoryService.add(articleCategory);
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
    public Object delete(@RequestBody ArticleCategory articleCategory) {
        System.out.println("删除" + articleCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = articleCategoryService.deleteById(articleCategory);
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
        return articleCategoryService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return articleCategoryService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return articleCategoryService.findByAll();
    }
    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return articleCategoryService.findById(id);
    }
    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody ArticleCategory articleCategory) {
        System.out.println("修改" + articleCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = articleCategoryService.updateById(articleCategory);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
