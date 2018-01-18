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



工程进度：
1.SpringBoot 1.5.8.RELEASE
2.数据库mysql
3.集成mybatis 1.3.0
4.集成druid 1.1.0
5.集成fastjson 1.2.8
6.集成freemark 1.5.8.RELEASE
7.集成swagger
8.集成shiro，实现基础认证和权限管理
9.集成redis

待进行：
1.实现简单分表
