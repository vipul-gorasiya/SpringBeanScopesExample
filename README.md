# Spring Bean Scopes examples

## How is it used in example

1. AppRestController uses request, session, singleton, application, prototype
2. AppController2 uses request, session, singleton, application, prototype. It is written to show example of prototype. This will get different instance than AppRestController.
3. com.vipul.service.singletonwithprototype package has three examples showing different approaches to have prototype bean in singleton bean.

## Importing and running project

1. Import project as Maven project
2. Run application as Spring Boot Application


Test results Exmaple:

1. http://localhost:8080/  Request1:

{
    "requestBean": "com.vipul.service.RequestScopedService@76a69702",
    "websocketBean": null,
    "sessionBean": "com.vipul.service.SessionScopedService@1e31fe56",
    "singletonBean": "com.vipul.service.SingletonScopedService@702b5dd0",
    "prototypeBean": "com.vipul.service.PrototypeScopedService@4ebf7532",
    "applicationBean": "com.vipul.service.ApplicationScopedService@7659ed99"
}

2. http://localhost:8080/  Request2:
 - Note: Different RequestBean. But, All other beans are same.
 
{
    "requestBean": "com.vipul.service.RequestScopedService@1a4c3caf",
    "websocketBean": null,
    "sessionBean": "com.vipul.service.SessionScopedService@1e31fe56",
    "singletonBean": "com.vipul.service.SingletonScopedService@702b5dd0",
    "prototypeBean": "com.vipul.service.PrototypeScopedService@4ebf7532",
    "applicationBean": "com.vipul.service.ApplicationScopedService@7659ed99"
}

3. http://localhost:8080/  Reqeust3 after clearing cookie for new session:
 - Note: Different requestBean and sessionBean. But, All other beans are same.
 
{
    "requestBean": "com.vipul.service.RequestScopedService@62c5a7d3",
    "websocketBean": null,
    "sessionBean": "com.vipul.service.SessionScopedService@6c025423",
    "singletonBean": "com.vipul.service.SingletonScopedService@702b5dd0",
    "prototypeBean": "com.vipul.service.PrototypeScopedService@4ebf7532",
    "applicationBean": "com.vipul.service.ApplicationScopedService@7659ed99"
}

4. http://localhost:8080/anotherapi  Request4 to another controller: 
 - Note: Different requestBean and prototype. But, All other beans are same.
 
{
    "requestBean": "com.vipul.service.RequestScopedService@79f80a60",
    "websocketBean": null,
    "sessionBean": "com.vipul.service.SessionScopedService@6c025423",
    "singletonBean": "com.vipul.service.SingletonScopedService@702b5dd0",
    "prototypeBean": "com.vipul.service.PrototypeScopedService@773ffaf7",
    "applicationBean": "com.vipul.service.ApplicationScopedService@7659ed99"
}

5. http://localhost:8080/singleton1 Request:
{
    "applicationContextAwareService": "Singleton Bean : com.vipul.service.singletonwithprototype.ApplicationContextAwareService@1ecac6fe has Prototype Bean : com.vipul.service.PrototypeScopedService@5d21da03",
    "containsAppContextService": "Singleton Bean : com.vipul.service.singletonwithprototype.ContainsAppContextService@3818ee80 has Prototype Bean : com.vipul.service.PrototypeScopedService@3bf9fb3d",
    "scopedProxyExampleService": "Singleton Bean : com.vipul.service.singletonwithprototype.ScopedProxyExampleService@73cc378a has Prototype Bean : com.vipul.service.singletonwithprototype.PrototypeScopedService2@15b1fdb5"
}

6. http://localhost:8080/singleton2 Request:
 - Note: Singleton beans are same but having differnt instances of Prototype beans than previous request.
{
    "applicationContextAwareService": "Singleton Bean : com.vipul.service.singletonwithprototype.ApplicationContextAwareService@1ecac6fe has Prototype Bean : com.vipul.service.PrototypeScopedService@541c625d",
    "containsAppContextService": "Singleton Bean : com.vipul.service.singletonwithprototype.ContainsAppContextService@3818ee80 has Prototype Bean : com.vipul.service.PrototypeScopedService@5adb96ae",
    "scopedProxyExampleService": "Singleton Bean : com.vipul.service.singletonwithprototype.ScopedProxyExampleService@73cc378a has Prototype Bean : com.vipul.service.singletonwithprototype.PrototypeScopedService2@5ee4092d"
}
