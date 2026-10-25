# 32. Merge Overlapping Intervals

- **Pattern:** arrays
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `mergeIntervalss` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given closed intervals [start,end] with start≤end, merge all overlaps, including touching endpoints. Return ascending disjoint intervals without mutating input.

## Example

```text
[[8,10],[1,3],[2,6],[9,12]] → [[1,6],[8,12]]
```

## Answer and approach

Sort a copy by start, then compare each interval with the last merged result.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int[][] mergeIntervalss(int[][] intervals) {
        int[][] sorted = Arrays.stream(intervals).map(int[]::clone).toArray(int[][]::new);
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] current : sorted) {
            if (merged.isEmpty() || current[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(current.clone());
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }
        return merged.toArray(int[][]::new);
    }
```

## Complexity

- **Time:** O(n log n).
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Unsorted input; nested intervals; touching endpoints; empty input.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
