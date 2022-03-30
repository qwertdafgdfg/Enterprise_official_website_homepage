package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.Article;
import cn.nwinfo.exhibition.entity.Product;
import cn.nwinfo.exhibition.service.ArticleService;
import cn.nwinfo.exhibition.service.ProductService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/product")
public class ProductApi {
    @Autowired
    ProductService productService;

    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody Product product) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        product.setTime(df.format(new Date()));
        System.out.println("添加文章" + product);
        JSONObject jsonObject = new JSONObject();
        boolean ok = productService.add(product);
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
    public Object delete(@RequestBody Product product) {
        System.out.println("删除" + product);
        JSONObject jsonObject = new JSONObject();
        boolean ok = productService.deleteById(product);
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
    public Object updateById(@RequestBody Product product) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        product.setTime(df.format(new Date()));
        System.out.println("修改" + product);
        JSONObject jsonObject = new JSONObject();
        boolean ok = productService.updateById(product);
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
        return productService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery,Product product) {
        String cid = product.getC_id();
        if (cid == null ||cid == "" || cid.equals("0") || cid.equals("")) {
            product.setC_id(null);
        }
        System.out.println("产品分页" + pageQuery + product);
        return productService.findPage(product, pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return productService.findByAll();
    }

    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("id查询");
        return productService.findById(id);
    }

    @PassToken
    @GetMapping(value = "/findByHot")
    public Object findByHot() {
        System.out.println("首页");
        return productService.findByHot();
    }


}
