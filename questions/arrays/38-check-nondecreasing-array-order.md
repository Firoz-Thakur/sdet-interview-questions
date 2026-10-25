# 38. Check Nondecreasing Array Order

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `isSorted` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return whether every element is at least its predecessor. Equal adjacent values are allowed.

## Example

```text
[1,1,3] → true; [1,3,2] → false
```

## Answer and approach

Stop at the first descending pair.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) if (arr[i - 1] > arr[i]) return false;
        return true;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty array; one element; duplicates.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
