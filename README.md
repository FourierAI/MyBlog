# MyBlog

[![GitHub license](https://img.shields.io/github/license/MrYezhipeng/MyBlog.svg)](https://github.com/MrYezhipeng/MyBlog/blob/master/LICENSE)

SpringBoot、Mybatis开发的个人博客系统，支持Markdown编辑文章。
## 本地运行
### Mysql数据库的配置
请在本机上安装Mysql数据库，并执行以下sql语句，来创建表
#### 用户表
```sql
CREATE TABLE `admin` (
  `pk_admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` char(32) NOT NULL,
  `admin_password` char(32) NOT NULL,
  PRIMARY KEY (`pk_admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
```
#### 文章表
```sql
CREATE TABLE `article` (
  `pk_article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_category` varchar(30) NOT NULL DEFAULT '种类',
  `article_title` varchar(30) NOT NULL,
  `article_content` varchar(5000) NOT NULL,
  `article_time` varchar(30) NOT NULL,
  PRIMARY KEY (`pk_article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8;
```
#### 评论表

```sql
CREATE TABLE `comment` (
  `pk_comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_name` varchar(30) NOT NULL,
  `comment_email` varchar(30) NOT NULL,
  `comment_content` varchar(50) NOT NULL,
  `comment_time` varchar(30) NOT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`pk_comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
```

### Maven打包项目

如果你还没有Maven，请先下载[Maven下载](https://maven.apache.org/)

#### 安装完成后，请切换到项目位置，执行以下命令：

```bash
mvn clean package  -D maven.test.skip=true
```

### 项目运行
因为本项目采用的是JDK1.8版本，请下载兼容的JDK版本，并执行以下命令：

```java
java -jar  xxx.xxxxx-1.0.0.jar
```

到此项目即完成配置，用浏览器访问localhost:8088便可访问博客项目。
## 问题讨论
欢迎大家给本项目提issue，也可QQ联系我(939647181),或者到我博客上给我留言。[我的博客](https://myblog.drye.top/)
