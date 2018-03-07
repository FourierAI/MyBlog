# MyBlog
SpringBoot、Mybatis开发的个人博客系统，支持Markdown编辑文章。
### 本地运行
请在本机上安装Mysql数据库，并执行一下sql语句，来创建表
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