# Jira CSV Import Compatibility Report

> Generated: 2026-06-16
> Project: OnlineBookstore_Experiment5

---

## 1. Original CSV Diagnosis

**File**: `jira\jira_import.csv` (6,710 bytes, 35 rows)

### Why the original CSV may fail to map correctly:

| Problem | Detail |
|---------|--------|
| **Text encoding corrupted** | Chinese Summary/Description fields are unreadable (`????` characters). The file has UTF-8 BOM but content was written in GBK, causing irreversible data loss for Chinese text. |
| **No numeric Issue ID** | Uses text keys like `EPIC-REQ`, `STORY-BOOK-01`. Jira CSV importer works best with numeric or key-based IDs. |
| **Epic Link instead of Parent** | Stories use `Epic Link` to reference Epics, but Jira's hierarchy system uses `Parent`/`Parent ID`. Tasks use `Parent` correctly. |
| **Non-standard status values** | Original uses mix of "Done", "In Progress" — Jira expects "To Do", "In Progress", "Done" or custom workflow statuses. |
| **17-column header** | Includes non-standard fields like `Assignee Role`, `Acceptance Criteria` which have no direct Jira mapping. |

### Original data structure (validated):
- 5 Epics, 10 Stories, 20 Tasks = **35 total**
- All parent/Epic Link references are valid (no orphans)
- No duplicate Issue Keys
- No cyclic parent relationships
- All Issue Keys use consistent `PREFIX-DOMAIN-NN` format

---

## 2. What the New CSVs Changed

| Change | Original | New |
|--------|----------|-----|
| Issue identification | `Issue Key` (text) | `Issue ID` (numeric 1001-1035) |
| Hierarchy linking | `Epic Link` + `Parent` (dual) | `Parent ID` only (unified) |
| Epic Link column | Present | **Removed** — unified into Parent ID |
| Type names | Epic, Story, Task | Version A: Feature, Story, Task / Version B: Epic, Story, Sub-task |
| Status values | Mixed Chinese/English | Standardized: To Do, Doing, Done |
| Priority values | Mixed | Standardized: Highest, High, Medium, Low |
| Chinese text | Corrupted (unreadable) | Replaced with English descriptive summaries based on Issue Key domain |
| Task summaries (Ver B) | Plain | Prefixed with `[Task]` to preserve task-layer identity |
| Encoding | UTF-8 BOM + GBK content (broken) | UTF-8 BOM, clean |

---

## 3. Recommended Import File

### PRIMARY: Version A — Feature / Story / Task

**Absolute path:**
```
C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\jira_import_jira_cloud_feature_story_task.csv
```

**Why this one first:**
- Your Jira space already has **Feature, Story, Task** types configured
- Direct type mapping: Epic→Feature, Story→Story, Task→Task
- No type compatibility risk

### FALLBACK: Version B — Epic / Story / Sub-task

**Absolute path:**
```
C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\jira_import_jira_cloud_epic_story_subtask.csv
```

**When to use:**
- If Version A import fails because "Feature" is not recognized
- If you want standard Jira Epic/Story/Sub-task hierarchy
- **WARNING**: Your space may NOT support Epic or Sub-task types. If import fails with type errors, this file cannot be used without changing space configuration.

---

## 4. Type Distribution & Hierarchy

### Version A (Feature/Story/Task)

| Level | Type | Count | Parent ID |
|-------|------|-------|-----------|
| 1 | Feature | 5 | (empty) |
| 2 | Story | 10 | Links to Feature via Issue ID |
| 3 | Task | 20 | Links to Story via Issue ID |

### Version B (Epic/Story/Sub-task)

| Level | Type | Count | Parent ID |
|-------|------|-------|-----------|
| 1 | Epic | 5 | (empty) |
| 2 | Story | 10 | Links to Epic via Issue ID |
| 3 | Sub-task | 20 | Links to Story via Issue ID |

### Per-Feature Breakdown (Version A):

| Feature (ID) | Stories | Tasks |
|-------------|---------|-------|
| 1001 - Requirements Analysis | 2 | 4 |
| 1002 - Book Management | 2 | 4 |
| 1003 - Shopping Cart | 2 | 4 |
| 1004 - Order Management | 2 | 4 |
| 1005 - Testing & Quality | 2 | 4 |

---

## 5. Validation Results

| Check | Result |
|-------|--------|
| All rows have unique Issue ID | ✅ 1001-1035, no duplicates |
| All Parent ID references valid | ✅ No orphans |
| No cyclic parent relationships | ✅ |
| Column count consistent | ✅ 16 columns in every row |
| Type counts match original | ✅ 5+10+20 = 35 |
| No empty Issue IDs | ✅ |
| No empty Issue Types | ✅ |
| UTF-8 encoding with BOM | ✅ |

---

## 6. User Action Plan

1. **Stay on** your current Jira page: *External System Import → CSV → Map Fields*
2. **Click Back** to the file selection step
3. **Upload** this file:
   ```
   C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\jira_import_jira_cloud_feature_story_task.csv
   ```
4. On the Map Fields screen, follow the mapping table in:
   ```
   C:\Users\90961\Documents\Codex\2026-06-16\files-mentioned-by-the-user-c\OnlineBookstore_Experiment5\jira\JIRA_CURRENT_IMPORT_MAPPING_GUIDE.md
   ```
5. If Issue ID or Parent ID fields are not visible in the dropdown, search using the candidate names listed in the mapping guide
6. Begin import and verify the preview shows 35 items with correct hierarchy