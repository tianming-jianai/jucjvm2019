### p38 juc介绍

#### java 面试问这些：

1. java面向对象、高级语法
   1. 抽象类和接口的区别、多线程的几种创建方法
2. java集合类
   1. java.util.*
   2. 谈谈hashmap的理解，说说put方法是咋整的，什么是hash算法，什么是hash碰撞（如何避免）-一道hashmap考你一天
3. java多线程
   1. 除非你不想去高鑫的互联网公司，去那些传统的企业做一些ssh，从上到下填一张表单，欧耶，这种大四实习生都能干，基本不值钱（6000），技术早已淘汰过时
   2. 小米9秒杀
   3. 大厂面试题就考这些，不会，你连面试资格都没有（蚂蚁金服）
   4. 不要会编码，还得能说（language is power）--彪悍的人生不需要解释，错的，老板需要你解释，客户需要你解释，女朋友需要你解释，
4. java io/nio

就考这四块
socket编程基本不会考，因为现在rpc调用都是用dubbo/springcloud微服务，这块底层（tcp/ip的封装）已经屏蔽了

1. automic 什么意思：原子性
2. 什么是进程/线程
   1. 进程：操作系统运行的一个程序
   2. 线程：word进程的拼写纠错功能
3. 什么是并发/并行
   1. 并发：同一个时间点，多个线程争抢同一个资源，12306/抢小米9
   2. 并行：多个线程同时运行

凡是复杂的东西，你没有一句话把它讲明白了，就说明你没有搞懂

### p39 卖票复习

java SE王牌讲师：韩顺平、宋红康
敲到手指疼，高手都是自己练出来的（郎朗，每天3个小时练习钢琴，敲到手指发热）
要对自己狠，不是随随便便说说话，谁不会说

多线程编程的企业级套路+模板

你们花了钱，到这里学真本事，别当闷葫芦
三拳打不出来一个屁，出去到外面混，基本上属于被裁的对象
会哭的孩子有奶吃
男人成大事，第一不要脸，第二坚持不要脸，第三坚持长期不要脸
最不值钱的就是面试，重要的是这个里子 -- 任正非

周阳牛逼顶个屁用，周阳最重要的作用是把你们变牛逼

经常要用的代码要提取成模板，代码成熟度，少些代码，好看又能打，写的又少又快，优秀的程序员都是懒人
不要傻不拉几，永远用最简单的方法

三种员工：
1+1+1.. = 8 一周上线，老黄牛，做牛肉干，态度端正，只能加薪，不能升职
2*4 = 8 3天上线，升职加薪，出刀比你快，效率比你高，未来的项目经理、技术经理，未来的中层
2^3 = 8 半天上线，升职加薪给股票，事业合伙人，拉进来，不能成为我的对手

优秀的程序员，既要低头干活更要抬头看路，动脑子是第一位的
不要以为勤劳是穷，多动脑子再动手
程序员是聪明的物种，傻叉干不了这一行

多学习大厂的优秀程序员，跟更优秀的人在一起，学他们的做事方法，
想掉都掉不下来，因为物以类聚，人以群分

手机给我静音，现在哪有比你找工作赚钱更重要的事情

### p40 卖票改写为lambdaExpress

tryLock()
缩小锁的粒度范围，这样我的并发性就更高

多线程.star()线程就立刻、马上启动了吗
   不知道，就绪状态，待CPU和操作系统的底层调动通知
学技术：深、透、明、细
学习的五个境界：皮、肉、骨、精、魂
（魂：教不了，高手都是自己练出来的）

多线程状态：NEW、RUNNABLE、BLOCKED、WAITING、TIMED_WAITING、TERMINATED

wait和sleep都会导致阻塞，暂停线程，这两个有什么区别？
   wait放开手去睡，放开手里的锁
   sleep紧握手去睡，醒了手里还有锁

基本功不能答错：
   port: redis 6379 mysql 3306
遇到一个题目就拿下一个题目，记住，反复积累，也许到最后就是成功连成片
就是一点一滴看不见的积累

学中干，干中学，这样才是最快的
永远不是准备好了才去动手
人生不是像做菜，不是所有材料都备齐了才下锅，只要有6层的把握就要去干，
发展中的问题就要在发展中解决，万事俱备也会只欠东风

上半年在尚硅谷学习理论知识，下半年在企业里继续领着薪水上自习

相信就能看见，念念不忘，必有回响

### p41 lambdaExpress练习

成功的道路都是想通的，因为不变的知识才是根本的最重要的

新来的小伙子不是来背书的，有自己对概念的理解，可以列举具体案例，一针见血说明白了
恭喜你，送你四个字：脱颖而出  有机会进入复试了

成功的路上根本不拥挤：因为靠苦、厉害坚持到底的人根本不多，但是你要掌握方法

1. lambda表达式
2. 函数式接口
3. 接口默认方法（面向接口编程）
4. 接口中的静态方法

面向对象、面向函数式接口、面向薪酬编程，到最后，老板给的钱不够，该跳跳，本事在你身上


### P49 list不安全

此处不留爷，自有留爷处

想拿高鑫，得有过人之处


### p52 map 不安全

张弛有度

一周到周末就不要再学新的了，
自己写个小周报，这周从周一到周六都学了点啥，知识点逐条理理，自己做个脑图
有一条过一条，查缺补漏，形成自己的周报的学习总结
例如：
这周重点JUC，一点一点过，所有知识点梳理一下，不懂的溜出来，后面慢慢的查缺补漏

但是，回答我，每周是不是应该做一次学习周报的总结，
不能学没学，学了，学到怎么样了，不知道，
理工男，数据说话，一切东西都要有时间建度，计划表，要可量化
今天假如周阳老师讲了100个知识点，
红：不懂的  黄：半懂不懂   绿：懂得
一定要给自己量化

人生如程序，不是选择就是循环

面试：项目经理的头五问一定要扛得住

