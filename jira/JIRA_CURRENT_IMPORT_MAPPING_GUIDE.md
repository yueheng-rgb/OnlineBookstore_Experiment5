# Jira Cloud CSV Import — Mapping Guide

> For project: OnlineBookstore_Experiment5
> Jira Space types: Feature, Story, Task

---

## Quick Decision: Which File to Upload?

| Your Jira Supports | Upload This File |
|-------------------|------------------|
| Feature + Story + Task (your chosen types) | `jira_import_jira_cloud_feature_story_task.csv` |
| Epic + Story + Sub-task (standard Jira) | `jira_import_jira_cloud_epic_story_subtask.csv` |

---

## Mapping Table — Version A: Feature / Story / Task

**File**: `jira_import_jira_cloud_feature_story_task.csv`

| CSV Column | Jira Field to Select | Required | Notes |
|-----------|---------------------|----------|-------|
| Issue ID | **Issue ID** / Work item ID / 工作项 ID / 问题 ID / External ID | YES | Numeric IDs 1001-1035 |
| Issue Type | **Issue Type** / 问题类型 | YES | Values: Feature, Story, Task |
| Summary | **Summary** / 标题 / 摘要 | YES | English descriptive summaries |
| Description | **Description** / 描述 | NO | Context for each item |
| Priority | **Priority** / 优先级 | NO | Highest, High, Medium, Low |
| Status | **Status** / 状态 | NO | To Do, Doing, Done |
| Parent ID | **Parent ID** / Parent / 父级 / 父项 / 上级工作项 | YES | Links child to parent via Issue ID |
| Assignee | Assignee / 经办人 | NO | Can skip or map later |
| Assignee Role | (uncheck/ignore) | NO | Not a standard Jira field |
| Labels | **Labels** / 标签 | NO | Comma-separated tags |
| Story Points | **Story Points** / 故事点 | NO | Estimate points |
| Original Estimate | **Original Estimate** / 原始预估 | NO | Time estimate |
| Start Date | **Start Date** / 开始日期 | NO | Date field |
| Due Date | **Due Date** / 截止日期 | NO | Date field |
| Acceptance Criteria | (uncheck/ignore) | NO | Custom field, may not map |
| Sprint | **Sprint** / 冲刺 | NO | Sprint name |

---

## Mapping Table — Version B: Epic / Story / Sub-task

**File**: `jira_import_jira_cloud_epic_story_subtask.csv`

Same column mapping as Version A. Type values: Epic, Story, Sub-task.

**Key difference**: 20 Sub-task items have `[Task]` prefix in Summary to preserve task-layer identity.

---

## Field Search Cheatsheet

### If "Issue ID" is not in dropdown:

Search for these candidate names in Jira's field mapping dropdown:

1. **Issue ID** (English default)
2. **Work item ID**
3. **工作项 ID**
4. **问题 ID**
5. **外部 ID** / **External ID**
6. **Key** / **Issue Key**
7. **ID**

> If NONE of these appear, try importing without Issue ID mapping. Jira may auto-assign keys. You can then use the CSV's Issue ID column for reference only.

### If "Parent ID" is not in dropdown:

Search for:

1. **Parent** / **Parent ID**
2. **父级** / **父项**
3. **上级工作项**
4. **Parent Link**
5. **Epic Link** (only for Epic→Story, not for Story→Task)
6. **父级 ID**

> For Version A with Feature/Story/Task: Use **Parent ID** (not Epic Link).  
> For Version B with Epic/Story/Sub-task: Sub-tasks need a parent Story; Stories need a parent Epic.

---

## Recommended Import Steps

1. In Jira, go to: **Settings → System → External System Import → CSV**
2. Select the recommended CSV file
3. On the "Map Fields" screen:
   - Map **Issue ID** first (search if not visible)
   - Map **Issue Type** (should auto-detect)
   - Map **Parent ID** (search if not visible)
   - Map Summary, Description, Priority, Status
   - **Uncheck**: Assignee Role, Acceptance Criteria (not standard fields)
4. Click **Next** and validate the preview
5. Click **Begin Import**

---

## WARNING: Space Type Compatibility

Your current Jira space uses: **Feature, Story, Task**

- **Version A** (`feature_story_task.csv`) maps directly to these types → **USE THIS FIRST**
- **Version B** (`epic_story_subtask.csv`) uses Epic + Sub-task which may NOT be available in your space
- If Version B import fails with "unknown issue type", your space does not support Epic/Sub-task
- In that case, **only use Version A**

If Version A's "Feature" type is not recognized, try renaming the Issue Type column values from "Feature" to "Epic" — Jira may accept Epic even in a Feature-configured space.