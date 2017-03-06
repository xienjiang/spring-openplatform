package com.spring.cloud.openplatform.getway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Describe 访问权限过滤器，控制第三方对OpenApi的调用权限
 * @author xien.Jiang
 * @since 2017.02.21
 */
public class AccessPermissionFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessPermissionFilter.class);


    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型：
        1. pre：可以在请求被路由之前调用
        2. routing：在路由请求时候被调用
        3. post：在routing和error过滤器之后被调用
        4. error：处理请求时发生错误时被调用
     *  @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器执行开关
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    @Override
    public Object run() {
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();

        log.info("[AccessPermissionFilter]: {} request to {}",request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            log.error("access token is missing...");
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);//标识为未授权请求
            rc.setResponseBody("unauthorized");
            return null;
        }

        log.info("accesstoken validation pass!");
        return null;
    }

}