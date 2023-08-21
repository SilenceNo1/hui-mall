
======================================================================================
# 团购、秒杀、分销、优惠券等活动已经完成
# 真正开源做码云最开源的小程序商城。
# 后续spring-cloud架构、团长模式等陆续上线
======================================================================================




# 面向对象
* Open-Shop是企业在创立初期很好的技术基础框架，加快公司项目开发进度，当然也可以对现有的系统进行升级；
* 个人开发者也可以使用Open-Shop承接外包项目；
* 初学JAVA的同学可以下载源代码来进行学习交流；
* 有需要定制的可以联系微信（Max23010）。

# 技术框架
* 核心框架：Spring Framework 4
* 安全框架：Apache Shiro 1.2
* 视图框架：Spring MVC 4
* 持久层框架：MyBatis 3
* 数据库连接池：Alibaba Druid 1.0
* 日志管理：SLF4J 1.7、Log4j
* JS框架：Vue 2.5.1，iview，layer 3.0.3，jquery 2.2.4，jqgrid 5.1.1 
* CSS框架：Twitter bootstrap3.3.7。
* 富文本：froala_editor1.2.2

# 开发环境
建议开发者使用以下环境，这样避免版本带来的问题
* IDE:eclipse
* DB:Mysql5.8
* JDK:JAVA8
* WEB:Tomcat8

# 运行环境
* WEB服务器：Weblogic、Tomcat、WebSphere、JBoss、Jetty 等
* 数据库服务器：Mysql5.8
* 操作系统：Windows、Linux、Unix 等


# 快速体验
* 将Open-Shop项目源码通过maven形式导入eclipse；
* 导入Open-Shop.sql数据文件,注意：数据库使用utf-8编码； 
* 修改platform-admin/platform.properties文件中的数据库设置参数；
* tomcat中加载platform-framework项目
* 访问后台地址：http://ip|域名/项目发布名/
* 管理员账号，用户名：默认 密码：默认

# 小程序部署：
* 打开小程序工具；
* 选择你下载的源代码wx-mall小程序项目；
* 输入你的AppID；
* 填写你的项目名称；
* 进入之后修改config文件夹里的api.js文件，把NewApiRootUrl改为你后台接口地址即刻运行。

# 小程序演示地址
![小程序演示地址](https://images.gitee.com/uploads/images/2019/0316/170751_dac85a7a_81788.jpeg "嗨街二号小程序.jpg")
# 后端演示地址
https://shop.51shop.ink/demo/ 用户名:admin  密码:admin

# 小程序演示效果
![](https://images.gitee.com/uploads/images/2019/0625/104952_f9964aa6_1293644.png "前段演示")

# 后端登录界面
![登录界面](https://images.gitee.com/uploads/images/2019/0223/145541_ceb02a32_1293644.jpeg "登录，小程序商城")
# 主界面
![主界面](https://images.gitee.com/uploads/images/2019/0223/145546_1c4fc356_1293644.jpeg "主界面，插件商城")
# 菜单
![菜单](https://images.gitee.com/uploads/images/2019/0223/145541_2a1e5aba_1293644.png "菜单1")

本项目来自码云上platform-wechat-mall（https://gitee.com/fuyang_lipengjun/platform）项目。
我们修复了所有发现的bug，还有自己的新功能增加。
后面会有不断的更新新功能。

# 商业版本介绍
* 用户前端：基于uni-app开发。支持小程序、H5、安卓、IOS  多端程序
* 后台管理端：vue+vuex+elementUi+webPack.模块式开发
* 后台技术框架：spring cloud分布式应用。redis 分布式缓存、分布式主键。 mysql 读写分离，Solr 商品搜索引擎,mongodb ,rabbitmq。支持网关级别缓存。
* 并发支持：在4核CPU，8G内存主机上 支持到5K并发访问，支持横向扩展。
* 国际化：现已支持 泰国，英语，中文。
* 安全性：支持金融级别的安全校验（天府银行已上线）
* 程序稳定性：已上线多家客户（天府银行，跨境电商-杭州巨柏等），经过严苛生产验证。
* 营销工具：秒杀、团购、优惠券、限时购（团长，分销 ，ERP整合，在开发中）
* 平台模式：b2b2c 支持多模式切换
