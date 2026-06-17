# Code Coverage Report

## 1. JaCoCo Test Coverage (mvnw clean verify)

Generated from: `target/site/jacoco/jacoco.xml`
Date: 2026-06-16
Tests: 26 run, 0 failures, 0 errors, 0 skipped

| Metric | Covered | Total | Coverage % |
|--------|---------|-------|------------|
| Instruction | 1,850 | 2,805 | **66.0%** |
| Branch | 27 | 58 | **46.6%** |
| Line | 363 | 572 | **63.5%** |
| Complexity | 168 | 292 | **57.5%** |
| Method | 158 | 263 | **60.1%** |
| Class | 28 | 29 | **96.6%** |

### Per-Package Breakdown

| Package | Instruction | Branch | Line | Method | Class |
|---------|------------|--------|------|--------|-------|
| controller | 65.3% | 64.2% | 62.2% | 64.2% | 100% |
| service | 58.8% | 52.4% | 56.0% | 52.4% | 100% |
| entity (getters) | 85.7% | 81.8% | 84.6% | 81.8% | 100% |
| dto | 88.2% | 88.9% | 87.5% | 88.9% | 100% |
| repository | 36.1% | 40.0% | 30.4% | 40.0% | 100% |
| config | 59.6% | 54.5% | 55.2% | 54.5% | 100% |
| exception | 64.4% | 61.5% | 61.5% | 61.5% | 100% |
| enums | 88.2% | N/A | 87.5% | 88.9% | 100% |
| DataInitializer | 0% | 0% | 0% | 0% | 0% |

## 2. Comment Coverage (scripts/check_comment_coverage.py)

Generated from: custom script scanning `src/main/java/`
Date: 2026-06-16

| Metric | Value |
|--------|-------|
| Total Lines | 1,958 |
| Comment Lines | 858 |
| Comment Coverage | **43.8%** |
| Threshold | 30% |
| Result | **PASS** |

> **Note**: Comment coverage (43.8%) measures the ratio of comment lines to total lines, including Javadoc/block/line comments. This is NOT the same as JaCoCo code coverage. JaCoCo measures actual code execution by tests (Instruction 66.0%, Line 63.5%).