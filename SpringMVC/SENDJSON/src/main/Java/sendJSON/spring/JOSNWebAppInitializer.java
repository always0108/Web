package sendJSON.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JOSNWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 创建ContextLoaderListener应用上下文
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class};
    }

    // 创建DispatcherServlet应用上下文
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class};
    }

    // 将DispatcherServlet映射到/
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
