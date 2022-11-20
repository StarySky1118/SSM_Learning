# 附录

## 各种依赖

### Mybatis 依赖

```xml
<!--Mybatis依赖-->
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>
```

### MySql 驱动依赖

```xml
<!--mysql驱动依赖-->
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
```

### junit 依赖

```xml
<!--junit依赖-->
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

### logback 依赖

```xml
<!--logback依赖-->
<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.11</version>
    <scope>test</scope>
</dependency>
```

### dom4j 

```xml
<!--dom4j依赖-->
<!-- https://mvnrepository.com/artifact/org.dom4j/dom4j -->
<dependency>
    <groupId>org.dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>2.1.3</version>
</dependency>
```

### jaxen

```xml
<!--jaxen依赖-->
<!-- https://mvnrepository.com/artifact/jaxen/jaxen -->
<dependency>
    <groupId>jaxen</groupId>
    <artifactId>jaxen</artifactId>
    <version>1.2.0</version>
</dependency>
```

### servlet

```xml
<!--servlet依赖-->
<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>
```

### Mybatis 集成 EhCache

```xml
<!-- https://mvnrepository.com/artifact/org.mybatis.caches/mybatis-ehcache -->
<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-ehcache</artifactId>
    <version>1.2.2</version>
</dependency>
```

### pageHelper

```xml
<!--pagehelper 依赖-->
<!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.3.1</version>
</dependency>
```

# 一、MyBatis 概述

MyBatis 是持久层框架。

JDBC 不足：

- sql 语句写死在 java 代码中

ORM 思想：对象关系映射

- O：Object，对象
- R：Relational，关系型数据库
- M：Mapping，映射

![image-20221107172710104](img/image-20221107172710104.png)

一条记录对应一个 java 对象。

MyBatis 就是一个 ORM 框架，可以实现记录与 java 对象的转换。半自动 ORM 框架，sql 语句需要程序员自己编写。Hibernate 就是全自动 ORM 框架。

# 二、Mybatis 入门程序

## 1、开发步骤

**建表**

![image-20221108084853463](img/image-20221108084853463.png)

**在 IDEA 中新建工程**

![image-20221108085821173](img/image-20221108085821173.png)

配置 JDK 和设置 Maven。

**新建模块**

![image-20221108090454888](img/image-20221108090454888.png)

>![image-20221108090655906](img/image-20221108090655906.png)
>
>resources 中一般放资源文件、配置文件。直接放到该目录下的资源等同于放到了类的根目录下。

**设置打包方式**

打包方式为 jar，需要部署到 Tomcat 服务器上则打包方式为 war。

![image-20221108091017907](img/image-20221108091017907.png)

```xml
<!--打包方式-->
<packaging>jar</packaging>
```

**引入依赖**

- mybatis 依赖
- mysql 驱动依赖

先添加一个 `dependencies` 标签，再复制依赖。

```xml
<!--Mybatis依赖-->
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.10</version>
</dependency>


<!--mysql驱动依赖-->
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
```

**编写 MyBatis 核心配置文件**

通用名称：mybatis-config.xml

> 只要知道通过该文件创建 SqlSessionFactory 对象。

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
  <environments default="development">
    <environment id="development">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="${driver}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
      </dataSource>
    </environment>
  </environments>
  <mappers>
    <mapper resource="org/mybatis/example/BlogMapper.xml"/>
  </mappers>
</configuration>
```

> mybatis 有两个核心配置文件：一个是 mybatis-config.xml，配置连接数据库信息（一个）；另一个是 xxxMapper.xml，专门用来编写 sql 语句（一个表一个）。

修改模板中的连接数据库配置。

**编写 xxxMapper.xml 文件**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.mybatis.example.BlogMapper">
  <select id="selectBlog" resultType="Blog">
    select * from Blog where id = #{id}
  </select>
</mapper>
```

修改 `namespace` 并添加一个 sql。

```xml
<mapper namespace="fuck_you">
    <insert id="">
        insert into t_car (id, car_num, brand, guide_price, produce_time, car_type)
        values (null, 1101, '宝宝巴士', 30.00, '2022-11-08', '燃油车')
    </insert>
</mapper>
```

> sql 语句没有高亮提示的解决：
>
> 将头部 https 改为 http。
>
> ```xml
> <!DOCTYPE mapper
>         PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
>         "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
> ```

**在 mybatis-config.xml 中关联 mapper**

```xml
<mappers>
    <!--自动在类的根路径下查找-->
    <mapper resource="carMapper.xml"/>
