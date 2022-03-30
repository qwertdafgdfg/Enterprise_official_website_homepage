package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.Link;
import cn.nwinfo.exhibition.entity.RotationChart;
import cn.nwinfo.exhibition.service.LinkService;
import cn.nwinfo.exhibition.service.RotationChartService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/rotationChart")
public class RotationChartApi {
    @Autowired
    RotationChartService rotationChartService;

    //登录
    @AdminToken
    @PostMapping("/add")
    public Object add(@RequestBody RotationChart rotationChart) {
        System.out.println("添加" + rotationChart);
        JSONObject jsonObject = new JSONObject();
        boolean ok = rotationChartService.add(rotationChart);
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
    public Object delete(@RequestBody RotationChart rotationChart) {
        System.out.println("删除" + rotationChart);
        JSONObject jsonObject = new JSONObject();
        boolean ok = rotationChartService.deleteById(rotationChart);
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
        return rotationChartService.findBySearchStr(searchStr);
    }

    @PassToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return rotationChartService.findPage(pageQuery);
    }

    @PassToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return rotationChartService.findByAll();
    }

    @PassToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return rotationChartService.findById(id);
    }

    @AdminToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody RotationChart rotationChart) {
        System.out.println("修改" + rotationChart);
        JSONObject jsonObject = new JSONObject();
        boolean ok = rotationChartService.updateById(rotationChart);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
