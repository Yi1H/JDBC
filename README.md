# JDBC
关于JDBC的学习
<p>初学Java JDBC手动编写了一些简单的测试类代码</p>
<p>理解了JDBC的运行过程：加载驱动->建立数据库连接->创建sql语句->处理sql语句->对返回结果的处理</p>
<p>在加载驱动的过程中提取了配置文件db.properties；运用了线程池来创建数据库连接；了解了用预处理（prepareStament）语句创建sql，prepareCall语句来处理存储过程；编写了批处理和事务的测试方法</p>
<p>运用了dao的思想（中间类）、domain的思想（JavaBean）、MSR数据库的映射、对包类起名的一些规范和内省和泛型</p>
