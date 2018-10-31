package com.vipul.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Scope(value = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class WebsocketScopedService implements BaseService {

}