</mappers>
```

**编写 mybatis 程序**

mybatis 中专门执行 sql 语句的是 `sqlSession`。是 Java 程序与数据库之间的一次会话。

从 `sqlSessionFactory` 中获取 `sqlSession` (工厂模式)，而 `sqlSessionFactory` 对象需要使用 `sqlSessionFacotryBuilder` 创建。

mybatis 核心对象：

`sqlSessionFactoryBuilder` --> `sqlSessionFactory` --> `sqlSession`

```java
public static void main(String[] args) throws IOException {
    // 获取 sqlSessionFactoryBuilder 对象
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

    // 获取 sqlSessionFactory 对象，一般是一个数据库对应一个
    // Resources.getResourceAsStream 默认从类的根路径开始查找
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

    // 获取 sqlSession 对象
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // 执行 sql 语句
    int count = sqlSession.insert("insertCar");

    System.out.println(count > 0 ? "插入成功！" : "插入失败！");

    // 手动提交
    sqlSession.commit();
}
```

## 2、小细节

**SQL 语句分号问题**

mybatis 中 sql 语句 `;` 可加可不加。

**配置文件绑定问题**

凡是遇到 `Resources`，大部分是在类的根路径下开始查找，这种方式项目的可移植性很强。自己写的流使用绝对路径进行查找，如果部署到服务器上，还要更改源代码，项目可移植性很差。

使用如下代码也可以从类的根路径下查找资源：

```java
InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
```

经过源代码分析，mybatis 中 `Resources.getResourceAsStream()` 方法底层调用的就是上述方法。

**核心文件绑定 Mapper 问题**

也可以使用 url 方式进行绑定：

```xml
<mapper url="file:///d:CarMapper.xml"></mapper>
```

但这种方式可移植性差，不建议使用。

**Mybatis 中事务剖析**

在 Mybatis 核心配置文件中，使用 `transactionManager` 标签进行事务管理，例如：

```xml
<transactionManager type="JDBC"/>
```

`transactionManager` 的 `type` 值有两个：

- JDBC
- MANAGED

> 不区分大小写

两种事务管理器：

- JDBC 事务管理器：

  mybatis 自己采用原生 JDBC 管理事务。

  底层创建的事务管理器对象是 JDBC 事务管理器对象。

  在执行 `SqlSession sqlSession = sqlSessionFactory.openSession();` 时，底层会调用 `conn.setAutoCommit(false)`，开启事务。

- MANAGED 事务管理器：

  mybatis 不再负责管理事务，而是交给第三方容器，例如：spring。

  在执行 `SqlSession sqlSession = sqlSessionFactory.openSession();` 时，底层不会调用 `conn.setAutoCommit(false)`，也就不会开启事务。如果没有其他容器对事务进行管理，sql 语句会自动提交。

启发

​	只要 autoCommit 为 True，就表示没有开启事务。

## 3、一个完整的 MyBatis 程序

```java
public static void main(String[] args) {
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    SqlSession sqlSession = null;
    try {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession(); // 开启事务

        // 执行业务
        int count = sqlSession.insert("insertCar");
        System.out.println(count > 0 ? "添加成功！" : "添加失败");

        // 事务提交
        sqlSession.commit();

    } catch (IOException e) {
        e.printStackTrace();
        // 事务回滚
        sqlSession.rollback();
    } finally {
        // 关闭资源
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
```

## 4、Junit 的使用

做单元测试。单元测试类命名规范：测试类 + Test。测试方法名：test + 方法名。

两个重要概念：

- 实际值
- 期待值

使用断言判断实际值与期待值是否相等。

**依赖引入**

```xml
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

**具体编写**

要有呼应关系：

![image-20221109193346261](img/image-20221109193346261.png)

```java
public class UserServiceTest {
    @Test
    public void testSum() {
        UserService userService = new UserService();

        // 实际值
        int actual = userService.sum(1, 2);
        // 期待值
        int expected = 3;
        // 断言判断
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSub() {

    }
}
```

每个方法都得到测试。

在 Mybatis 程序中引入 junit。

## 5、MyBatis 中集成日志框架 LogBack

**相关背景**

在 Mybatis 核心配置文件中使用如下标签改变 Mybatis 运行时行为：

```xml
<settings>
    <setting name="" value=""/>
</settings>
```

日志创建相关：

![image-20221109195117267](img/image-20221109195117267.png)

`SLF` 是日志规范，而日志框架 `logback` 实现了 `SLF` 规范。

`STDOUT_LOGGING` 是标准日志，Mybatis 已经实现。

```xml
<settings>
    <setting name="logImpl" value="STDOUT_LOGGING"/>
</settings>
```

**集成步骤**

引入 `logback` 依赖：

```xml
<!-- https://mvnrepository.com/artifact/ch.qos.logback/logback-classic -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.11</version>
    <scope>test</scope>
</dependency>
```

引入 `logback` 所必需的 `xml` 文件：

- 名称必须为 `logback.xml` 或 `logback-test.xml`
- 必须放到类根路径下

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!-- 配置文件修改时重新加载，默认true -->
<configuration debug="false">

    <!-- 控制台输出 -->
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder" charset="UTF-8">
            <!-- 输出日志记录格式 -->
            <pattern>[%thread] %-5level %logger{50} - %msg%n</pattern>
        </encoder>
    </appender>
    
<!--    mybatis log configure-->
    <logger name="com.apache.ibatis" level="TRACE"/>
    <logger name="java.sql.Connection" level="DEBUG"/>
    <logger name="java.sql.Statement" level="DEBUG"/>
    <logger name="java.sql.PreparedStatement" level="DEBUG"/>
    

    <!-- 日志输出级别,LOGBACK日志级别包括五个：TRACE < DEBUG < INFO < WARN < ERROR-->
    <root level="DEBUG">
        <appender-ref ref="STDOUT"/>
        <appender-ref ref="FILE"/>
    </root>
</configuration>
```

使用单元测试就会输出相应信息。

## 6、封装 Mybatis 工具类

一个 `sqlSessionFactory` 对应一个数据库。

```java
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 类加载时，创建 sqlSessionFactory
     */
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 构造方法私有化
    private MybatisUtils() {
    }

    /**
     * 开启 sql 会话
     * @return sql 会话
     */
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }
}
```

# 三、使用 MyBatis 完成 CRUD

首先创建新模块，引入依赖，复制核心配置文件，复制工具类。

实现 CRUD 总体流程，写 sql，写 java。

## 1. 实现 insert

在 Mybatis 中占位符是 `#{}`，相当于 JDBC 中的 `?`。

**使用 Map 传参**

在 `CarMapper.xml` 中设置占位符，使用 Map 传参括号内填入键。

```xml
<insert id="insertCar">
    insert into t_car (id, car_num, brand, guide_price, produce_time, car_type) values (null, #{car_num}, #{brand}, #{guide_price}, #{produce_time}, #{car_type})
</insert>
```

`CarDao.java` 中方法编写：

```java
public void insertCar() {
    SqlSession sqlSession = null;
    Map<String, Object> map = new HashMap<>();
    map.put("car_num", "1102");
    map.put("brand", "特斯拉Model3");
    map.put("guide_price", 30.0);
    map.put("produce_time", "2022-11-09");
    map.put("car_type", "新能源");

    try {
        sqlSession = MybatisUtils.openSession(); // 开启事务

        // 执行业务
        // 第一个参数：sqlId 第二个参数：Object对象
        int count = sqlSession.insert("insertCar", map);
        System.out.println(count > 0 ? "添加成功！" : "添加失败");

        // 事务提交
        sqlSession.commit();

    } catch (Exception e) {
        e.printStackTrace();
        // 事务回滚
        sqlSession.rollback();
    } finally {
        // 关闭资源
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
```

**使用 pojo 传参**

编写 pojo 类：

```java
public class Car {
    private Integer id;
    private String carNum;
    private String brand;
    private BigDecimal guidePrice;
    private String produceTime;
    private String carType;
```

`CarDao.java` 中的方法：

```java
public void insertCar() {
    SqlSession sqlSession = null;
    Car car = new Car(null, "1103", "IQOO neo3", BigDecimal.valueOf(20), "2022-11-09", "燃油车");

    try {
        sqlSession = MybatisUtils.openSession(); // 开启事务

        // 执行业务
        int count = sqlSession.insert("insertCar", car);
        System.out.println(count > 0 ? "添加成功！" : "添加失败");

        // 事务提交
        sqlSession.commit();

    } catch (Exception e) {
        e.printStackTrace();
        // 事务回滚
        sqlSession.rollback();
    } finally {
        // 关闭资源
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
```

 `CarMapper.xml` 中进行配置：

括号中写的是 pojo 类中的属性(get方法后的就视为一个属性)。

```xml
<insert id="insertCar">
    insert into t_car (id, car_num, brand, guide_price, produce_time, car_type) values (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})
</insert>
```

## 2、实现 delete

`CarDao.java` 中 `deleteCarById()`：

```java
public void deleteCarById(Integer id) {
    SqlSession sqlSession = null;

    try {
        sqlSession = MybatisUtils.openSession(); // 开启事务

        // 执行业务
        int count = sqlSession.delete("deleteCarById", id);
        System.out.println(count > 0 ? "删除成功！" : "删除失败");

        // 事务提交
        sqlSession.commit();

    } catch (Exception e) {
        e.printStackTrace();
        // 事务回滚
        sqlSession.rollback();
    } finally {
        // 关闭资源
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
```

`CarMapper.xml` 中进行配置：

```xml
<delete id="deleteCarById">
    /*只有一个占位符，大括号内可以随便写*/
    delete from t_car where id = #{id}
</delete>
```

## 3、实现 update

在 `CarMapper.xml` 中写入 sql 语句：

```xml
<update id="updateCarById">
    update t_car set car_num = #{carNum}, brand = #{brand}, guide_price = #{guidePrice}, produce_time = #{produceTime}, car_type = #{carType} where id = #{id}
</update>
```

