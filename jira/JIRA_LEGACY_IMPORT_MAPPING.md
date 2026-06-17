# Jira Legacy External System Import — Field Mapping

> File: `jira_import_legacy_final_utf8.csv`
> Encoding: UTF-8 without BOM
> Target: Jira Cloud OLD External System Import (CSV)

---

## CSV Header (12 columns)

```
Issue ID,Issue Type,Summary,Description,Priority,Status,Parent,Labels,Story Points,Original Estimate,Start Date,Due Date
```

---

## Field Mapping Table

| CSV Column | Jira Field — Select | Map Field Values? | Notes |
|-----------|--------------------|--------------------|-------|
| Issue ID | **Issue ID** | NO | Numeric IDs 1001-1035 |
| Issue Type | **Issue Type** | **YES** | Epic, Story, Sub-task |
| Summary | **Summary** | NO | Chinese + English |
| Description | **Description** | NO | Includes role + acceptance criteria appended |
| Priority | **Priority** | **YES** | Highest, High, Medium, Low, Lowest |
| Status | **Status** | **YES** | To Do, In Progress, Done |
| Parent | **Parent** | NO | Numeric Issue ID of parent |
| Labels | **Labels** | NO | Comma-separated tags |
| Story Points | **Story Points** | NO | Numeric estimate |
| Original Estimate | **Original Estimate** | NO | Format: 2h, 4h, 1d, 40h, 60h |
| Start Date | **Start Date** | NO | Format: yyyy-MM-dd |
| Due Date | **Due Date** | NO | Format: yyyy-MM-dd |

---

## Fields to Check "Map Field Values"

| Field | Reason |
|-------|--------|
| Issue Type | Jira needs to know Epic→Epic, Story→Story, Sub-task→Sub-task |
| Priority | Jira needs to map Highest/High/Medium/Low/Lowest |
| Status | Jira needs to map To Do/In Progress/Done |

---

## Fields to NOT Check "Map Field Values"

| Field | Reason |
|-------|--------|
| Issue ID | Direct numeric value, no mapping needed |
| Summary | Free text, direct import |
| Description | Free text, direct import |
| Parent | Numeric reference, direct import |
| Labels | Free text, direct import |
| Story Points | Numeric, direct import |
| Original Estimate | Duration string, direct import |
| Start Date | Date string, direct import |
| Due Date | Date string, direct import |

---

## Data Summary

| Level | Issue Type | Count | Parent |
|-------|-----------|-------|--------|
| 1 | Epic | 5 | (empty) |
| 2 | Story | 10 | Epic Issue ID |
| 3 | Sub-task | 20 | Story Issue ID |

**Total: 35 items**

---

## Import Steps

1. Jira → Settings → System → **External System Import** → CSV
2. Select: `jira_import_legacy_final_utf8.csv`
3. On "Map Fields" page, match each CSV column to Jira field
4. Check "Map Field Values" for: **Issue Type**, **Priority**, **Status**
5. Do NOT check "Map Field Values" for: Issue ID, Summary, Description, Parent, Labels, Original Estimate, Start Date, Due Date
6. Verify preview shows 35 items with 3-level hierarchy
7. Begin Import