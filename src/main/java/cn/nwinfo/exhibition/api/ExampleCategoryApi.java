package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.ExampleCategory;
import cn.nwinfo.exhibition.entity.ProductCategory;
import cn.nwinfo.exhibition.service.ExampleCategoryService;
import cn.nwinfo.exhibition.service.ProductCategoryService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/exampleCategory")
public class ExampleCategoryApi {
    @Autowired
    ExampleCategoryService exampleCategoryService;

    //登录
    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody ExampleCategory exampleCategory) {
        System.out.println("添加" + exampleCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = exampleCategoryService.add(exampleCategory);
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
    public Object delete(@RequestBody ExampleCategory exampleCategory) {
        System.out.println("删除" + exampleCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = exampleCategoryService.deleteById(exampleCategory);
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
        return exampleCategoryService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return exampleCategoryService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return exampleCategoryService.findByAll();
    }
    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return exampleCategoryService.findById(id);
    }
    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody ExampleCategory exampleCategory) {
        System.out.println("修改" + exampleCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = exampleCategoryService.updateById(exampleCategory);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
