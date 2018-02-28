# SmartAdmin Description



[![Build Status](https://travis-ci.org/meolu/walden.svg?branch=master)](https://travis-ci.org/meolu/walden)



**SmartAdmin** 是一个基于数据库实现的权限管理系统。**SmartAdmin**的目标是为用户方便的进行权限分配、角色管理。特点是简单易用，能快速实现权限管理功能，更适合开发新手。目前该系统还处于开发阶段，只实现了权限管理、角色管理、菜单管理和用户管理等功能。



## 特点



- 基于Spring、Spring MVC、Mabatis和MySQL 等主流开发框架
- 基于数据库实现的权限管理
- RESTFul 开发风格
- 策略模式
- 简单易学，适合新手学习

## 一、安装

### 1.配置Maven

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.nine</groupId>
  <artifactId>web-back-SSM</artifactId>
  <packaging>pom</packaging>
  <version>0.0.1-SNAPSHOT</version>
  <name>web-back-SSM Maven Webapp</name>
  <url>http://maven.apache.org</url>
 <properties>  
        <!-- spring版本号 -->  
        <spring.version>4.0.2.RELEASE</spring.version>  
        <!-- mybatis版本号 -->  
        <mybatis.version>3.2.6</mybatis.version>  
        <!-- log4j日志文件管理包版本 -->  
        <slf4j.version>1.7.7</slf4j.version>  
        <log4j.version>1.2.17</log4j.version>  
    </properties>  
  
    <dependencies>  
        <dependency>  
            <groupId>junit</groupId>  
            <artifactId>junit</artifactId>  
            <version>4.11</version>  
            <!-- 表示开发的时候引入，发布的时候不会加载此包 -->  
            <scope>test</scope>  
        </dependency>  
        <!-- spring核心包 -->  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-core</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-web</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-oxm</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-tx</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-jdbc</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-webmvc</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-aop</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-context-support</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.springframework</groupId>  
            <artifactId>spring-test</artifactId>  
            <version>${spring.version}</version>  
        </dependency>  
        <!-- mybatis核心包 -->  
        <dependency>  
            <groupId>org.mybatis</groupId>  
            <artifactId>mybatis</artifactId>  
            <version>${mybatis.version}</version>  
        </dependency>  
        <!-- mybatis/spring包 -->  
        <dependency>  
            <groupId>org.mybatis</groupId>  
            <artifactId>mybatis-spring</artifactId>  
            <version>1.2.2</version>  
        </dependency>  
        <!-- 导入java ee jar 包 -->  
        <dependency>  
            <groupId>javax</groupId>  
            <artifactId>javaee-api</artifactId>  
            <version>7.0</version>  
        </dependency>  
        <!-- 导入Mysql数据库链接jar包 -->  
        <dependency>  
            <groupId>mysql</groupId>  
            <artifactId>mysql-connector-java</artifactId>  
            <version>5.1.30</version>  
        </dependency>  
        <!-- 导入dbcp的jar包，用来在applicationContext.xml中配置数据库 -->  
        <dependency>  
            <groupId>commons-dbcp</groupId>  
            <artifactId>commons-dbcp</artifactId>  
            <version>1.2.2</version>  
        </dependency>  
        <!-- JSTL标签类 -->  
        <dependency>  
            <groupId>jstl</groupId>  
            <artifactId>jstl</artifactId>  
            <version>1.2</version>  
        </dependency>  
        <!-- 日志文件管理包 -->  
        <!-- log start -->  
        <dependency>  
            <groupId>log4j</groupId>  
            <artifactId>log4j</artifactId>  
            <version>${log4j.version}</version>  
        </dependency>  
         
        <!-- 格式化对象，方便输出日志 -->  
        <dependency>  
            <groupId>com.alibaba</groupId>  
            <artifactId>fastjson</artifactId>  
            <version>1.1.41</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.slf4j</groupId>  
            <artifactId>slf4j-api</artifactId>  
            <version>${slf4j.version}</version>  
        </dependency>  
  
        <dependency>  
            <groupId>org.slf4j</groupId>  
            <artifactId>slf4j-log4j12</artifactId>  
            <version>${slf4j.version}</version>  
        </dependency>  
        <!-- log end -->  
        <!-- 映入JSON -->  
        <dependency>  
            <groupId>org.codehaus.jackson</groupId>  
            <artifactId>jackson-mapper-asl</artifactId>  
            <version>1.9.13</version>  
        </dependency>  
        <!-- 上传组件包 -->  
        <dependency>  
            <groupId>commons-fileupload</groupId>  
            <artifactId>commons-fileupload</artifactId>  
            <version>1.3.1</version>  
        </dependency>  
        <dependency>  
            <groupId>commons-io</groupId>  
            <artifactId>commons-io</artifactId>  
            <version>2.4</version>  
        </dependency>  
        <dependency>  
            <groupId>commons-codec</groupId>  
            <artifactId>commons-codec</artifactId>  
            <version>1.9</version>  
        </dependency>  
           <dependency>  
            <groupId>org.mybatis</groupId>  
            <artifactId>mybatis</artifactId>  
            <version>3.2.7</version>  
        </dependency>  
          
    </dependencies>  
  <build>
    <finalName>web-back-SSM</finalName>
    
    <plugins>  
            <plugin>  
                <groupId>org.mybatis.generator</groupId>  
                <artifactId>mybatis-generator-maven-plugin</artifactId>  
                <version>1.3.1</version>  
                <configuration>  
                    <configurationFile>src/main/resources/generatorConfig.xml</configurationFile>  
                    <overwrite>true</overwrite>  
                </configuration>  
                <dependencies>  
                    <dependency>  
                        <groupId>mysql</groupId>  
                        <artifactId>mysql-connector-java</artifactId>  
                        <version>5.1.26</version>  
                    </dependency>  
                </dependencies>  
            </plugin>  
        </plugins>  
  </build>
  <modules>
  	<module>web-back-util</module>
  </modules>
</project>
```



## 二、关键表结构

```mysql
/*==============================================================*/
/* DBMS name:      MySQL 5.6                                    */
/* Created on:     2016/11/22 14:58:54                          */
/*==============================================================*/
DROP TABLE IF EXISTS T_ADMIN_USER;

DROP TABLE IF EXISTS T_ADMIN_RESOURCES;

DROP TABLE IF EXISTS T_ADMIN_ROLE;

DROP TABLE IF EXISTS T_ADMIN_ROLE_RESOURCE;

/*==============================================================*/
/* Table: T_ADMIN_USER                                      */
/*==============================================================*/
CREATE TABLE T_ADMIN_USER
(
   ID			INT(11)  UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
   USERNAME             VARCHAR(100) NOT NULL DEFAULT '' COMMENT '登录用户名',
   PASSWORD             VARCHAR(100) NOT NULL DEFAULT '' COMMENT '密码',
   REALNAME             VARCHAR(100) NOT NULL DEFAULT '' COMMENT '真实用户名',
   RETRY                NUMERIC(2,0) NOT NULL DEFAULT 3  COMMENT '允许最大登录次数',
   STATUS               NUMERIC(6,0) NOT NULL DEFAULT 1 COMMENT '状态',
   CREATEDATE           NUMERIC(16,0)NOT NULL COMMENT '创建时间',
   LASTDATE             NUMERIC(16,0)NOT NULL COMMENT '最后一次登陆时间',
   ROLECODE             VARCHAR(100) NOT NULL DEFAULT '' COMMENT '角色代码',
   PRIMARY KEY (ID),
   UNIQUE INDEX `UNQ_INX_NAME` USING BTREE (`USERNAME`)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='用户信息表';

/*==============================================================*/
/* Table: T_ADMIN_ROLE                                          */
/*==============================================================*/
CREATE TABLE T_ADMIN_ROLE
(
   ID			INT(11)  UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
   ROLECODE             VARCHAR(100) NOT NULL  DEFAULT '' COMMENT '角色代码',
   ROLENAME             VARCHAR(100) NOT NULL  DEFAULT '' COMMENT '角色名称',
   PRIMARY KEY (ID),
   UNIQUE INDEX `UNQ_INX_ROLECODE` USING BTREE (`ROLECODE`)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='角色表';

/*==============================================================*/
/* Table: T_ADMIN_ROLE_RESOURCE                               */
/*==============================================================*/
CREATE TABLE T_ADMIN_ROLE_RESOURCE
(
   ID			INT(11)  UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
   ROLECODE             VARCHAR(100) NOT NULL COMMENT '角色代码',
   RESOURCEID         NUMERIC(8,0) NOT NULL COMMENT '资源代码',
   PRIMARY KEY (ID),
   UNIQUE INDEX `UNQ_INX_ROLE_SRC` USING BTREE (`ROLECODE`,`RESOURCEID`)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='角色资源关系表';

/*==============================================================*/
/* Table: T_ADMIN_RESOURCES                                    */
/*==============================================================*/
CREATE TABLE T_ADMIN_RESOURCES
(
   ID			INT(11)  UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',	
   RID                  NUMERIC(8,0) NOT NULL COMMENT '资源id',
   PID                  NUMERIC(8,0) NOT NULL DEFAULT 0 COMMENT '父级id',
   NAME                 VARCHAR(100) NOT NULL DEFAULT '' COMMENT '资源名称',
   URL                  VARCHAR(200) NOT NULL DEFAULT '' COMMENT 'URL地址',
   LEAF                 NUMERIC(6,0) NOT NULL DEFAULT 1 COMMENT '是否为叶子节点',
   STATUS               NUMERIC(6,0) NOT NULL DEFAULT 0 COMMENT '状态',
   ORDERID              NUMERIC(6,0) NOT NULL DEFAULT 0 COMMENT '排序号',
   ICON                 VARCHAR(100) NOT NULL DEFAULT '' COMMENT '菜单显示图片信息',
   PRIMARY KEY (ID),
   UNIQUE INDEX `UNQ_INX_RID` USING BTREE (`RID`)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 COMMENT='资源表';
```



## TO DO List



- 为角色添加菜单组的功能 
- 增加登陆用户日志记录 
- 增加登陆用户报表 
- 优化登录界面的显示
- 增加ElasticSearch 全局搜索

