# 10. Most Frequent Characters

- **Pattern:** hashing
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `CountMaxOcuuringCharater` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Ignore ASCII letter case and return ALL characters tied for maximum frequency, together with that frequency. Empty input returns an empty map.

## Example

```text
"aAabb" → {a=3}
```

## Answer and approach

Count normalized characters, find the maximum, then collect ties in character order.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static Map<Character, Integer> CountMaxOcuuringCharater(String s) {
        Map<Character, Integer> counts = new TreeMap<>();
        for (char ch : s.toLowerCase(Locale.ROOT).toCharArray()) counts.merge(ch, 1, Integer::sum);
        Map<Character, Integer> result = new LinkedHashMap<>();
        int maximum = counts.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        counts.forEach((ch, count) -> { if (count == maximum) result.put(ch, count); });
        return result;
    }
```

## Complexity

- **Time:** O(n log u).
- **Space:** O(u).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty input; ties; mixed case.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