在 `CarDao.java` 中编写方法 `updateCar()`：

```java
public void updateCar(Car car) {
    SqlSession sqlSession = null;

    try {
        sqlSession = MybatisUtils.openSession(); // 开启事务

        // 执行业务
        int count = sqlSession.update("updateCarById", car);
        System.out.println(count > 0 ? "更新成功！" : "更新失败");

        // 事务提交
        sqlSession.commit();

    } catch (Exception e) {
        e.printStackTrace();
        // 事务回滚
        sqlSession.rollback();
    } finally {
        // 关闭资源
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
```

## 4、实现 select

### (1) 查一个

首先在 `CarMapper.xml` 中编写 sql 语句。

使用 Mybatis 中 `selectOne()` 方法可以将查询到的结果封装到对象中，在 `CarMapper.xml` 中指定对象的全类名。

查询到的字段名大概率和属性不匹配，使用 `as` 给列起别名。

> 直接将查询结果封装到 pojo 类中，整合了 dbutils。
>
> 同时，使用 Mybatis 获取连接也是使用连接池方式获取，这是 Druid 的功能。

```xml
<select id="selectById" resultType="pojo.Car">
    select id,
           car_num as carNum,
           brand,
           guide_price as guidePrice,
           produce_time as produceTime,
           car_type as carType
    from t_car
    where id = #{id}
</select>
```

`CarDao.java` 中编写 `queryById()` 方法：

使用到了 `sqlSession.selectOne(sql id, 属性对象) --> Object`。

将从数据库读出的字段数据填入 `Object` 属性中。

```java
public Car queryById(Integer id) {
    SqlSession sqlSession = null;
    Car car = null;

    try {
        sqlSession = MybatisUtils.openSession(); // 开启事务

        // 执行业务
        car = sqlSession.selectOne("selectById", id);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 关闭资源
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    return car;
}
```

### (2) 查所有

在 `CarMapper.xml` 中编写 sql 语句，指定元素的 pojo 全类名。

```xml
<select id="selectAll" resultType="pojo.Car">
    select id,
           car_num as carNum,
           brand,
           guide_price as guidePrice,
           produce_time as produceTime,
           car_type as carType
    from t_car
</select>
```

在 `CarDao.java` 中编写 `queryAllCars()` 方法：

使用到了 `sqlSession.selectList(sql id, 参数对象) --> List<Object>`。

```java
public List<Car> queryAllCars() {
    SqlSession sqlSession = null;
    List<Car> cars = new ArrayList<>();

    try {
        sqlSession = MybatisUtils.openSession(); // 开启事务

        // 执行业务
        cars = sqlSession.selectList("selectAll");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // 关闭资源
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    return cars;
}
```

## 5、Mapper 映射文件中 namespace

命名空间可以防止 sql id 冲突。在 java 程序中，使用 namespace.id。

# 四、Mybatis 核心配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!--configuration 根标签-->
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!--默认使用环境-->
    <environments default="development">
        <!--其中的一个环境，一个环境一般对应一个数据库-->
        <!--一个数据库对应一个 sqlSessionFactory 对象-->
        <!--因此一个环境对应一个 sqlSessionFactory 对象-->
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/bjpowernode"/>
                <property name="username" value="root"/>
                <property name="password" value="991118"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <!--自动在类的根路径下查找-->
        <mapper resource="carMapper.xml"/>
    </mappers>

</configuration>
```

## 1、环境标签

```xml
<environments default="bjpowernode">
    <environment id="bjpowernode">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="url" value="jdbc:mysql://localhost:3306/bjpowernode"/>
            <property name="username" value="root"/>
            <property name="password" value="991118"/>
        </dataSource>
    </environment>

    <environment id="book">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
            <!--连接 book 数据库-->
            <property name="url" value="jdbc:mysql://localhost:3306/book"/>
            <property name="username" value="root"/>
            <property name="password" value="991118"/>
        </dataSource>
    </environment>
</environments>
```

新建了一个环境，连接 book 数据库。

在使用 `sqlSessionFactoryBuilder.build(核心配置文件流, 环境名)`，如下所示：

```java
// 默认数据库对应的 sqlSessionFactory
SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));

// 指定数据库对应的 sqlSessionFactory
SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "book");
```

## 2、事务管理器

## 3、数据源

`dataSource` 标签为程序提供 `Connection` 对象。

数据源实际上是一套规范，JDK 中有这一套规范：`javax.sql.DataSource`。

```xml
<dataSource type="POOLED">
    <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/bjpowernode"/>
    <property name="username" value="root"/>
    <property name="password" value="991118"/>
</dataSource>
```

`type` 属性指定数据源类型，有三个值：`UNPOOLED`/`POOLED`/`JNDI`。

`unpooled`：不使用数据库连接池，每次都是创建新的连接对象。

`pooled`：使用 Mybatis 自身实现的数据库连接池，从池中获取连接对象。

`JNDI`：集成第三方数据库连接池。

JNDI(Java 命名目录接口)是一套规范，大部分 web 容器都实现了 JNDI 规范。

**连接池的使用**

使用连接池可以设置很多参数，这些参数设计的优劣影响连接池的使用效果。参数设置需要不断测试找到最优解。

`poolMaximumActiveConnections` 参数：在任意时间可存在的活动（正在使用）连接数量，默认值：10。

```xml
<property name="poolMaximumActiveConnections" value="10"/>
```

`poolMaximumCheckoutTime` 参数： 在被强制返回之前，池中连接被检出（checked out）时间，默认值：20000 毫秒（即 20 秒）。

`poolMaximumIdleConnections` 参数：最多存在的空闲连接数。如果超出，将关闭多余空闲连接。

## 4、properties 标签与配置

配置 Mybatis 的属性。properties 标签一般不在 Mybatis 核心配置文件中书写，而是书写额外的 properties 文件。

properties 文件：

```properties
driver=com.mysql.cj.jdbc.Driver
urlForBjpowernode=jdbc:mysql://localhost:3306/bjpowernode
username=root
password=991118
```

在核心配置文件中引入 properties 文件，并使用 properties 文件中的键值属性，使用 `${}` 的方式。

```xml
<properties resource="jdbc.properties"></properties>
```

```xml
<environments default="bjpowernode">
    <environment id="bjpowernode">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"/>
            <property name="url" value="${urlForBjpowernode}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </dataSource>
    </environment>
```

# 五、手写 Mybatis 框架

## 1、使用 dmo4j 解析 xml 配置文件

所需依赖：

**dom4j**

```xml
<!-- https://mvnrepository.com/artifact/org.dom4j/dom4j -->
<dependency>
    <groupId>org.dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>2.1.3</version>
</dependency>
```

**jaxen**

```xml
<!-- https://mvnrepository.com/artifact/jaxen/jaxen -->
<dependency>
    <groupId>jaxen</groupId>
    <artifactId>jaxen</artifactId>
    <version>1.2.0</version>
</dependency>
```

# 六、在 Web 中应用 Mybatis

实现银行转账业务。

## 1、编写数据库表

## 2、创建项目

![image-20221111170352079](img/image-20221111170352079.png)

**加入依赖**

**准备前端页面**

![image-20221112090345469](img/image-20221112090345469.png)

**复制核心配置文件**

## 3、代码实现

**业务跑通**

`index.html`：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>转账页面</title>
</head>
<body>
    <form action="/bank/transfer" method="post">
        转出账户<input type="text" name="act_no_out"><br>
        转入账户<input type="text" name="act_no_in"><br>
        转账金额<input type="text" name="money"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
```

