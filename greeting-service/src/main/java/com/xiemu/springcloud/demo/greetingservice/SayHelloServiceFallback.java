package com.xiemu.springcloud.demo.greetingservice;

import org.springframework.stereotype.Service;

/**
 * @ProjectName: springcloud-xiemu-demo
 * @Package: com.xiemu.springcloud.demo.greetingservice
 * @ClassName: SayHelloServiceFallback
 * @Author: taozhaoyang
 * @Description:
 * @Date: 2019-10-21 19:22
 * @Version: 1.0
 */

@Service
public class SayHelloServiceFallback implements SayHelloService {
    @Override
    public String sayHello(String name) {
        return "error,"+name;
    }
}
