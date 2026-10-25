# 09. Character Frequency Count

- **Pattern:** hashing
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `countLetters` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return a mapping from each character to its number of occurrences. Comparison is case-sensitive; map iteration order is unspecified.

## Example

```text
"aauuchhh" → {a=2,u=2,c=1,h=3}
```

## Answer and approach

Increment a hash-map counter for every character.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static Map<Character, Integer> countLetters(String s) {
        Map<Character, Integer> a = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (a.containsKey(s.charAt(i))) {
                a.put(s.charAt(i), a.get(s.charAt(i)) + 1);
            } else {
                a.put(s.charAt(i), 1);
            }
        }
        return a;
    }
```

## Complexity

- **Time:** O(n) expected.
- **Space:** O(u).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty string; uppercase/lowercase; spaces.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
