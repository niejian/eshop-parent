package cn.com.eshop.admin.controller;/**
 * Created by niejian on 2019/6/16.
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 拦截系统的403,404,500 错误跳转到自定义的页面
 * @author niejian
 * @date 2019/6/16
 */
@Slf4j
@Controller
public class AdminErrorController implements ErrorController {
    @Autowired
    private ErrorAttributes errorAttributes;
    private final static String ERROR_PATH = "/error";


    @Override
    public String getErrorPath() {
        return null;
    }

         /**
     * Supports the HTML Error View
     * @param request
     * @return
     */
    @RequestMapping(value = ERROR_PATH, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        Map<String, Object> map = getAttributes(request, false);
        ModelAndView mav = null;

        Integer status = (Integer) map.get("status");
        if (status == 404){
            mav = new ModelAndView("error/404", map);
        } else if (status == 403){
            mav = new ModelAndView("error/403", map);
        } else if (status == 500){
            mav = new ModelAndView("error/500", map);
        }

        return mav;
    }

    private Map<String, Object> getAttributes(HttpServletRequest request,
                                              boolean includeStackTrace) {
        WebRequest requestAttributes = new ServletWebRequest(request);
        Map<String, Object> map = this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
        String URL = request.getRequestURL().toString();
        map.put("URL", URL);
        log.debug("AppErrorController.method [error info]: status-" + map.get("status") +", request url-" + URL);
        return map;
    }

}
