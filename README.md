配合有道云上的笔记，此处为springcloud的练手项目

#### 1-eureka-server
注册中心

- 参考https://www.cnblogs.com/jing99/p/11576133.html

#### 2-eureka-client
- 演示客户端
- 改造支持hystrix

#### 3-greet-service
- 演示 ribbon + rest 调用远程服务`eureka-client`
- feign
- hystrix
- hystrix-board

#### 4- hystrix-turbine-server
- 支持多接点聚合

#### 5-zuul-server
 网关服务
 - 前端请求先通过nginx走到zuul网关服务，zuul负责路由转发、请求过滤等网关接入层的功能，默认和ribbon整合实现了负载均衡