`AccountServlet.java`：

```java
// 使用注解标记 servlet 程序坐标
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 接收页面传来的数据
        String actOut = req.getParameter("act_no_out");
        String actIn = req.getParameter("act_no_in");
        double money = Double.parseDouble(req.getParameter("money"));

        // 调用 Service 中 transfer() 方法完成转账业务
        try {
            accountService.transfer(actOut, actIn, money);

            // 跳转至转账成功界面
            resp.sendRedirect(req.getContextPath() + "/success/transfer_success.html");
        } catch (BalanceNotEnoughException e) {
            // 跳转至转账失败界面
            resp.sendRedirect(req.getContextPath() + "/error/BalanceNotEnough.html");
        }
    }
}
```

`AccountServiceImpl.java`：

```java
public class AccountServiceImpl implements AccountService {
    private ActDao actDao = new ActDaoImpl();

    @Override
    public void transfer(String actOut, String actIn, Double money) throws BalanceNotEnoughException {
        // 获取转出账户余额
        Account accountOut = actDao.queryAccount(actOut);
        Double balance = accountOut.getBalance();

        // 余额小于转账金额，抛余额不足异常
        if (balance < money) {
            throw new BalanceNotEnoughException("余额不足，无法转账！");
        }

        // 获取装入账户对象
        Account accountIn = actDao.queryAccount(actIn);

        // 更新内存中账户金额
        accountOut.setBalance(balance - money);
        accountIn.setBalance(accountIn.getBalance() + money);

        // 更新数据库账户金额
        actDao.update(actOut, accountOut.getBalance());
        actDao.update(actIn, accountIn.getBalance());
    }
}
```

`ActDaoImpl.java`：

```java
public class ActDaoImpl implements ActDao {
    @Override
    public int insertAct(Account account) {
        // 开启事务
        SqlSession sqlSession = MybatisUtils.openSession();
        // 执行sql
        int effectedRows = sqlSession.insert("insertAct", account);
        // 事务提交
        sqlSession.commit();

        return effectedRows;
    }

    @Override
    public int update(String actNo, Double balance) {
        Account account = new Account(null, actNo, balance);
        // 开启事务
        SqlSession sqlSession = MybatisUtils.openSession();
        int count = sqlSession.update("account.updateBalance", account);
        // 事务提交
        sqlSession.commit();
        // 关闭连接
        sqlSession.close();
        return count;
    }

    @Override
    public Account queryAccount(String actNo) {
        SqlSession sqlSession = MybatisUtils.openSession();
        Account account = sqlSession.selectOne("selectOneAccount", actNo);
        return account;
    }
}
```

**事务控制**

在线程中，执行 DML 语句必须使用同一个数据库连接对象。并在 Service 层进行事务控制。

```java
// 更新数据库账户金额
actDao.update(actOut, accountOut.getBalance());
actDao.update(actIn, accountIn.getBalance());
```

在 `MybatisUtils.java` 中，控制同一线程获取的数据库连接是同一个：

```java
public static SqlSession openSession() {
    // 首先在 threadLocal 对象中获取
    SqlSession sqlSession = threadLocal.get();
    if (sqlSession == null) { // 第一次连接数据库
        // 获取数据库连接并放入 ThreadLocal 对象
        sqlSession = sqlSessionFactory.openSession();
        threadLocal.set(sqlSession);
    }
    return sqlSession;
}
```

关闭连接时，关闭 `sqlSession` 后，还要取消绑定。

> Tomcat 使用线程池，线程后续还会继续使用。

```java
public static void close(SqlSession sqlSession) {
    if (sqlSession != null) {
        // 归还连接
        sqlSession.close();
        // 解绑
        threadLocal.remove();
    }
}
```

由于在 Service 层进行事务控制，Dao 层不能提交事务，关闭事务，只进行数据库操作。

Service 层关键代码：

```java
// 获取 sqlSession
SqlSession sqlSession = MybatisUtils.openSession();

try {
    // 更新数据库账户金额
    actDao.update(actOut, accountOut.getBalance());
    actDao.update(actIn, accountIn.getBalance());
    
    // 事务提交
    sqlSession.commit();
} catch (Exception e) {
    // 事务回滚
    sqlSession.rollback();
    throw new RuntimeException(e);
} finally {
    // 释放资源
    MybatisUtils.close(sqlSession);
}
```

在 web 层，对额外的异常进行捕获：

```java
} catch (Exception e) {
    // 跳转至未知原因错误界面
    resp.sendRedirect(req.getContextPath() + "/error/BalanceNotEnough.html");
}
```

## 4、Mybatis 三大对象作用域

`SqlSessionFactoryBuilder`：只要创建出了 `SqlSessionFactory`，其作用就结束了，最佳作用域是方法作用域，例如：

```java
sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
```

`SqlSessionFactory`：在应用运行的阶段，需要不断使用该对象，因此最佳作用域是应用作用域。并且只创建一次。

`SqlSession`：每个线程都应该有自己的实例，以便进行事务管理。

# 七、使用 Javassist 动态生成类

Mybatis 对 Javassist 进行了二次包装。 

# 八、Mybatis 接口代理类的使用

使用条件：

Mapper 文件中，namespace 写接口的全限定名称，id 写抽象方法的方法名。

使用方法：

`sqlSession.getMapper(接口类)`

如果使用 Mybatis，dao 改为 mapper。mapper 包中不需要写实现类。

```java
public interface CarMapper {
    /**
     * 添加汽车
     * @param car 汽车对象
     * @return 受影响的记录条数
     */
    int insert(Car car);

    /**
     * 删除汽车
     * @param id 汽车编号
     * @return 受影响的记录条数
     */
    int deleteById(Integer id);

    /**
     * 更新汽车信息
     * @param car 汽车对象
     * @return 受影响的记录条数
     */
    int update(Car car);

    /**
     * 查询单个汽车信息
     * @param id 汽车编号
     * @return 汽车对象
     */
    Car queryOneById(Integer id);

    /**
     * 查询所有汽车信息
     * @return 汽车列表
     */
    List<Car> queryAll();
}
```

`xxxMapper.xml` 中，namespace 填入接口的全限定类名，id 填入方法名：

```xml
<mapper namespace="com.zzy.crud2.mapper.CarMapper">
    <insert id="insert">
        insert into t_car
            (id, car_num, brand, guide_price, produce_time, car_type)
        values
            (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})
    </insert>
```

使用如下语句获取动态代理类：

```java
private CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
```

# 九、Mybatis 技巧

## 1、#{} 和 ${}

#{} 底层使用 `PreparedStatement`：先编译 SQL 语句，再传值，可以避免 SQL 注入现象。

${} 底层使用 `Statement`，先拼接 SQL 语句(使用字符串拼接)，再编译 SQL 语句。

优先使用 #{}。

### (1) 拼接 ASC/DESC 进行排序

`CarMapper.java` 中写出抽象方法：

```java
List<Car> queryAllByPrice(String order);
```

