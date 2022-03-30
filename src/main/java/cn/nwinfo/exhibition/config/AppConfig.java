package cn.nwinfo.exhibition.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

/**
 * @author 61941
 * @Description: 配置图片访问路径虚拟化
 * @Date: 2019/6/15
 * @Auther: wm yu
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    @Value("${mogu.picture.upload}")
    private String uploadUrl;

    @Value("${mogu.picture.mapping}")
    private String mappingUrl;

    /**
     * 得到的访问路径为当前项目端口路径 + /upload/image/
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
         * 说明：增加虚拟路径(经过本人测试：在此处配置的虚拟路径，用springboot内置的tomcat时有效，
         * 用外部的tomcat也有效;所以用到外部的tomcat时不需在tomcat/config下的相应文件配置虚拟路径了,阿里云linux也没问题)
         */
        registry.addResourceHandler(mappingUrl+"/**").addResourceLocations("file:"+ uploadUrl + File.separator);
        //阿里云(映射路径去除盘符)
        //registry.addResourceHandler("/ueditor/image/**").addResourceLocations("/upload/image/");
        super.addResourceHandlers(registry);
    }
}
