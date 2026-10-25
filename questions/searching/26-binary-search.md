# 26. Binary Search

- **Pattern:** searching
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `binarySearch` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given an ascending sorted integer array, return an index containing target or -1. Any matching index is acceptable for duplicates.

## Example

```text
[1,2,4,5,7,8,9], target=8 → 5
```

## Answer and approach

Compare the middle value and discard half the remaining search range.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
```

## Complexity

- **Time:** O(log n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty array; first/last element; absent value.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
