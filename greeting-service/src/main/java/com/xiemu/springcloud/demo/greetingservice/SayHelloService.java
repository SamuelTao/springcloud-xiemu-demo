package com.xiemu.springcloud.demo.greetingservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: springcloud-xiemu-demo
 * @Package: com.xiemu.springcloud.demo.greetingservice
 * @ClassName: SayHelloService
 * @Author: taozhaoyang
 * @Description: 使用FeignClient 替代ribbon,
 * @Date: 2019-10-21 18:57
 * @Version: 1.0
 */


@FeignClient(value = "eureka-client",fallback = SayHelloServiceFallback.class)
public interface SayHelloService {

    /**
     * @Method
     * @Author taozhaoyang
     * @Version  1.0
     * @Description
     @RequestParam("name") 写成@RequestParam 默认的报错
     * @Return
     * @Exception
     * @Date 2019-10-21 19:19
     */
    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    String sayHello(@RequestParam("name") String name);

}
