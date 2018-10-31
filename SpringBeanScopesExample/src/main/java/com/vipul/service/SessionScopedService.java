package com.vipul.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class SessionScopedService implements BaseService {
}