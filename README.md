版权声明：CMS（https://github.com/15651037763/cms ）为开源项目，但仅限学习、交流使用，请勿应用于任何商业用途，项目团队保留所有版权。
该项目为小伙伴学习研究SpringBoot及相关开源资料的产品，发现BUG还望不吝赐教。

搭建本地工程步骤
1.jdk版本 1.8
2.请修改application.yml中的数据源
3.在本地数据库运行sql目录下的sql文件
4.运行项目，访问http://localhost:8080/demo/getAll/ 可以看见demo例子
5.测试权限：访问demo除外的地址会被拦截。
admin--112233登陆为管理员权限，可以访问http://http://localhost:8080/admin/testAuthorization
17040406--112233登陆为guest权限，无权访问http://http://localhost:8080/admin/testAuthorization
6.swagger-ui页面：http://localhost:8080/swagger-ui.html

已完成：
1.SpringBoot 1.5.8.RELEASE，数据库mysql，连接池druid 1.1.0，fastjson 1.2.8，分页pagehelper1.2.3
2.集成mybatis 1.3.0，封装mybatis实现基础增删改查
3.集成freemark 1.5.8.RELEASE，实现一个demo
4.集成swagger，实现一个用户管理的restful demo
5.集成shiro，实现基础认证和权限管理例子
6.集成redis，实现一个查询demo

待进行：
1.SpringBoot定时任务
2.SpringBoot邮件服务
3.实现简单分库分表
