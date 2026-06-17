#!/bin/bash
# 在线书店系统 - 运行测试 (Linux/Mac)
echo "======================================"
echo "在线书店系统 - 单元测试"
echo "======================================"
mvn clean test
if [ $? -ne 0 ]; then
    echo "测试失败，请检查输出。"
    exit 1
fi
echo "测试通过！"
echo ""
echo "JaCoCo 覆盖率报告：target/site/jacoco/index.html"
