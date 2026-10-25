# 48. Subsets With a Target Sum

- **Pattern:** backtracking
- **Interview provenance:** Apple, first round — user-reported in the supplied notes
- **Original method(s):** `maxsubsetsofsum` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given distinct integers and a target, return all subsets whose values sum to target. Every input position can be used at most once; negative values are allowed.

## Example

```text
[2,3,5,6,8], target=10 → [[2,3,5],[2,8]] (order may differ)
```

## Answer and approach

Generate subsets, then sum and filter them. Do not prune on positive-only assumptions if negatives are allowed.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<List<Integer>> maxsubsetsofsum(int[] nums, long target) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> subset : getSubsets(nums)) {
            long sum = 0;
            for (int value : subset) sum += value;
            if (sum == target) result.add(subset);
        }
        return result;
    }
```

## Complexity

- **Time:** O(n × 2^n).
- **Space:** O(n × 2^n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Target zero includes empty subset; negatives; no solution.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
