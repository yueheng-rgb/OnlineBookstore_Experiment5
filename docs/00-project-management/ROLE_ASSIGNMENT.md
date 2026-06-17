# 角色分配

## 团队角色

| 角色 | 人员 | 职责 |
|------|------|------|
| 产品经理 (PO) | 学生A | Backlog管理、需求定义、验收标准、需求评审组织 |
| Scrum Master | 学生B | Sprint计划、进度跟踪、障碍移除、Git/Jenkins配置 |
| 开发人员1 | 学生C | 用户模块、图书模块开发 |
| 开发人员2 | 学生D | 购物车模块、订单模块开发 |
| 测试人员 | 学生E | 单元测试、集成测试、JMeter压测 |

## 角色职责矩阵

| 活动 | PO | SM | Dev1 | Dev2 | QA |
|------|-----|-----|------|------|-----|
| 需求分析 | R | C | I | I | I |
| 系统设计 | C | I | R | R | I |
| 编码实现 | I | I | R | R | I |
| 单元测试 | I | I | C | C | R |
| 代码审查 | I | I | R | R | C |
| CI/CD配置 | I | R | C | C | I |
| JMeter压测 | I | I | I | I | R |
| 文档编写 | R | R | C | C | C |

> R=负责(Responsible), C=参与(Contributor), I=知情(Informed)
