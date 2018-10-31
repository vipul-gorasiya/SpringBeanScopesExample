package com.vipul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipul.SingletonWithPrototypeExampleController1.ResponseObj;
import com.vipul.service.singletonwithprototype.ApplicationContextAwareService;
import com.vipul.service.singletonwithprototype.ContainsAppContextService;
import com.vipul.service.singletonwithprototype.ScopedProxyExampleService;

@RestController
public class SingletonWithPrototypeExampleController2 {
	@Autowired
	private ApplicationContextAwareService applicationContextAwareService;
	@Autowired
	private ContainsAppContextService containsAppContextService;
	@Autowired
	private ScopedProxyExampleService scopedProxyExampleService;

	@RequestMapping("/singleton2")
	public ResponseObj printObjects() {
		ResponseObj responseObj = new ResponseObj();
		responseObj.setApplicationContextAwareService(applicationContextAwareService.printAndReturnToString());
		responseObj.setContainsAppContextService(containsAppContextService.printAndReturnToString());
		responseObj.setScopedProxyExampleService(scopedProxyExampleService.printAndReturnToString());
		return responseObj;
	}

}
