package com.carrefour.springconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringCloudApplication
@EnableConfigServer
public class SpringconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringconfigApplication.class, args);
    }

}
