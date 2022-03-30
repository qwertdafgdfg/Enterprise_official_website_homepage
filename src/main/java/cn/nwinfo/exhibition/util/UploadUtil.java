package cn.nwinfo.exhibition.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
@PropertySource("classpath:application.yaml")
public class UploadUtil {

    @Value("${mogu.picture.upload}")
    String uploadUrl;

    @Value("${mogu.picture.mapping}")
    String mappingUrl;

    public String upload(MultipartFile file, HttpServletRequest request) throws Exception {

        System.out.println("路径" + uploadUrl);
        System.out.println("虚拟路径" + mappingUrl);
        if(file.isEmpty()){
            //返回选择文件提示
            return "请选择上传文件";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String(uploadUrl);
//        logger.info("-----------上传文件保存的路径【"+ realPath +"】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file1 = new File(realPath + format);
//        logger.info("-----------存放上传文件的文件夹【"+ file +"】-----------");
//        logger.info("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
        if(!file1.isDirectory()){
            //递归生成文件夹
            file1.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = file.getOriginalFilename();
//        logger.info("-----------文件原始的名字【"+ oldName +"】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
//        logger.info("-----------文件要保存后的新名字【"+ newName +"】-----------");
        try {
            //构建真实的文件路径
            File newFile = new File(file1.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            file.transferTo(newFile);
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + mappingUrl+"/" + format + newName;
//            logger.info("-----------【"+ filePath +"】-----------");
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";

















//        if (Objects.isNull(file) || file.isEmpty() || Objects.isNull(file.getOriginalFilename())) {
//            return null;
//        }
//        String path = ResourceUtils.getURL("classpath:").getPath();
//        String fileName = file.getOriginalFilename();
//
//        System.out.println("path=====" + path);
//        String type = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
//        String time = new SimpleDateFormat("yyMMddssSSS").format(new Date());
//        String yy = new SimpleDateFormat("yyyy").format(new Date()) + "-y";//设置日期格式
//        String mm = new SimpleDateFormat("MM").format(new Date()) + "-m";//设置日期格式
//        String dd = new SimpleDateFormat("dd").format(new Date()) + "-d";//设置日期格式
//        path = path + "static/upload/" + yy + "/" + mm + "/" + dd + "/";
//
//        String filepath = "/upload/" + yy + "/" + mm + "/" + dd + "/" + time + "." + type;
//        File savefile = new File(path);
//        if (!savefile.exists()) {
//            savefile.mkdirs();
//        }
//        File fie = new File(path, time + "." + type);
//        file.transferTo(fie);
//        return filepath;
    }

}
