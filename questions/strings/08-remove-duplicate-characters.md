# 08. Remove Duplicate Characters

- **Pattern:** strings
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `duplicateRemover` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Keep only the first occurrence of each character, preserving its original order.

## Example

```text
"banana" → "ban"
```

## Answer and approach

A LinkedHashSet provides uniqueness and insertion order.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String duplicateRemover(String a) {
        Set<Character> ab = new LinkedHashSet<>();
        for (int i = 0; i < a.length(); i++) {
            ab.add(a.charAt(i));
        }
        StringBuilder s = new StringBuilder();
        for (char c : ab) {
            s.append(c);
        }
        return s.toString();
    }
```

## Complexity

- **Time:** O(n) expected.
- **Space:** O(u).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty string; spaces; all characters identical.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
