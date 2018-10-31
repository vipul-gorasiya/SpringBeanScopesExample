package com.vipul.service.singletonwithprototype;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.vipul.service.BaseService;
import com.vipul.service.PrototypeScopedService;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Service
public class ApplicationContextAwareService implements ApplicationContextAware, BaseService {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	private PrototypeScopedService prototypeScopedService;

	public PrototypeScopedService getPrototypeScopedService() {
		this.prototypeScopedService = this.applicationContext.getBean(PrototypeScopedService.class);
		return prototypeScopedService;
	}

	public void setPrototypeScopedService(PrototypeScopedService prototypeScopedService) {
		this.prototypeScopedService = prototypeScopedService;
	}

	@Override
	public String printAndReturnToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Singleton Bean : ").append(this.toString()).append(" has Prototype Bean : ")
				.append(this.getPrototypeScopedService().toString());
		return builder.toString();
	}

}
