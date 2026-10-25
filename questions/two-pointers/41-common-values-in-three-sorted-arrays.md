# 41. Common Values in Three Sorted Arrays

- **Pattern:** two-pointers
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `findCommonIn3Array` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return distinct values present in all three ascending sorted arrays, in ascending order.

## Example

```text
[1,2,3], [2,3,4], [0,2,3] → [2,3]
```

## Answer and approach

Advance all pointers on a match; otherwise advance pointers holding the current minimum.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<Integer> findCommonIn3Array(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;
        List<Integer> result = new ArrayList<>();
        while (i < a.length && j < b.length && k < c.length) {
            if (a[i] == b[j] && b[j] == c[k]) {
                if (result.isEmpty() || result.get(result.size() - 1) != a[i]) result.add(a[i]);
                i++; j++; k++;
            } else {
                int smallest = Math.min(a[i], Math.min(b[j], c[k]));
                if (a[i] == smallest) i++;
                if (b[j] == smallest) j++;
                if (c[k] == smallest) k++;
            }
        }
        return result;
    }
```

## Complexity

- **Time:** O(n+m+p).
- **Space:** O(r) output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Repeated values; no intersection; an empty array.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
