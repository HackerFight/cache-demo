package com.qiuguan.cache;

import com.qiuguan.cache.ann.EnableCustomCaching;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author created by qiuguan on 2021/12/21 10:47
 */
@EnableCustomCaching
//@EnableCaching
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
