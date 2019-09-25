### Mango DB
> 不使用mango db，原因占用内存的关系，可能不太合适小机器。
> 需要分离mango db和服务部署的机器

### 系统设计
1. spring-boot
2. mysql
3. mybatis-plus
   
### spring-security
#### 校验顺序
1. jwtAuthenticationTokenFilter token认证，发现是不是带有token，解析用户的身份。
2. 在 config中配置的URL权限
3. RBAC自定义的权限认证
4. ROLE_XXX是角色。XXX是权限。
5. 密码解析的原理：https://www.jianshu.com/p/a3a05d227d1b
6. 相关博客：https://blog.csdn.net/larger5/article/details/81063438
https://blog.csdn.net/ech13an/article/details/80779973
7. 看懂源码：https://www.cnblogs.com/xuwenjin/p/9552303.html
8. 流程：如果配置了formlogin，会自动使用userDetailService自动的验证用户名和密码。如果不使用，则不会。

#### 使用缓存
1. ConcurrentHashMap
2. 放入token和userDetailService
3. logout时，清除session和缓存
4. 使用redis的示例：https://github.com/zzxzzxhao/springboot-springsecurity-ultimate-
5. 博客：
    上：https://blog.csdn.net/zzxzzxhao/article/details/83381876
    下： https://blog.csdn.net/zzxzzxhao/article/details/83412648

#### 原理
1. 一个请求一个线程
2. session是共享的
2. SecurityContextHolder.getContext()获取放入的认证信息
3. SecurityContextHolder相当于ThreadLocal（单线程共享）
4. 从 Session 中对认证信息的处理由 SecurityContextPersistenceFilter 来处理，它位于 Spring Security 过滤器链的最前面，它的主要作用是：
   1. 当请求时，检查 Session 中是否存在 SecurityContext，如果有将其放入到线程中。
   2. 当响应时，检查线程中是否存在 SecurityContext，如果有将其放入到 Session 中。
5. 得到认证信息后，进行chain filter中的匹配
6. 解释了共享session和context https://blog.csdn.net/qq_37142346/article/details/80032336