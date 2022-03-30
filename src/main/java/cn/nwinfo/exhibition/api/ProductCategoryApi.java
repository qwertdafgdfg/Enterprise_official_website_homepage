package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.ArticleCategory;
import cn.nwinfo.exhibition.entity.ProductCategory;
import cn.nwinfo.exhibition.service.ArticleCategoryService;
import cn.nwinfo.exhibition.service.ProductCategoryService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/productCategory")
public class ProductCategoryApi {
    @Autowired
    ProductCategoryService productCategoryService;

    //登录
    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody ProductCategory productCategory) {
        System.out.println("添加" + productCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = productCategoryService.add(productCategory);
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
    public Object delete(@RequestBody ProductCategory productCategory) {
        System.out.println("删除" + productCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = productCategoryService.deleteById(productCategory);
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
        return productCategoryService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return productCategoryService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return productCategoryService.findByAll();
    }
    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return productCategoryService.findById(id);
    }
    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody ProductCategory productCategory) {
        System.out.println("修改" + productCategory);
        JSONObject jsonObject = new JSONObject();
        boolean ok = productCategoryService.updateById(productCategory);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
