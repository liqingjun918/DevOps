package com.carrefour.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//这里面的属性有可能会更新的，git中的配置中心变化的话就要刷新，没有这个注解内，配置就不能及时
@RefreshScope
public class HelloController {
    @Value("${server.port}")
    private int port;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;


    @RequestMapping("index")
    public String index(){
        return "Hello World!,端口："+port;
    }

    @RequestMapping("test")
    public String test(){
        return this.name+this.age;
    }

}
