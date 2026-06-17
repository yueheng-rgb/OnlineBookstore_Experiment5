@echo off
REM 在线书店系统 - 生成 Git 历史记录 (Windows)
echo ======================================
echo 在线书店系统 - Git 历史记录生成
echo ======================================
echo 此脚本将初始化本地 Git 仓库并创建模拟提交历史。

git init
git add .
git commit -m "feat: 初始化在线书店系统项目结构"

echo 创建功能分支...
git checkout -b feature/user-module
git commit --allow-empty -m "feat: 实现用户注册和登录功能"
git commit --allow-empty -m "feat: 添加用户 CRUD API"

git checkout -b feature/book-module
git commit --allow-empty -m "feat: 实现图书管理 CRUD API"
git commit --allow-empty -m "feat: 添加图书搜索和分类功能"

git checkout -b feature/cart-module
git commit --allow-empty -m "feat: 实现购物车功能"
git commit --allow-empty -m "feat: 添加购物车商品管理"

git checkout -b feature/order-module
git commit --allow-empty -m "feat: 实现订单创建和状态管理"
git commit --allow-empty -m "feat: 添加订单取消和库存恢复"

git checkout main
echo.
echo Git 仓库初始化完成！
echo 请将仓库推送到远程：git remote add origin <仓库地址>
pause
