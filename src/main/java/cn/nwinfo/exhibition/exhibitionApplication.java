package cn.nwinfo.exhibition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author
 * @date 2020-01-23 22:01
 */
@SpringBootApplication
@MapperScan("cn.nwinfo.exhibition.mapper")

public class exhibitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(exhibitionApplication.class, args);
    }
}
