package com.xiemu.springcloud.demo.eurekaclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: springcloud-xiemu-demo
 * @Package: com.xiemu.springcloud.demo.eurekaclient
 * @ClassName: TestController
 * @Author: taozhaoyang
 * @Description:
 * @Date: 2019-10-21 17:39
 * @Version: 1.0
 */
@RestController
public class TestController {


    @Value("${server.port}")
    private String port;


    @RequestMapping("/sayHello")
    @HystrixCommand(fallbackMethod = "sayHelloFallback")
    public String home(@RequestParam String name) {
        return "hello, " + name + " from port:" +port;
    }

    public String sayHelloFallback(String name) {
        return "error, " + name;
    }
}
