package cn.com.eshop.admin.controller;

import cn.com.eshop.common.vo.CommonInstance;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author niejian
 * @date 2019/7/7
 */

@Controller
@RequestMapping(value = "/captcha")
public class KaptchaController {

    @Autowired
    private DefaultKaptcha producer;

    @ResponseBody
    @GetMapping(value = "/getCaptcha")
    public void captcha(HttpServletRequest request,
                                       HttpServletResponse response) throws ServletException, IOException {

        byte[] captchaChallengeAsJpeg = null;

        // 生成文字验证码
        String text = producer.createText();
        // 将验证码存放到session中，登录的时候做比较
        HttpSession session = request.getSession();
        session.setAttribute(CommonInstance.LOGIN_VALIFY_CODE, text);

        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = producer.createImage(text);

        outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);

        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = outputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
//        response.setDateHeader("Expires", 0);
        response.setContentType("image/png");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        try {
            responseOutputStream.write(captchaChallengeAsJpeg);
            responseOutputStream.flush();
            responseOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != responseOutputStream) {

                responseOutputStream.close();

            }

            if (null != outputStream) {
                outputStream.close();
            }
        }


    }

}
