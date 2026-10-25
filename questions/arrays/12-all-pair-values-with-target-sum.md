# 12. All Pair Values With Target Sum

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `sumof` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

For every index pair i < j whose values sum to target, append those two VALUES to a flat list in nested-loop order. Duplicate value pairs from different indices remain.

## Example

```text
[1,2,3,5], target=4 → [1,3]
```

## Answer and approach

Try every unordered index pair. This differs from returning a single pair of indices.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<Integer> sumof(int[] a, int s) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((long) a[i] + a[j] == s) {
                    result.add(a[i]);
                    result.add((a[j]));
                }
            }
        }
        return result;
    }
```

## Complexity

- **Time:** O(n²).
- **Space:** O(p) output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Repeated values; several matching pairs; no matches.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
