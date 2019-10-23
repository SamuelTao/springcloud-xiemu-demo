package com.xiemu.springcloud.demo.greetingservice;

import org.springframework.beans.factory.annotation.Autowired;
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

//    @Autowired
//    private GreetService greetService;



    @Autowired
    private SayHelloService sayHelloService;

    @RequestMapping("/greet")
    public String greet(@RequestParam String name) {
        //return greetService.greeting(name);

        return sayHelloService.sayHello(name);
    }



}
