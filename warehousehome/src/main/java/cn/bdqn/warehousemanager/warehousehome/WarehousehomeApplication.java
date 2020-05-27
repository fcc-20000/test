package cn.bdqn.warehousemanager.warehousehome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"cn.bdqn.warehousemanager.communal.mapper", "cn.bdqn.warehousemanager.warehousehome.mapper"})
public class WarehousehomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehousehomeApplication.class, args);
    }

}
