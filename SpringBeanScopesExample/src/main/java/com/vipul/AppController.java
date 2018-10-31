package com.vipul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import com.vipul.service.ApplicationScopedService;
import com.vipul.service.PrototypeScopedService;
import com.vipul.service.RequestScopedService;
import com.vipul.service.SessionScopedService;
import com.vipul.service.SingletonScopedService;
import com.vipul.service.WebsocketScopedService;

@Controller
public class AppController {

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

	@Autowired
	private WebsocketScopedService websocketScopedService;

	private ResponseText buildText() {
		ResponseText text = new ResponseText();
		text.setApplicationBean(applicationScopedService.printAndReturnToString());
		text.setSingletonBean(singletonScopedService.printAndReturnToString());
		text.setPrototypeBean(prototypeScopedService.printAndReturnToString());
		text.setSessionBean(sessionScopedService.printAndReturnToString());
		text.setWebsocketBean(websocketScopedService.printAndReturnToString());
		text.setRequestBean(requestScopedService.printAndReturnToString());
		return text;
	}

	@MessageMapping("/websocket")
	@SendToUser("/queue/reply")
	public String handle(String greeting) {
		ResponseText text = buildText();
		System.out.println(text);
		return text.toString();
	}
}
