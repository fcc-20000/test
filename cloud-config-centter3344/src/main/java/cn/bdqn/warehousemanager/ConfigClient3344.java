package cn.bdqn.warehousemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigClient3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3344.class, args);
    }
}
