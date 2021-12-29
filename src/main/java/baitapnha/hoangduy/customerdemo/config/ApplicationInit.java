package baitapnha.hoangduy.customerdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Ramesh Fadatare
 */
public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {
 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppContext.class };
		//return null;
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ApplicationConfig.class };
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
 
}