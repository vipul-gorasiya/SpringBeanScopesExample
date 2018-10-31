package com.vipul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vipul.service.ApplicationScopedService;
import com.vipul.service.PrototypeScopedService;
import com.vipul.service.RequestScopedService;
import com.vipul.service.SessionScopedService;
import com.vipul.service.SingletonScopedService;

@RestController
public class AppRestController {

	@Autowired
	private ApplicationScopedService applicationScopedService;

	@Autowired
	private PrototypeScopedService prototypeScopedService;

	@Autowired
	private RequestScopedService requestScopedService;

	@Autowired
	private SessionScopedService sessionScopedService;

	@Autowired
	private SingletonScopedService singletonScopedService;

	@RequestMapping("/")
	public ResponseEntity<ResponseText> root() {
		return new ResponseEntity<>(buildText(), HttpStatus.OK);
	}

	private ResponseText buildText() {
		ResponseText text = new ResponseText();
		text.setApplicationBean(applicationScopedService.printAndReturnToString());
		text.setSingletonBean(singletonScopedService.printAndReturnToString());
		text.setPrototypeBean(prototypeScopedService.printAndReturnToString());
		text.setSessionBean(sessionScopedService.printAndReturnToString());
		text.setRequestBean(requestScopedService.printAndReturnToString());
		return text;
	}

}
