package com.xiemu.springcloud.demo.zuulserver;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: springcloud-xiemu-demo
 * @Package: com.xiemu.springcloud.demo.zuulserver
 * @ClassName: UserInfoFilter
 * @Author: taozhaoyang
 * @Description:
 * @Date: 2019-10-23 17:08
 * @Version: 1.0
 */

@Service
public class UserInfoFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(UserInfoFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

        Object userId = request.getParameter("userId");

        if(userId == null) {
            logger.warn("userId is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("userId is empty");
            }catch (Exception e){}

            return null;
        }

        logger.info("ok");
        return null;
    }
}
