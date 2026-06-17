# Jira Cloud CSV Import — Field Mapping (Current UI)

> File: `jira_import_jira_cloud_current.csv`
> Jira Page: External System Import → CSV → Map Fields

---

## CSV Header (12 columns)

```
Work item ID,Work type,Summary,Description,Priority,Status,Parent,Assignee,Story Points,Original Estimate,Start date,Due date
```

---

## Field Mapping Table

| CSV Column | Jira Field Dropdown — Select | Required |
|-----------|------------------------------|----------|
| Work item ID | **Work item ID** | YES |
| Work type | **Work type** | YES |
| Summary | **Summary** | YES |
| Description | **Description** | NO |
| Priority | **Priority** | NO |
| Status | **Status** | NO |
| Parent | **Parent** | YES |
| Assignee | Assignee | NO (left empty) |
| Story Points | Story Points | NO |
| Original Estimate | Original Estimate | NO |
| Start date | Start date | NO |
| Due date | Due date | NO |

---

## Data Summary

| Level | Work type | Count | Parent |
|-------|-----------|-------|--------|
| 1 | Epic | 5 | (empty) |
| 2 | Story | 10 | Epic Work item ID |
| 3 | Sub-task | 20 | Story Work item ID |

**Total: 35 items**, IDs 1002–1036, ordered by hierarchy.

---

## What to Uncheck

- **Assignee**: All values are empty (no Atlassian account emails available). Uncheck or leave unmapped.

---

## If a Field Is Not Found

### "Work item ID"
Search dropdown for: `Work item ID`, `Issue ID`, `工作项 ID`, `问题 ID`, `External ID`

### "Work type"
Search dropdown for: `Work type`, `Issue Type`, `问题类型`

### "Parent"
Search dropdown for: `Parent`, `Parent ID`, `父级`, `父项`, `上级工作项`

---

## Import Steps

1. On the Jira CSV import page, **go back** to file selection
2. Upload: `jira_import_jira_cloud_current.csv`
3. On the Map Fields page, match each CSV column to the corresponding Jira field
4. Verify the preview shows 35 items with correct Epic → Story → Sub-task hierarchy
5. Click **Begin Import**