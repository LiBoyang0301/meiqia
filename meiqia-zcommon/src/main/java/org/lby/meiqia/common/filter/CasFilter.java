package org.lby.meiqia.common.filter;

import org.lby.meiqia.common.util.CookieUtils;
import org.lby.meiqia.common.util.StringUtils;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CasFilter implements Filter {
    public static final String USER_INFO = "user";

    private RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //如果未登陆状态，进入下面逻辑
        String requestUrl = request.getServletPath();
        if (!"/toLogin".equals(requestUrl) && !requestUrl.startsWith("/login")&&!isLogin(request)) {

            /**
             * ticket为空，或无对应sessionid为空
             * --- 表明不是自动登陆请求--直接强制到登陆页面
             */
            String ticket = request.getParameter("ticket");

            BoundValueOperations ops = redisTemplate.boundValueOps(ticket);
            if (null == ticket || null == ops.get()) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("http://cas.com:9091/toLogin?url=" + request.getRequestURL().toString());
                return;
            }

            /**
             * 是自动登陆请求，则种cookie值进去---本次请求是302重定向
             * 重定向后的下次请求，自带本cookie，将直接是登陆状态
             */

            //把sessionID种到http://a.com/ cookie
            CookieUtils.onNewSession(request, (HttpServletResponse) servletResponse);

            //重定向自流转一次，原地跳转重向一次 刷新页面
            // HttpServletResponse response = (HttpServletResponse) servletResponse;
            // response.sendRedirect(request.getRequestURL().toString());
            // return;
        }

        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private boolean isLogin(HttpServletRequest request) {
        String sessionId = CookieUtils.getRequestedSessionId(request);
        return StringUtils.isNotEmpty(sessionId);
    }

}
