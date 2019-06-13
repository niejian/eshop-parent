package cn.com.eshop.admin.utils;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import freemarker.ext.jsp.TaglibFactory;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * @author: nj
 * @date: 2019-06-06:15:09
 */
public class ClassPathTldsLoader {

    /**
     * 指定路径
     */
    private static final String SECURITY_TLD = "/security.tld";

    final private List<String> classPathTlds;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public ClassPathTldsLoader(String... classPathTlds) {
        //super();
        if(ArrayUtils.isEmpty(classPathTlds)){
            this.classPathTlds = Arrays.asList(SECURITY_TLD);
        }else{
            this.classPathTlds = Arrays.asList(classPathTlds);
        }




    }


    @PostConstruct
    public void loadClassPathTlds() {
        TaglibFactory taglibFactory = freeMarkerConfigurer.getTaglibFactory();
        taglibFactory.setClasspathTlds(this.classPathTlds);
        if(taglibFactory.getObjectWrapper() == null) {
            taglibFactory.setObjectWrapper(freeMarkerConfigurer.getConfiguration().getObjectWrapper());
        }
    }
}
