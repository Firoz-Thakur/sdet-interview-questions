# 40. Intersection of Two Arrays

- **Pattern:** hashing
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `intersection` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return each common value once, in its first encounter order in the second array.

## Example

```text
[1,2,2,3,4], [2,4,2] → [2,4]
```

## Answer and approach

Store the first array in a set, then remove a value when emitting it from the second.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<Integer> intersection(int[] a, int[] b) {
        Set<Integer> remaining = new HashSet<>();
        for (int value : a) remaining.add(value);
        List<Integer> result = new ArrayList<>();
        for (int value : b) if (remaining.remove(value)) result.add(value);
        return result;
    }
```

## Complexity

- **Time:** O(n+m) expected.
- **Space:** O(n) plus output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Duplicates; disjoint arrays; empty input.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
