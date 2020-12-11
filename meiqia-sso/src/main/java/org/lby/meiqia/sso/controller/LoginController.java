package org.lby.meiqia.sso.controller;

import org.lby.meiqia.common.struct.Result;
import org.lby.meiqia.common.util.CookieUtils;
import org.lby.meiqia.common.util.StringUtils;
import org.lby.meiqia.sso.vo.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping
@CrossOrigin
public class LoginController {
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("toLogin")
    public Result toLogin(HttpServletRequest request){
        String sessionId = CookieUtils.getRequestedSessionId(request);

        if(StringUtils.isEmpty(sessionId)){
            String url = request.getParameter("url");
            return new Result(true, 10001, "未登录", url);
        }

        // 生成凭证-->b.com
        String ticket = UUID.randomUUID().toString();
        // 保存到Redis 中 k v
        BoundValueOperations ops = redisTemplate.boundValueOps(ticket);

        ops.set(sessionId);
        ops.expire(1, TimeUnit.HOURS);

        return new Result(true,20001,"登陆成功",ticket);
    }

    @RequestMapping("login")
    public Result login(@RequestBody UserForm userForm, HttpServletRequest request, HttpServletResponse response){
        //TODO 验证用户名和密码

        // 验证成功
        HttpSession session = request.getSession();
        session.setAttribute("user_info",userForm);
        // 存入到cas cookie中
        CookieUtils.onNewSession(request,response);

        // 生成凭证-->a.com
        String ticket = UUID.randomUUID().toString();
        // 保存到Redis 中 k v
        BoundValueOperations ops = redisTemplate.boundValueOps(ticket);

        ops.set(session.getId());
        ops.expire(1, TimeUnit.HOURS);

        return new Result(true,20001,"登陆成功",ticket);
    }
}
