# 50. Assign Distinct Allowed Environments

- **Pattern:** backtracking
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `envChecker` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Reconstructed assumption: choose one allowed environment ID for each task, with no ID reused. Return one assignment, or an empty list when none exists. The original example has four tasks but only IDs 1,2,3, so a distinct assignment is impossible.

**Reconstruction note:** The assignment contract above is an explicit assumption, not a recovered company problem statement. If reuse is allowed, this is a different problem.

## Example

```text
[[1,2],[1,2],[2,3]] → [1,2,3]
```

## Answer and approach

Backtrack over allowed IDs while keeping a used set. The original greedy output repeated an ID; the intended reuse rule is unknown and needs confirmation.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<Integer> envChecker(List<List<Integer>> allowed) {
        List<Integer> result = new ArrayList<>();
        if (!assignEnvironments(allowed, 0, new HashSet<>(), result)) return Collections.emptyList();
        return result;
    }
    private static boolean assignEnvironments(List<List<Integer>> allowed, int index, Set<Integer> used, List<Integer> result) {
        if (index == allowed.size()) return true;
        for (int value : allowed.get(index)) {
            if (!used.add(value)) continue;
            result.add(value);
            if (assignEnvironments(allowed, index + 1, used, result)) return true;
            result.remove(result.size() - 1);
            used.remove(value);
        }
        return false;
    }
```

## Complexity

- **Time:** O(b^t × t) conservative bound.
- **Space:** O(t).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Impossible assignment; empty allowed list; greedy choices requiring backtracking.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
