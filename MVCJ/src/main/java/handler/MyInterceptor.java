package handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HLF
 * @version V1.0
 * @package handler
 * @date 2021/11/7 9:25
 */
/**
 * 拦截器类：拦截用户的请求
 * @author ASUS
 * */

public class MyInterceptor implements HandlerInterceptor {

    /**
     * 验证用户登录的信息，正确返回true，错误返回false
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("perform_MyInterceptor  preHandle function ====");

        String loginName = "";
        Object name = request.getSession().getAttribute("name");
        if (name != null) {
            loginName = (String) name;
        }

//        if (!"zs".equals(loginName)) {
        if("zs".equals(loginName)) {
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }

        //zs登录
        return true;
    }
}



