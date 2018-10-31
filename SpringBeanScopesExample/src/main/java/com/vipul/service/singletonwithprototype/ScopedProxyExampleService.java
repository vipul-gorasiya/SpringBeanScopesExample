package com.vipul.service.singletonwithprototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.vipul.service.BaseService;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Service
public class ScopedProxyExampleService implements BaseService {

	@Autowired
	private PrototypeScopedService2 prototypeScopedService2;

	@Override
	public String printAndReturnToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Singleton Bean : ").append(this.toString()).append(" has Prototype Bean : ")
				.append(this.prototypeScopedService2.toString());
		return builder.toString();
	}
}
