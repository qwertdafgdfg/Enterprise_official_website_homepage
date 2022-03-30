package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.CSDToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.annotation.SuperAdminToken;
import cn.nwinfo.exhibition.entity.ArticleCategory;
import cn.nwinfo.exhibition.entity.MessageBoard;
import cn.nwinfo.exhibition.service.ArticleCategoryService;
import cn.nwinfo.exhibition.service.MessageBoardService;
import cn.nwinfo.exhibition.util.PageRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("api/messageBoard")
public class MessageBoardApi {
    @Autowired
    MessageBoardService messageBoardService;

    //登录
    @PassToken
    @PostMapping("/add")
    public Object add(@RequestBody MessageBoard messageBoard) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        messageBoard.setTime(df.format(new Date()));
        System.out.println("添加" + messageBoard);
        JSONObject jsonObject = new JSONObject();
        boolean ok = messageBoardService.add(messageBoard);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "添加成功！");

        } else {
            jsonObject.put("message", "添加失败！");
        }

        return jsonObject;
    }

    @CSDToken
    @DeleteMapping("/delete")
    public Object delete(@RequestBody MessageBoard messageBoard) {
        System.out.println("删除" +  messageBoard);
        JSONObject jsonObject = new JSONObject();
        boolean ok = messageBoardService.deleteById(messageBoard);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "删除成功！");

        } else {
            jsonObject.put("message", "删除失败！");
        }
        return jsonObject;
    }

    @CSDToken
    @GetMapping("/findBySearchStr")
    public Object findBySearchStr(String searchStr) {
        System.out.println("搜索" + searchStr);
        return messageBoardService.findBySearchStr(searchStr);
    }

    @CSDToken
    @GetMapping(value = "/findPage")
    public Object findPage(PageRequest pageQuery) {
        System.out.println("分页" + pageQuery);
        return messageBoardService.findPage(pageQuery);
    }

    @CSDToken
    @GetMapping(value = "/findByAll")
    public Object findByAll() {
        System.out.println("全部");
        return messageBoardService.findByAll();
    }
    @CSDToken
    @GetMapping(value = "/findById")
    public Object findById(String id) {
        System.out.println("全部");
        return messageBoardService.findById(id);
    }
    @CSDToken
    @PutMapping("/updateById")
    public Object updateById(@RequestBody MessageBoard messageBoard) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        messageBoard.setTime(df.format(new Date()));
        System.out.println("修改" + messageBoard);
        JSONObject jsonObject = new JSONObject();
        boolean ok = messageBoardService.updateById(messageBoard);
        jsonObject.put("ok", ok);
        if (ok) {
            jsonObject.put("message", "修改成功！");

        } else {
            jsonObject.put("message", "修改失败！");
        }
        return jsonObject;
    }

}
