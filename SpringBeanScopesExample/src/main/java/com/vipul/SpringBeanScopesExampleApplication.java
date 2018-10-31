package com.vipul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.vipul.service.SingletonScopedService;

@SpringBootApplication
@EnableWebSocketMessageBroker
public class SpringBeanScopesExampleApplication implements WebSocketMessageBrokerConfigurer {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext1 = SpringApplication
				.run(SpringBeanScopesExampleApplication.class, args);
		// Created another container which will have its own instance of singleton bean
		ConfigurableApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(SingletonScopedService.class);
		SingletonScopedService sbean = applicationContext1.getBean(SingletonScopedService.class);
		SingletonScopedService sbean2 = applicationContext2.getBean(SingletonScopedService.class);
		System.out.println("SingletonScopedService instance from applicationContext1 : " + sbean.toString());
		System.out.println("SingletonScopedService instance from applicationContext2 : " + sbean2.toString());
		applicationContext2.close();
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocket").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app");
		config.enableSimpleBroker("/topic", "/queue");
	}
}
