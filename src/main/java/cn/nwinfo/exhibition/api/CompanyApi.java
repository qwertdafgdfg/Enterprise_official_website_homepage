package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.entity.Company;
import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.service.CompanyService;
import cn.nwinfo.exhibition.service.LinkService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/company")
public class CompanyApi {
    @Autowired
    CompanyService companyService;

    @PassToken
    @GetMapping(value = "/find")
    public Object findById() {
        System.out.println("全部");
        return companyService.findById("1");
    }

    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody Company link) {
        link.setTemplates(null);
        System.out.println("修改" + link);
        JSONObject jsonObject = new JSONObject();
        boolean ok = companyService.updateById(link);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

    @AdminToken
    @PutMapping("/updateTemplates")
    public Object updateTemplates(@RequestBody Company link) {
        link.setId("1");
        System.out.println("修改" + link);
        JSONObject jsonObject = new JSONObject();
        boolean ok = companyService.updateById(link);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "主题已更改！");

        } else {
            jsonObject.put("message", "主题更改失败！");
        }
        return jsonObject;
    }

}
