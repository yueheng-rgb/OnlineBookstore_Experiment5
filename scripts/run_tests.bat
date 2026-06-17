@echo off
REM 在线书店系统 - 运行测试 (Windows)
echo ======================================
echo 在线书店系统 - 单元测试
echo ======================================
call mvn clean test
if %ERRORLEVEL% neq 0 (
    echo 测试失败，请检查输出。
    pause
    exit /b 1
)
echo 测试通过！
echo.
echo JaCoCo 覆盖率报告：target/site/jacoco/index.html
pause
