package com.skillstorm.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Lifecycle of a Spring Bean: fan fave interview question
 * 
 * Spring gives you 110% control over instantiation
 * 
 * @author PWalsh
 *
 */
@Component(value = "skynet")
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Lion implements BeanNameAware, 
	ApplicationContextAware, InitializingBean, DisposableBean {
	
	@Autowired
	private Mittens mittens;
	private String beanName;
	private ApplicationContext applicationContext;
	
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println("BeanNameAware: " + this.beanName);
	}
	
	public Lion() {
		System.out.println("Instantiate");
	}

	public void setMittens(Mittens mittens) {
		this.mittens = mittens;
		System.out.println("Populate properties (DI)");
		// @Autowired uses introspection to directly set the field 
	}
	
	public void makeFriend() {
		// stateful bean creation: please inject AppContext to get that bean
		System.out.println("My new friend: " + applicationContext.getBean(Lion.class));
	}

	public void roar() {
		System.out.println("Meow, but with murder mittens: " + this.mittens);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		System.out.println("ApplicationContextAware: " + this.applicationContext);
	}

	/**
	 * Kinda like an init() method
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean: afterPropertiesSet()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean: destroy()");
	}
	
}










