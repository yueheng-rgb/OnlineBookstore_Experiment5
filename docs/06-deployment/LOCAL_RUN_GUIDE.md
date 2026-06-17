# 本地运行指南

## 快速启动

```bash
# 1. 进入项目目录
cd OnlineBookstore_Experiment5

# 2. 使用Maven Wrapper编译运行（无需安装Maven）
.\mvnw.cmd spring-boot:run

# 或先打包再运行
.\mvnw.cmd clean package -DskipTests
java -jar target/online-bookstore-1.0.0-SNAPSHOT.jar
```

## 环境要求
- JDK 17+ (必须)
- 无需安装Maven（项目包含Maven Wrapper）
- 无需安装数据库（默认H2内存数据库）
- 无需安装Redis（默认本地缓存）

## 验证
1. 访问 Swagger UI：http://localhost:8080/swagger-ui.html
2. 访问 H2 控制台：http://localhost:8080/h2-console
3. 测试API：`curl http://localhost:8080/api/books`

## 切换Profile
```bash
# MySQL模式
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=mysql

# Redis缓存模式
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=h2,redis
```
