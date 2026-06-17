#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
代码注释覆盖率检查脚本。
统计 Java 源代码中 Javadoc 和行注释的覆盖率。

用法：
    python scripts/check_comment_coverage.py [目标目录]

默认扫描 src/main/java/ 目录。
输出每个文件的总行数、注释行数和覆盖率百分比。
"""

import os
import sys
import re


def count_lines(filepath):
    """统计文件中各类行的数量。

    Args:
        filepath: Java 源文件路径

    Returns:
        (total_lines, comment_lines, javadoc_lines) 元组
    """
    with open(filepath, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    total = len([l for l in lines if l.strip()])  # 非空行
    comment = 0
    javadoc = 0
    in_javadoc = False
    in_block = False

    for line in lines:
        stripped = line.strip()

        # Javadoc 开始
        if stripped.startswith('/**'):
            in_javadoc = True
            javadoc += 1
            continue
        # Javadoc 中间
        if in_javadoc:
            javadoc += 1
            if '*/' in stripped:
                in_javadoc = False
            continue
        # 块注释
        if stripped.startswith('/*'):
            in_block = True
            comment += 1
            continue
        if in_block:
            comment += 1
            if '*/' in stripped:
                in_block = False
            continue
        # 单行注释
        if stripped.startswith('//'):
            comment += 1
            continue

    return total, comment + javadoc


def main():
    """主函数：扫描 Java 源文件并计算注释覆盖率。"""
    target = sys.argv[1] if len(sys.argv) > 1 else 'src/main/java'

    if not os.path.exists(target):
        print(f"错误：目录不存在 - {target}")
        sys.exit(1)

    # 收集所有 Java 文件
    java_files = []
    for root, dirs, files in os.walk(target):
        for f in files:
            if f.endswith('.java'):
                java_files.append(os.path.join(root, f))

    if not java_files:
        print("未找到 Java 源文件")
        sys.exit(0)

    grand_total = 0
    grand_comment = 0

    print("=" * 70)
    print(f"{'文件':<50} {'总行数':>6} {'注释行':>6} {'覆盖率':>7}")
    print("-" * 70)

    for fpath in sorted(java_files):
        total, comment = count_lines(fpath)
        grand_total += total
        grand_comment += comment
        pct = (comment / total * 100) if total > 0 else 0
        short_name = fpath.replace('\\', '/').split('/java/')[-1] if '/java/' in fpath.replace('\\', '/') else fpath
        print(f"{short_name:<50} {total:>6} {comment:>6} {pct:>6.1f}%")

    overall = (grand_comment / grand_total * 100) if grand_total > 0 else 0
    print("-" * 70)
    print(f"{'总计':<50} {grand_total:>6} {grand_comment:>6} {overall:>6.1f}%")
    print("=" * 70)

    # 判断是否达标
    threshold = 30.0
    if overall >= threshold:
        print(f"\n[OK] 注释覆盖率 {overall:.1f}% >= {threshold:.0f}%，达标！")
    else:
        print(f"\n[FAIL] 注释覆盖率 {overall:.1f}% < {threshold:.0f}%，未达标！")
        sys.exit(1)


if __name__ == '__main__':
    main()

