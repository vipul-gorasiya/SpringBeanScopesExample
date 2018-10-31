package com.vipul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipul.service.singletonwithprototype.ApplicationContextAwareService;
import com.vipul.service.singletonwithprototype.ContainsAppContextService;
import com.vipul.service.singletonwithprototype.ScopedProxyExampleService;

@RestController
public class SingletonWithPrototypeExampleController1 {

	@Autowired
	private ApplicationContextAwareService applicationContextAwareService;
	@Autowired
	private ContainsAppContextService containsAppContextService;
	@Autowired
	private ScopedProxyExampleService scopedProxyExampleService;

	@RequestMapping("/singleton1")
	public ResponseObj printObjects() {
		ResponseObj responseObj = new ResponseObj();
		responseObj.setApplicationContextAwareService(applicationContextAwareService.printAndReturnToString());
		responseObj.setContainsAppContextService(containsAppContextService.printAndReturnToString());
		responseObj.setScopedProxyExampleService(scopedProxyExampleService.printAndReturnToString());
		return responseObj;
	}

	static class ResponseObj {
		String applicationContextAwareService;
		String containsAppContextService;
		String scopedProxyExampleService;

		public String getApplicationContextAwareService() {
			return applicationContextAwareService;
		}

		public void setApplicationContextAwareService(String applicationContextAwareService) {
			this.applicationContextAwareService = applicationContextAwareService;
		}

		public String getContainsAppContextService() {
			return containsAppContextService;
		}

		public void setContainsAppContextService(String containsAppContextService) {
			this.containsAppContextService = containsAppContextService;
		}

		public String getScopedProxyExampleService() {
			return scopedProxyExampleService;
		}

		public void setScopedProxyExampleService(String scopedProxyExampleService) {
			this.scopedProxyExampleService = scopedProxyExampleService;
		}

	}

}
