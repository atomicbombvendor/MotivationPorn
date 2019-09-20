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