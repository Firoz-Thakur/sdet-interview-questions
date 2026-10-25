# 47. Generate All Subsets

- **Pattern:** backtracking
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `getSubsets` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given distinct input integers, return every subset, including the empty subset. Subset order is unspecified.

## Example

```text
[2,3] → [[],[2],[3],[2,3]] (order may differ)
```

## Answer and approach

At every index, recursively choose inclusion or exclusion, copying the current list at a leaf. Each call owns its result list.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<List<Integer>> getSubsets(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        collectSubsets(a, 0, new ArrayList<>(), result);
        return result;
    }
    private static void collectSubsets(int[] a, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == a.length) { result.add(new ArrayList<>(current)); return; }
        current.add(a[index]);
        collectSubsets(a, index + 1, current, result);
        current.remove(current.size() - 1);
        collectSubsets(a, index + 1, current, result);
    }
```

## Complexity

- **Time:** O(n × 2^n).
- **Space:** O(n) recursion plus O(n × 2^n) output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty input; repeated method calls must not leak prior results.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
