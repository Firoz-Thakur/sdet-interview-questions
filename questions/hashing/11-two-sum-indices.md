# 11. Two Sum Indices

- **Pattern:** hashing
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `twoSums` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return zero-based indices of two different elements adding to target, or an empty array when none exist. Any valid pair is acceptable.

## Example

```text
[1,2,3,5], target=4 → [0,2]
```

## Answer and approach

Before storing the current value, look for its complement among earlier values. Use long arithmetic to prevent overflow.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int[] twoSums(int[] nums, int target) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long diff = (long) target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put((long) nums[i], i);
        }
        return new int[]{};
    }
```

## Complexity

- **Time:** O(n) expected.
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Duplicates; no pair; integer overflow; negative values.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
