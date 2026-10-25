# 51. Generate Weekly Work Schedules

- **Pattern:** backtracking
- **Interview provenance:** The notes say "fivertrn"; company spelling/identity requires confirmation
- **Original method(s):** `findSchedules, backtrack` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given a seven-character pattern of digits and ?, replace each ? with a digit 0..dayHours so the total equals workHours. Fixed days must also respect dayHours; return all schedules in lexicographic order.

## Example

```text
pattern="08??840", workHours=24, dayHours=8 → ["0804840","0813840","0822840","0831840","0840840"]
```

## Answer and approach

Subtract fixed hours, then backtrack over unknown digits in increasing order. The upload used dayHours=4 with fixed 8s; that strict version has no valid schedules.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<String> findSchedules(String pattern, int workHours, int dayHours) {
        if (pattern.length() != 7 || dayHours < 0 || dayHours > 9 || workHours < 0)
            throw new IllegalArgumentException("Need seven days, nonnegative total, and daily limit 0..9");
        int known = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == '?') continue;
            if (ch < '0' || ch > '9') throw new IllegalArgumentException("Use digits or ?");
            if (ch - '0' > dayHours) return Collections.emptyList();
            known += ch - '0';
        }
        List<String> result = new ArrayList<>();
        backtrack(pattern.toCharArray(), 0, workHours - known, dayHours, result);
        return result;
    }
    public static void backtrack(char[] schedule, int index, int remainingHours, int dayHours, List<String> results) {
        if (index == schedule.length) {
            if (remainingHours == 0) {
                results.add(new String(schedule));
            }
            return;
        }
        if (remainingHours < 0) {
            return;
        }
        if (schedule[index] != '?') {
            backtrack(schedule, index + 1, remainingHours, dayHours, results);
            return;
        }
        for (int hours = 0; hours <= dayHours; hours++) {
            if (hours <= remainingHours) {
                schedule[index] = (char) (hours + '0');
                backtrack(schedule, index + 1, remainingHours - hours, dayHours, results);
                schedule[index] = '?';
            }
        }
    }
```

## Complexity

- **Time:** O(7 × (d+1)^q).
- **Space:** O(7) recursion plus output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Impossible total; no unknowns; fixed day exceeds limit; daily limit 0..9.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
