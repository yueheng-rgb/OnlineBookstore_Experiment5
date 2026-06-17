#!/bin/bash
# ==========================================
# Online Bookstore - JMeter Cache Performance Test
# ==========================================
# Two-phase execution:
#   Phase A (NoCache): spring.profiles.active=nocache
#     Runs: online-bookstore-nocache-test.jmx
#     Results: jmeter/results/no-cache/
#   Phase B (Redis): spring.profiles.active=redis (Redis required)
#     Runs: online-bookstore-redis-cache-test.jmx
#     Results: jmeter/results/redis-cache/
# ==========================================

echo "======================================"
echo "Online Bookstore - JMeter Cache Performance Test"
echo "======================================"
echo ""
echo "PREREQUISITES:"
echo "  1. JMeter installed and on PATH"
echo "  2. For Phase B: Redis server running"
echo ""

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
JMETER_HOME="${SCRIPT_DIR}/../jmeter"

mkdir -p "${JMETER_HOME}/results/no-cache"
mkdir -p "${JMETER_HOME}/results/redis-cache"

echo ""
echo "=========================================="
echo "PHASE A: NoCache Baseline Test"
echo "=========================================="
echo "Start the application with:"
echo "  ./mvnw spring-boot:run -Dspring-boot.run.profiles=nocache"
echo ""
read -p "Press Enter after the app is ready on http://localhost:8080..."

cd "${JMETER_HOME}"
echo "Running NoCache baseline test..."
jmeter -n -t online-bookstore-nocache-test.jmx -l results/no-cache/result.jtl -e -o results/no-cache/html-report
echo "Phase A (NoCache) complete!"

echo ""
echo "=========================================="
echo "PHASE B: Redis Cache Test"
echo "=========================================="
echo "1. Ensure Redis server is running"
echo "2. Start the application with:"
echo "  ./mvnw spring-boot:run -Dspring-boot.run.profiles=redis"
echo ""
read -p "Press Enter after the app is ready on http://localhost:8080..."

echo "Running Redis cache test..."
jmeter -n -t online-bookstore-redis-cache-test.jmx -l results/redis-cache/result.jtl -e -o results/redis-cache/html-report
echo "Phase B (Redis) complete!"

echo ""
echo "======================================"
echo "TEST COMPLETE!"
echo "NoCache Report: jmeter/results/no-cache/html-report/index.html"
echo "Redis Report:  jmeter/results/redis-cache/html-report/index.html"
echo "======================================"