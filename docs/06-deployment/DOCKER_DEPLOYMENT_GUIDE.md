# Docker 部署指南

## 前置条件
- Docker Desktop 已安装
- Docker Compose 可用

## 完整部署

```bash
# 启动所有服务（MySQL + Redis + App）
docker compose up -d

# 查看日志
docker compose logs -f app

# 停止所有服务
docker compose down
```

## 服务列表

| 服务 | 端口 | 说明 |
|------|------|------|
| mysql | 3306 | MySQL 8.0 |
| redis | 6379 | Redis 7 |
| app | 8080 | Spring Boot应用 |

## 仅启动应用

```bash
# 使用H2模式（无需MySQL和Redis）
docker compose up app
```

## 配置文件
- `docker-compose.yml`：服务编排
- `Dockerfile`：如需要自定义镜像构建
- `src/main/resources/application-docker.properties`：Docker环境配置
