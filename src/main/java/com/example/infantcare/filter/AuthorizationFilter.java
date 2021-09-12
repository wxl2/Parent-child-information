package com.example.infantcare.filter;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class AuthorizationFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("admin")==null&&request.getSession().getAttribute("user")==null
                &&request.getSession().getAttribute("store")==null){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                Map<String,Object> res = new HashMap<String,Object>();
                res.put("success",false);
                res.put("message","用户未登录");
                out = response.getWriter();
                out.append(res.toString());
                return false;
            }catch (Exception e){
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
        }else if(request.getSession().getAttribute("user")!=null){
            String url = request.getRequestURI();
            if(url.indexOf("admin")!=-1){
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                try {
                    Map<String,Object> res = new HashMap<String,Object>();
                    res.put("success",false);
                    res.put("message","权限不足");
                    out = response.getWriter();
                    out.append(res.toString());
                    return false;
                }catch (Exception e){
                    e.printStackTrace();
                    response.sendError(500);
                    return false;
                }
            }else if(url.indexOf("store")!=-1){
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                try {
                    Map<String,Object> res = new HashMap<String,Object>();
                    res.put("success",false);
                    res.put("message","请先注册为商家");
                    out = response.getWriter();
                    out.append(res.toString());
                    return false;
                }catch (Exception e){
                    e.printStackTrace();
                    response.sendError(500);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
