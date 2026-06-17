@echo off
REM ==========================================
REM Online Bookstore - JMeter Cache Performance Test
REM ==========================================
REM Two-phase execution:
REM   Phase A (NoCache): spring.profiles.active=nocache
REM     Runs: online-bookstore-nocache-test.jmx
REM     Results: jmeter/results/no-cache/
REM   Phase B (Redis): spring.profiles.active=redis (Redis required)
REM     Runs: online-bookstore-redis-cache-test.jmx
REM     Results: jmeter/results/redis-cache/
REM ==========================================

echo ======================================
echo Online Bookstore - JMeter Cache Performance Test
echo ======================================
echo.
echo PREREQUISITES:
echo   1. JMeter installed and on PATH
echo   2. For Phase B: Redis server running
echo.

set JMETER_HOME=%~dp0..\jmeter
if not exist "%JMETER_HOME%\results\no-cache" mkdir "%JMETER_HOME%\results\no-cache"
if not exist "%JMETER_HOME%\results\redis-cache" mkdir "%JMETER_HOME%\results\redis-cache"

echo.
echo ==========================================
echo PHASE A: NoCache Baseline Test
echo ==========================================
echo Start the application with:
echo   .\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=nocache
echo.
echo Press any key after the app is ready on http://localhost:8080
pause > nul

cd /d "%JMETER_HOME%"
echo Running NoCache baseline test...
jmeter -n -t online-bookstore-nocache-test.jmx -l results/no-cache/result.jtl -e -o results/no-cache/html-report
echo Phase A (NoCache) complete!

echo.
echo ==========================================
echo PHASE B: Redis Cache Test
echo ==========================================
echo 1. Ensure Redis server is running
echo 2. Start the application with:
echo   .\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=redis
echo.
echo Press any key after the app is ready on http://localhost:8080
pause > nul

echo Running Redis cache test...
jmeter -n -t online-bookstore-redis-cache-test.jmx -l results/redis-cache/result.jtl -e -o results/redis-cache/html-report
echo Phase B (Redis) complete!

echo.
echo ======================================
echo TEST COMPLETE!
echo NoCache Report: jmeter/results/no-cache/html-report/index.html
echo Redis Report:  jmeter/results/redis-cache/html-report/index.html
echo ======================================
pause