`carMapper.xml` 中写出相应 SQL 语句：

```xml
<select id="queryAllByPrice" resultType="com.zzy.crud2.pojo.Car">
    select id,
           car_num as carNum,
           brand,
           guide_price as guidePrice,
           produce_time as produceTime,
           car_type as carType
    from t_car
    order by  guidePrice ${order}
</select>
```

### (2) 拼接表名

例如：t_log_20221113

### (3) 批量删除记录

`CarMapper.java` 中写出抽象方法：

```java
int deleteBatchById(String ids);
```

`carMapper.xml`：

```xml
<delete id="deleteBatchById">
    delete from t_car where id in (${ids})
</delete>
```

### (4) 模糊查询

`CarMapper.java`：

```java
List<Car> queryLike(String brand);
```

`carMapper.xml`：

```xml
<select id="queryLike" resultType="com.zzy.crud2.pojo.Car">
    select id,
           car_num as carNum,
           brand,
           guide_price as guidePrice,
           produce_time as produceTime,
           car_type as carType
    from t_car
    where brand like '%${brand}%'
</select>
```

这样其实更多：`"%"#{brand}"%"`。

## 2、别名机制

给 pojo 类一个简称，在 Mybatis 核心配置文件中进行配置，不区分大小写：

```xml
<typeAliases>
    <typeAlias type="com.zzy.crud2.pojo.Car" alias="Car" />
</typeAliases>
```

namespace 没有别名。

省略 `alias` 之后别名就是类的简名。

也可以使用如下方式，将包下所有类自动起别名。

```xml
<typeAliases>
    <!--<typeAlias type="com.zzy.crud2.pojo.Car" alias="Car" />-->
    <package name="com.zzy.crud2.pojo"/>
</typeAliases>
```

## 3、mappers

```xml
<!--class 标签内填写类的全限定名称-->
<!--会自动查找 com/zzy/crud2/mapper/CarMapper.xml-->
<!--可以在 resources 中新建 com/zzy/crud2/mapper 目录并将 CarMapper.xml 放入-->
<mapper class="com.zzy.crud2.mapper.CarMapper"></mapper>
```

最常用的使用方式为：

```xml
<!--使用这种方式将包下所有 xxxMapper.java 与 xxxMapper.xml 进行绑定-->
<package name="com.zzy.crud2.mapper"/>
```

## 4、IDEA 配置模板文件

![image-20221114101752196](img/image-20221114101752196.png)

## 5、插入数据时获取自动生成的主键

`CarMapper.java`：

```java
int insertAndGetKey(Car car);
```

`CarMapper.xml`：

```xml
<insert id="insertAndGetKey" useGeneratedKeys="true" keyProperty="id">
    insert into t_car
        (id, car_num, brand, guide_price, produce_time, car_type)
    values
        (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})
</insert>
```

可以将生成的主键封装到 pojo 对象中。

# 十、Mybatis 参数处理

## 1、单个简单类型参数

简单类型包括：

- 八种基本数据类型及其包装类
- String
- Date

可以在 `XXXMapper.xml` 中填入参数类型告知 Mybatis 参数类型：

```xml
<select id="queryByAge" resultType="Student" parameterType="long">
    select *
    from t_student
    where age = #{id}
</select>
```

但 Mybatis 有类型判断机制，进而使用相应的 JDBC 方法进行赋值。

## 2、Map 参数

## 3、实体类参数

## 4、多参数

`StudentMapper.java` 中，使用姓名和年龄查询：

```java
Student queryByNameAndAge(String name, Integer age);
```

在 Mybatis 中，多参数使用 Map 进行传参：

​	map.put("arg0", name)

​	map.put("arg1", age)

或者

​	map.put("param1", name)

​	map.put("param2", age)

因此，`StudentMapper.xml` 中：

```xml
<select id="queryByNameAndAge" resultType="Student">
    select * 
    from t_student 
    where name = #{arg0} and age = #{arg1}
</select>
```

## 5、Param 注解

使用 Param 注解告知 Mybatis 多参数时，应该使用什么 key 值。

`StudentMapper.java` 中：

```java
Student queryByNameAndAge2(@Param("name") String name, @Param("age") Integer age);
```

`StudentMapper.xml` 中：

```xml
<select id="queryByNameAndAge2" resultType="Student">
    select *
    from t_student
    where name = #{name} and age = #{age}
</select>
```

# 十一、Mybatis 查询语句专题

如果没有合适的 pojo，可以使用 map 进行接收。

返回大 Map 集合。

## 1、结果映射

当数据库中的字段名和 pojo 类中的属性名不一致时，可以使用给查询列起别名的方式解决，但这种方式在所有的查询中都要起别名。另一个方案是使用 `resultMap` 标签，用来规定数据库字段与 pojo 类属性的映射关系。

`resultMap` 标签的使用：

```xml
<!--id 是结果映射集的标识，type 是pojo类名-->
<resultMap id="StudentResultMap" type="Student">
    <!--表的主键-->
    <!--property pojo 类的属性-->
    <!--column 表的字段-->
    <id property="id" column="id" />
    <result property="name" column="name" />
    <result property="age" column="age" />
    <result property="height" column="height" />
    <result property="birth" column="birth" />
    <result property="sex" column="sex" />
</resultMap>
```

```xml
<select id="queryByAge" resultMap="StudentResultMap">
    select *
    from t_student
    where age = #{id}
</select>
```

## 2、驼峰命名自动映射

在 Mybatis 核心配置文件中，进行如下设置：

```xml
<settings>
        <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```

Pojo 类属性名和数据库字段名均符合规范时可以使用。

## 3、查询总记录条数

在 `xxxMapper.xml` 中，需要规定查询结果类型：

```xml
<select id="countAll" resultType="int">
    select count(*)
    from t_student
</select>
```

# 十二、动态 SQL

## 1、if 标签

`CarMapper.java` 中，抽象方法可以接受多个参数：

```java
List<Car> queryByMultiConditions(@Param("brand") String brand, @Param("guidePrice") BigDecimal guidePrice, @Param("carType") String carType);
```

`CarMapper.xml` 中，使用 `if` 标签将选取的参数拼接到 SQL 语句中：

```xml
<select id="queryByMultiConditions" resultType="Car">
    select *
    from t_car
    where
        <if test="brand != null and brand != ''">
            brand like "%"#{brand}"%"
        </if>
        <if test="guidePrice != null and guidePrice != ''">
            and guide_price > #{guidePrice}
        </if>
        <if test="carType != null and carType != ''">
            and car_type like "%"#{carType}"%"
        </if>
</select>
```

**出现的 bug**

当三个条件都为 `null` 时，SQL 语句变为：

```
select * from t_car where
```

这有语法错误，可以在 where 后添加 1=1。

```xml
<select id="queryByMultiConditions" resultType="Car">
    select *
    from t_car
    where 1=1
        <if test="brand != null and brand != ''">
            and brand like "%"#{brand}"%"
        </if>
        <if test="guidePrice != null and guidePrice != ''">
            and guide_price > #{guidePrice}
        </if>
        <if test="carType != null and carType != ''">
            and car_type like "%"#{carType}"%"
        </if>
</select>
```

## 2、where 标签

让 where 子句更加智能。

