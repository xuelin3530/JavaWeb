### 编写代码完成如下功能：
- 登陆页面输入用户名和密码
- 如果登陆成功，则显示所有登陆者的用户名和信息，并且打印此表中所有的信息  
- 如果登陆失败，显示错误信息
如图
<br	>
		
### 思路：
* 登录页面用HTML
* 和数据库作比较
* JavaBean类（导入）
* DBUtil类（导入）
* UserDao、Servlet
++ Servlet接受一个请求以后，调用Dao类的操作，然后判断登录是否成功
++ 直接创建servlet会自动配置xml文件
++ 重写doGEt方法
++ 编写HTML页面，两个登录窗口（POST和GET）
++ 以上为方法一，servlet直接调用DAO

* 方法二：增加一个包：service——业务逻辑层
++ 创建UserService类调用Dao

<br>
<div align="center">
    <img src="/test1.png" width="200px" >
</div>

### 总结：

#### 项目的结构
1. 数据访问Dao
2. 业务逻辑Service
3. 控制层 Servlet
4. 中间用于保存数据的是JavaBean
- 请求发送给 Servlet 
- Servlet 调用  Service  
- Service 调用 DaoDao
- DaoDao 数据 返回  Service   
- Service 返回  Servlet 
- Servlet 响应浏览器

#### 如果当前需要处理，例如登录只需要真假值，不需要其他信息，那我就在service获取UserDao返回的user然后判断；如果不需要处理，直接返回UserDao的对应方法即可。
