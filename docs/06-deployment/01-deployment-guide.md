# 部署指南

## 1. 本地开发部署

### 前置条件
- JDK 17+
- Maven 3.8+

### 启动步骤
```bash
# 1. 克隆项目
git clone <仓库地址>
cd OnlineBookstore_Experiment5

# 2. 编译
mvn clean package -DskipTests

# 3. 运行（默认 H2 内存数据库）
java -jar target/online-bookstore-1.0.0-SNAPSHOT.jar

# 4. 访问
# Swagger UI: http://localhost:8080/swagger-ui.html
# H2 控制台: http://localhost:8080/h2-console
```

## 2. Docker 部署

### 前置条件
- Docker 20+
- Docker Compose 2+

### 启动步骤
```bash
# 启动全部服务（MySQL + Redis + App）
docker compose up -d

# 查看日志
docker compose logs -f app

# 停止
docker compose down
```

## 3. Jenkins 部署

### Jenkins Pipeline 配置
1. 在 Jenkins 中新建 Pipeline 任务
2. 配置 Git 仓库地址
3. 指定 Jenkinsfile 路径（项目根目录）
4. 触发构建

详细配置见 `Jenkinsfile` 和 `MANUAL_OPERATIONS.md`。