- 所有条件为空时，不会生成 where 子句
- 自动添加或删除 and/or

`CarMapper.java` 中：

```java
List<Car> queryByMultiConditionsWithWhere(@Param("brand") String brand, @Param("guidePrice") BigDecimal guidePrice, @Param("carType") String carType);
```

`CarMapper.xml` 中：

```xml
<select id="queryByMultiConditionsWithWhere" resultType="Car">
    select *
    from t_car
    <where>
        <if test="brand != null and brand != ''">
            brand like "%"#{brand}"%"
        </if>
        <if test="guidePrice != null and guidePrice != ''">
            guide_price > #{guidePrice}
        </if>
        <if test="carType != null and carType != ''">
            car_type like "%"#{carType}"%"
        </if>
    </where>
</select>
```

## 3、trim 标签

给标签内的语句加前缀、去前缀、加后缀、去后缀。

`CarMapper.java` 中：

```java
List<Car> queryByMultiConditionsWithTrim(@Param("brand") String brand, @Param("guidePrice") BigDecimal guidePrice, @Param("carType") String carType);
```

`CarMapper.xml` 中：

```xml
<select id="queryByMultiConditionsWithTrim" resultType="Car">
    select *
    from t_car
    <trim prefix="where" suffixOverrides="and|or">
        <if test="brand != null and brand != ''">
            brand like "%"#{brand}"%" and
        </if>
        <if test="guidePrice != null and guidePrice != ''">
            guide_price > #{guidePrice} and
        </if>
        <if test="carType != null and carType != ''">
            car_type like "%"#{carType}"%" and
        </if>
    </trim>
</select>
```

如果 `trim` 标签内没有任何语句，便不会加前缀 `where`。

添加的语句会去除后面的 `and`。

## 4、set 标签

通常使用在 update 语句中。

可以自动添加 `set`，自动添加与删除 `,`。

需求：传入 pojo 类更新记录，值为 `null` 的属性不更新。

传入 pojo 类更新记录，`CarMapper.java` 中：

```java
int updateByIdWithSet(Car car);
```

`CarMapper.xml` 中：

```xml
<update id="updateByIdWithSet">
    update t_car
    <set>
        <if test="carNum != null and carNum != ''">
            car_num = #{carNum}
        </if>
        <if test="brand != null and brand != ''">
            brand = #{brand}
        </if>
        <if test="guidePrice != null and guidePrice != ''">
            guide_price = #{guidePrice}
        </if>
        <if test="produceTime != null and produceTime != ''">
            produce_time = #{produceTime}
        </if>
        <if test="carType != null and carType != ''">
            car_type = #{carType}
        </if>
    </set>
    where id = #{id}
</update>
```

## 5、choose/when/otherwise

需求：首先根据 `brand` 查询，如果 `brand` 不存在；则根据 `guide_price` 查询；否则根据 `car_type` 查询记录。

`CarMapper.java` 中：

```java
List<Car> queryByBrand(@Param("brand") String brand, @Param("guidePrice") BigDecimal guidePrice, @Param("carType") String carType);
```

`CarMapper.xml` 中：

```xml
<select id="queryByBrand" resultType="Car">
    select *
    from t_car
    <choose>
        <when test="brand != null and brand != ''">
            where brand like "%"#{brand}"%"
        </when>
        <when test="guidePrice != null and guidePrice != ''">
            where guide_price > #{guidePrice}
        </when>
        <when test="carType != null and carType != ''">
            where car_type like "%"#{carType}"%"
        </when>
    </choose>
</select>
```

## 6、foreach 标签

### (1) 批量删除

需求：根据 id 数组批量删除记录。

`CarMapper.java` 中：

```java
int deleteByIds(@Param("ids") Integer[] ids);
```

`CarMapper.xml` 中：

```xml
<delete id="deleteByIds">
    delete
    from t_car
    where id in
        <foreach collection="ids" item="id" separator="," open="(" close=")">
            #{id}
        </foreach>
</delete>
```

### (2) 批量添加

需求：使用 `Car` 列表批量添加数据。

`CarMapper.java` 中：

```java
int insertCars(@Param("cars") List<Car> cars);
```

`CarMapper.xml` 中：

```xml
<insert id="insertCars">
    insert into t_car
    (id, car_num, brand, guide_price, produce_time, car_type) values
    <foreach collection="cars" item="car" separator="," >
        (#{car.id}, #{car.carNum}, #{car.brand}, #{car.guidePrice}, #{car.produceTime}, #{car.carType})
    </foreach>
</insert>
```

## 7、sql 和 include 标签

将公共的 sql 语句提取出来实现代码复用。

```xml
<sql id="BookColumn">
    id, name, author, price, sales, stock, img_path
</sql>
```

```xml
<insert id="insertBook">
    insert into t_book
        (<include refid="BookColumn"></include>)
    values
        (#{id}, #{name}, #{author}, #{price}, #{sales},#{stock}, #{imgPath})
</insert>
```

# 十三、Mybatis 高级映射及延迟加载

使用两张表：学生表和班级表，是多对一的关系。

## 1、实体类的关系

在数据库中，学生表有外键 `cid`，可以通过其定位到一条班级记录。但 pojo 类中，`cId` 并不能算 `Student` 实体类的属性，`cId` 只能是 `Clazz` 实体类的属性。为了实现这种从 `Student` 对象可以直接找到 `Clazz` 对象的概念，可以给 `Student` 中添加 `Clazz` 的引用。即在多的一方实体类中添加少的一方实体类的引用。 

```java
public class Student {
    private Integer sid; // 学号
    private String sname; // 姓名
    private Clazz clazz; // 所属班级
```

## 2、多对一

### (1) 级联属性映射

根据 `sid` 获取学生信息及其关联的班级信息。

`StudentMapper.java` 中：

```java
Student queryStudentBySid(Integer sid);
```

`StudentMapper.xml` 中：

SQL 语句使用外连接查询，`t_student` 表作为主表：

```xml
<select id="queryStudentBySid" resultMap="StudentResultMap">
    select s.sid, s.sname, c.cid, c.cname
    from t_student s left outer join t_clazz c on s.cid = c.cid
    where sid = #{sid}
</select>
```

还应该告知 Mybatis 将查询到的参数注入到 pojo 类中哪个属性：

```xml
<resultMap id="StudentResultMap" type="Student">
    <!--property为pojo类属性名，column为数据库字段名-->
    <id property="sid" column="sid"></id>
    <result property="sname" column="sname"></result>
    <result property="clazz.cid" column="cid"></result>
    <result property="clazz.cname" column="cname"></result>
</resultMap>
```

### (2) 使用 association

`StudentMapper.java`中：

```java
Student queryStudentBySidAssociation(Integer sid);
```

`StudentMapper.xml`

使用 `association` 标签告知 Mybatis `Student` 类关联了 `Clazz`，以何种方式进行参数注入。

```xml
<resultMap id="StudentResultMapAssociation" type="Student">
    <id property="sid" column="sid"></id>
    <result property="sname" column="sname"></result>
    <association property="clazz" javaType="Clazz">
        <id property="cid" column="cid"></id>
        <result property="cname" column="cname"></result>
    </association>
</resultMap>
```

