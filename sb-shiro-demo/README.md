# spring boot shiro jwt 整合

## shiro中默认的过滤器

### 身份验证相关的

默认拦截器名 | 拦截器类 | 说明（括号里的表示默认值）
-- | -- | --
anon | org.apache.shiro.web.filter.authc.AnonymousFilter | 匿名拦截器，即不需要登录即可访问；一般用于静态资源过滤；示例“/static/**=anon”
authc | org.apache.shiro.web.filter.authc.FormAuthenticationFilter |  passwordParam：表单提交的密码参数名（password）； rememberMeParam：表单提交的密码参数名（rememberMe）；  loginUrl：登录页面地址（/login.jsp）；successUrl：登录成功后的默认重定向地址； failureKeyAttribute：登录失败后错误信息存储key（shiroLoginFailure）；
authcBasic | org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter | Basic HTTP身份验证拦截器，主要属性： applicationName：弹出登录框显示的信息（application）；
logout | org.apache.shiro.web.filter.authc.LogoutFilter | 退出拦截器，主要属性：redirectUrl：退出成功后重定向的地址（/）;示例“/logout=logout”
user | org.apache.shiro.web.filter.authc.UserFilter | 用户拦截器，用户已经身份验证、记住我登录的都可；示例“/**=user”

### 授权相关的

默认拦截器名 | 拦截器类 | 说明（括号里的表示默认值）
-- | -- | --
roles | org.apache.shiro.web.filter.authz.RolesAuthorizationFilter | 角色授权拦截器，验证用户是否拥有所有角色；主要属性： loginUrl：登录页面地址（/login.jsp）；unauthorizedUrl：未授权后重定向的地址；示例“/admin/**=roles[admin]”
perms | org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter | 权限授权拦截器，验证用户是否拥有所有权限；属性和roles一样；示例“/user/**=perms["user:create"]”
port | org.apache.shiro.web.filter.authz.PortFilter | 端口拦截器，主要属性：port（80）：可以通过的端口；示例“/test= port[80]”，如果用户访问该页面是非80，将自动将请求端口改为80并重定向到该80端口，其他路径/参数等都一样
rest | org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter | rest风格拦截器，自动根据请求方法构建权限字符串（GET=read, POST=create,PUT=update,DELETE=delete,HEAD=read,TRACE=read,OPTIONS=read, MKCOL=create）构建权限字符串；示例“/users=rest[user]”，会自动拼出“user:read,user:create,user:update,user:delete”权限字符串进行权限匹配（所有都得匹配，isPermittedAll）；
ssl | org.apache.shiro.web.filter.authz.SslFilter | SSL拦截器，只有请求协议是https才能通过；否则自动跳转会https端口（443）；其他和port拦截器一样；

### 其他

默认拦截器名 | 拦截器类 | 说明（括号里的表示默认值）
-- | -- | --
noSessionCreation | org.apache.shiro.web.filter.session.NoSessionCreationFilter | 不创建会话拦截器，调用 subject.getSession(false)不会有什么问题，但是如果 subject.getSession(true)将抛出 DisabledSessionException异常；