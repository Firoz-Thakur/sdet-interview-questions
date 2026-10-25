# 34. Remove Duplicates From a Sorted Array

- **Pattern:** two-pointers
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `removeDuplicates` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Modify a sorted array so the first returned-length positions contain its distinct values in order. Values beyond that prefix are unspecified.

## Example

```text
[1,1,2,2,3] → length 3, prefix [1,2,3]
```

## Answer and approach

A slow pointer marks the last unique value; advance it only when a new value appears.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty input; all equal; no duplicates.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