```xml
<select id="queryStudentBySidAssociation" resultMap="StudentResultMapAssociation">
    select s.sid, s.sname, c.cid, c.cname
    from t_student s left outer join t_clazz c on s.cid = c.cid
    where sid = #{sid}
</select>
```

### (3) 分步查询(重点)

优点：可复用、延迟加载。

查询 `t_student` 表获取 `sid`、`sname` 和 `cid`；再根据 `cid` 查询班级信息。

`StudentMapper.java`

```java
Student queryStudentBySidAssociationByStep(Integer sid);
```

`StudentMapper.xml`

查询学生记录的 `sid`、`sname` 和 `cid`，并将 `cid` 传给 `ClazzMapper.xml` 中的一条 SQL 语句。

结果映射：

```xml
<resultMap id="StudentResultMapStep" type="Student">
    <id property="sid" column="sid"></id>
    <result property="sname" column="sname"></result>
    <!--pojo 类的 clazz 属性的参数注入交由另一条 SQL 语句进行，传送的参数为 cid-->
    <!--com.zzy.advanced.mapper.ClazzMapper.queryClazzByCid 也是接口方法的全类名-->
    <association property="clazz" select="com.zzy.advanced.mapper.ClazzMapper.queryClazzByCid" column="cid"></association>
</resultMap>
```

```xml
<select id="queryStudentBySidAssociationByStep" resultMap="StudentResultMapStep">
    select sid, sname, cid
    from t_student
    where sid = #{sid}
</select>
```

`ClazzMapper.java`

```java
Clazz queryClazzByCid(Integer cid);
```

`ClazzMapper.xml`

该 SQL 语句负责进行 `Student` 中 `clazz` 的注入。

```xml
<select id="queryClazzByCid" resultType="Clazz">
    select cid, cname
    from t_clazz
    where cid = #{cid}
</select>
```

## 3、延迟加载

核心原理：用到的时候执行查询，不用的时候不查询。

作用：提高性能。

> 使用分步查询根本没有用到表连接，性能得到提升。

Mybatis 中开启懒加载：

默认不使用懒加载。

在 `association` 标签中添加 `fetchtype='lazy'`

```xml
<association property="clazz" select="com.zzy.advanced.mapper.ClazzMapper.queryClazzByCid" column="cid" fetchType="lazy"></association>
```

如果使用到了 `Student` 对象的 `clazz` 属性，第二条 SQL 会执行；否则，不会执行第二条 SQL 语句。

全局延迟加载开关：在 Mybatis 核心配置文件中，进行如下配置。

```xml
<settings>
    <setting name="lazyLoadingEnabled" value="true"/>
</settings>
```

实际开发中，大部分情况需要开启延迟加载机制。特殊情况，使用 `fetchType = eager` 取消懒加载。

## 4、一对多

一个班级对应多个学生，在数据库中可以使用 `cid` 属性查询班级信息，顺带查询班级中的学生记录。但是 `Student` 对象没有 `cid`，即使有也不能全部生成到内存中进行查询。因此 `Clazz` 对象应有 `Student` 对象列表。

### (1) Collection 方式 

### (2) 分步查询

首先通过 `cid` 获取班级信息，然后通过 `cid` 查询学生信息进行赋值。

`ClazzMapper.java`

```java
Clazz queryClazzByCidStep(Integer cid);
```

`ClazzMapper.xml`

查询结果映射：

```xml
<resultMap id="ClazzStep" type="Clazz">
    <id property="cid" column="cid"></id>
    <result property="cname" column="cname"></result>
    <!--students 参数的注入交由另一个 SQL 语句，传参 cid-->
    <collection property="students" select="com.zzy.advanced.mapper.StudentMapper.queryStudentsByCid" column="cid"></collection>
</resultMap>
```

查询语句：

```xml
<select id="queryClazzByCidStep" resultMap="ClazzStep">
    select cid, cname
    from t_clazz
    where cid = #{cid}
</select>
```

`StudentMapper.java`

```java
List<Student> queryStudentsByCid(Integer cid);
```

`StudentMapper.xml`

查询语句：

```xml
<select id="queryStudentsByCid" resultType="Student">
    select sid, sname, cid
    from t_student
    where cid = #{cid}
</select>
```

# 十四、Mybatis 缓存

## 1、Mybatis 缓存机制

![image-20221118163438149](img/image-20221118163438149.png)

数据库中的数据持久化在硬盘中，缓存机制就是将查询到的结果保存在内存中，方便下一次同一条 DML 语句执行时获取结果。

缓存作用：通过减少 IO 的方式提高程序执行效率。

## 2、一级缓存

由 `SqlSession` 提供，默认开启。对当前 sql 会话生效。会话级缓存。

一级缓存的清空：

- 执行了 `sqlSession.clearCache()`
- 执行了 DML 语句，和操作那张表没有关系

## 3、二级缓存

数据库级缓存。

如何使用二级缓存：

​	默认情况下，二级缓存开启，需要在对应的 `xxxMapper.xml` 中加入：`<cache />`

​	对应的 pojo 类实现 `serializable` 接口。

​	`sqlSesison` 提交或关闭后，一级缓存中的数据才会提交到二级缓存。

在两次查找之间出现了 DML 语句，二级缓存失效。

二级缓存属性设置：

![image-20221119084909619](img/image-20221119084909619.png)

## 4、Mybatis 集成 EhCache

集成 Ehcache 是为了替代二级缓存。

## 1、使用步骤

**引入依赖**

```xml
<!-- https://mvnrepository.com/artifact/org.mybatis.caches/mybatis-ehcache -->
<dependency>
    <groupId>org.mybatis.caches</groupId>
    <artifactId>mybatis-ehcache</artifactId>
    <version>1.2.2</version>
</dependency>
```

**在类的根路径下引入 ehcache.xml 配置文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd"
         updateCheck="false">
    <!--磁盘存储:将缓存中暂时不使⽤的对象,转移到硬盘,类似于Windows系统的虚拟内存-->
    <diskStore path="f:/ehcache"/>

    <!--defaultCache：默认的管理策略-->
    <!--eternal：设定缓存的elements是否永远不过期。如果为true，则缓存的数据始终有
   效，如果为false那么还要根据timeToIdleSeconds，timeToLiveSeconds判断-->
    <!--maxElementsInMemory：在内存中缓存的element的最⼤数⽬-->
    <!--overflowToDisk：如果内存中数据超过内存限制，是否要缓存到磁盘上-->
    <!--diskPersistent：是否在磁盘上持久化。指重启jvm后，数据是否有效。默认为false-
   ->
    <!-timeToIdleSeconds：对象空闲时间(单位：秒)，指对象在多⻓时间没有被访问就会失
   效。只对eternal为false的有效。默认值0，表示⼀直可以访问-->
    <!--timeToLiveSeconds：对象存活时间(单位：秒)，指对象从创建到失效所需要的时间。
   只对eternal为false的有效。默认值0，表示⼀直可以访问-->
    <!--memoryStoreEvictionPolicy：缓存的3 种清空策略-->
    <!--FIFO：first in first out (先进先出)-->
    <!--LFU：Less Frequently Used (最少使⽤).意思是⼀直以来最少被使⽤的。缓存的元
   素有⼀个hit 属性，hit 值最⼩的将会被清出缓存-->
    <!--LRU：Least Recently Used(最近最少使⽤). (ehcache 默认值).缓存的元素有⼀
   个时间戳，当缓存容量满了，⽽⼜需要腾出地⽅来缓存新的元素的时候，那么现有缓存元素中时间戳
   离当前时间最远的元素将被清出缓存-->
    <defaultCache eternal="false" maxElementsInMemory="1000" overflowToDisk="false" diskPersistent="false"
                  timeToIdleSeconds="0" timeToLiveSeconds="600" memoryStoreEvictionPolicy="LRU"/>
