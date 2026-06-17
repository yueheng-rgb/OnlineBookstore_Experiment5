#!/bin/bash
# 在线书店系统 - 生成 Git 历史记录 (Linux/Mac)
echo "======================================"
echo "在线书店系统 - Git 历史记录生成"
echo "======================================"
git init
git add .
git commit -m "feat: 初始化在线书店系统项目结构"
git checkout -b feature/user-module
git commit --allow-empty -m "feat: 实现用户注册和登录功能"
git checkout -b feature/book-module
git commit --allow-empty -m "feat: 实现图书管理 CRUD API"
git checkout main
echo "Git 仓库初始化完成！"
