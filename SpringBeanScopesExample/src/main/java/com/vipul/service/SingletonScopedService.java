package com.vipul.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Service
public class SingletonScopedService implements BaseService {

}
