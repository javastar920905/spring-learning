本项目示例 参照 http://spring.cndocs.tk/ 开发
# spring 框架基础概述 
spring 框架,为实现java应用程序提供了全面基础架构支持,你可以专注于应用开发,让spring处理基础架构问题
spring 使你能够使用纯粹的java对象来构建应用

# 背景
Java应用 — 运行着小到各种受限的小程序，大到n层结构的服务器端企业级应用 — 包含着相互协作的对象，从而创建正确的应用。 因此，程序里的对象彼此之间相互依赖。

尽管Java平台提供的很多功能性的应用程序，但是他缺少将这些基础组件组织成一个整体的方法，最终把这些整合工作交给了架构师或是开发者。 你可以使用设计模式，例如工厂，抽象工厂，建造者，装饰和服务定位来将这些不同的类和示例对象组合起来，从而构建一个应用。 但是，这些模式仅仅只是：一个被给予名字的最佳实践，说明了该模式做什么，怎样应用，解决了什么问题等等。 模式是形式化的，你必须在你的应用中去实现它。

Spring中的控制反转 (IoC)部分解决了这个问题，通过提供一种有效的方式将各个分开的组件组合成一个完全可供使用的应用。 Spring框架用函数化的形式实现了形式化的设计模式，这样你就可以在你的应用中继承它们。 很多组织个机构正在使用Spring框架来设计健壮的，便于维护的应用。

# 模块
Spring框架的各个特性被组织成20个模块。这些模块被分组成Core Container（核心容器）, Data Access/Integration（数据访问/集成）, Web（网络端）, AOP (Aspect Oriented Programming，切面编程), Instrumentation, Messaging（消息）,和Test（测试）
* 核心容器 包含了 spring-core, spring-beans, spring-context, and spring-expression (Spring表达式语言) 四个模块。

# spring 学习资源
* spring 官网  spring.io 
* 框架概述以及模块划分 http://spring.cndocs.tk/overview.html 
* 版本升级指南 https://github.com/spring-projects/spring-framework/wiki/Migrating-from-earlier-versions-of-the-spring-framework
* 系列deme入门指南 https://spring.io/guides
* maven BOM 文件概述 http://spring.cndocs.tk/overview.html#overview-maven-bom
* 核心技术目录 http://spring.cndocs.tk/spring-core.html
 

# 开发步骤
* 使用maven 或者gradle 等构建工具添加项目依赖

