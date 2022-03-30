package cn.nwinfo.exhibition.api;

import cn.nwinfo.exhibition.annotation.AdminToken;
import cn.nwinfo.exhibition.annotation.PassToken;
import cn.nwinfo.exhibition.service.TokenService;
import cn.nwinfo.exhibition.service.UploadService;
import cn.nwinfo.exhibition.util.UploadUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/upload")
public class uploadApi {

    @Autowired
    UploadService uploadService;


    // 上传文件
    @AdminToken
    @PostMapping(value = "/uploadFileMasterGraph")
    public String uploadFileMasterGraph(HttpServletRequest request,MultipartFile file)
            throws Exception {
        System.out.println("上传" + file);
//        UploadUtil uploadUtil = new UploadUtil();
        String fileUrl = uploadService.upload(file,request);
        System.out.println("路径" + fileUrl);
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map.put("code", 0);// 0表示成功，1失败
        map.put("ok", true);
        map.put("msg", "上传成功");// 提示消息
        map.put("data", map2);
        map2.put("src", fileUrl);// 图片url
        map2.put("title", "图片");// 图片名称，这个会显示在输入框里
        String result = new JSONObject(map).toString();
        return result;

    }
    // 上传文件
    @PassToken
    @PostMapping(value = "/upload")
    public Object upload(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file,
                         HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("上传" + file);
//        UploadUtil uploadUtil = new UploadUtil();
        String fileUrl = uploadService.upload(file,request);
        JSONObject res = new JSONObject();
        res.put("url", fileUrl);
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;

    }
}
