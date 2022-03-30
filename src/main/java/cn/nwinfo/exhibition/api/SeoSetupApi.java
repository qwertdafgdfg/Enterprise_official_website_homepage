package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.OtherImg;
import cn.nwinfo.exhibition.entity.SeoSetup;
import cn.nwinfo.exhibition.service.OtherImgService;
import cn.nwinfo.exhibition.service.SeoSetupService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/seoSetup")
public class SeoSetupApi {
    @Autowired
    SeoSetupService seoSetupService;

    //登录
    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody SeoSetup rotationChart) {
        System.out.println("添加" + rotationChart);
        JSONObject jsonObject = new JSONObject();
        boolean ok = seoSetupService.add(rotationChart);
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
    public Object delete(@RequestBody SeoSetup rotationChart) {
        System.out.println("删除" + rotationChart);
        JSONObject jsonObject = new JSONObject();
        boolean ok = seoSetupService.deleteById(rotationChart);
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
        return seoSetupService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return seoSetupService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return seoSetupService.findByAll();
    }

    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return seoSetupService.findById(id);
    }

    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody SeoSetup rotationChart) {
        System.out.println("修改" + rotationChart);
        JSONObject jsonObject = new JSONObject();
        boolean ok = seoSetupService.updateById(rotationChart);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