</ehcache>
```

**修改 `xxxMapper.xml` 中的 `<cache/>` 标签**

```xml
<cache type="org.mybatis.caches.ehcache.EhcacheCache"/>
```

# 十五、Mybatis 逆向工程

根据数据库表生成 pojo 类、xml 文件、Mapper 接口等。

## 1、逆向工程的使用

### (1) 精简版

**在 `POM.xml` 中配置插件：**

```xml
<!--配置 mybatis 逆向工程插件-->
<!--定制构建过程-->
<build>
    <!--可配置多个插件-->
    <plugins>
        <!--其中的⼀个插件：mybatis逆向⼯程插件-->
        <plugin>
            <!--插件的GAV坐标-->
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.4.1</version>
            <!--允许覆盖-->
            <configuration>
                <overwrite>true</overwrite>
            </configuration>
            <!--插件的依赖-->
            <dependencies>
                <!--mysql驱动依赖-->
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.30</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
```

**配置 `generatorConfig.xml`**

必须放在类的根路径下。generatorConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!--
    targetRuntime有两个值：
    MyBatis3Simple：⽣成的是基础版，只有基本的增删改查。
    MyBatis3：⽣成的是增强版，除了基本的增删改查之外还有复杂的增删改查。
    -->
    <context id="DB2Tables" targetRuntime="MyBatis3Simple">
        <!--防⽌⽣成重复代码-->
        <plugin type="org.mybatis.generator.plugins.UnmergeableXmlMappersPlugin"/>

        <commentGenerator>
            <!--是否去掉⽣成⽇期-->
            <property name="suppressDate" value="true"/>
            <!--是否去除注释-->
            <property name="suppressAllComments" value="true"/>
        </commentGenerator>

        <!--连接数据库信息-->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/bjpowernode"
                        userId="root"
                        password="991118">
        </jdbcConnection>

        <!-- ⽣成pojo包名和位置 -->
        <javaModelGenerator targetPackage="com.zzy.generator.pojo" targetProject="src/main/java">
            <!--是否开启⼦包-->
            <property name="enableSubPackages" value="true"/>
            <!--是否去除字段名的前后空⽩-->
            <property name="trimStrings" value="true"/>
        </javaModelGenerator>

        <!-- ⽣成SQL映射⽂件的包名和位置 -->
        <sqlMapGenerator targetPackage="com.zzy.generator.mapper" targetProject="src/main/resources">
            <!--是否开启⼦包-->
            <property name="enableSubPackages" value="true"/>
        </sqlMapGenerator>

        <!-- ⽣成Mapper接⼝的包名和位置 -->
        <javaClientGenerator
                type="xmlMapper"
                targetPackage="com.zzy.generator.mapper"
                targetProject="src/main/java">
            <property name="enableSubPackages" value="true"/>
        </javaClientGenerator>

        <!-- 表名和对应的实体类名-->
        <table tableName="t_car" domainObjectName="Car"/>
    </context>
</generatorConfiguration>
```

双击使用即可。

![image-20221119135046953](img/image-20221119135046953.png)

### (2) 复杂版 

使用复杂版，在 pojo 包下会生成 `xxxExample.java`，这是用来封装查询条件的。

使用案例

```java
public void testSelectByExample() {
    SqlSession sqlSession = MybatisUtils.openSession();
    CarMapper mapper = sqlSession.getMapper(CarMapper.class);

    // QBC风格：Query By Criteria，一种面向对象的查询方式，看不到 SQL 语句
    CarExample carExample = new CarExample();
    carExample.createCriteria().andBrandLike("%宝%");

    List<Car> cars = mapper.selectByExample(carExample);
    for (Car car : cars) {
        System.out.println(car);
    }

    sqlSession.close();
}
```

# 十六、Mybatis 使用 PageHelper

## 1、MySQL 原生分页

![image-20221120082648428](img/image-20221120082648428.png)

## 2、PageHelper 插件

**引入依赖**

```xml
<!--pagehelper 依赖-->
<!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper -->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.3.1</version>
</dependency>
```

**在 `mybatis-config.xml` 中配置拦截器**

```xml
<plugins>
    <plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
</plugins>
```

在执行 DQL 语句之前，启用分页功能。使用案例：

```java
public void testSelectAll() {
    SqlSession sqlSession = MybatisUtils.openSession();
    CarMapper mapper = sqlSession.getMapper(CarMapper.class);

    // 在执行 DQL 语句之前，开启分页功能
    PageHelper.startPage(1, 3);

    List<Car> cars = mapper.selectAll();
    cars.forEach(car -> System.out.println(car));
    sqlSession.close();
}
```

使用 `PageInfo` 封装查询到的记录：

```java
public void testSelectAll() {
    SqlSession sqlSession = MybatisUtils.openSession();
    CarMapper mapper = sqlSession.getMapper(CarMapper.class);

    PageHelper.startPage(2, 3);

    List<Car> cars = mapper.selectAll();

    PageInfo<Car> carPageInfo = new PageInfo<>(cars, 4);
    System.out.println(carPageInfo);
    sqlSession.close();
}
```

输出的信息如下：

```
PageInfo{pageNum=2, pageSize=3, size=3, startRow=4, endRow=6, total=10, pages=4, list=Page{count=true, pageNum=2, pageSize=3, startRow=3, endRow=6, total=10, pages=4, reasonable=false, pageSizeZero=false}[Car{id=181, carNum='1103', brand='IQOO neo3', guidePrice=20.00, produceTime='2022-11-09', carType='燃油车'}, 
Car{id=182, carNum='1103', brand='IQOO neo5', guidePrice=20.00, produceTime='2022-11-09', carType='燃油车'}, 
Car{id=186, carNum='1104', brand='XiaoMi 10', guidePrice=3999.00, produceTime='2022-11-13', carType='燃油'}], 
prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true, navigatePages=4, navigateFirstPage=1, navigateLastPage=4, navigatepageNums=[1, 2, 3, 4]}
```

# 十七、Mybatis 注解式开发

单表简单增删改查，可以使用注解。复杂的 SQL 语句最好使用 xml 文件。

使用案例：

```java
@Insert("insert into t_car values (null, #{carNum}, #{brand}, #{guidePrice}, #{produceTime}, #{carType})")
int insert(Car car);

@Delete("delete from t_car where id = #{id}")
int deleteById(Long id);
```

```java
@Select("select * from t_car")
// 结果映射
@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "carNum", column = "car_num"),
        @Result(property = "brand", column = "brand"),
        @Result(property = "guidePrice", column = "guide_price"),
        @Result(property = "produceTime", column = "produce_time"),
        @Result(property = "carType", column = "car_type")
})
List<Car> queryAll();
```
