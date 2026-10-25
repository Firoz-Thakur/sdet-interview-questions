# 13. First Non-Repeating Character

- **Pattern:** hashing
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `firstNonRepeating, firstUniqChar` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Find the first character occurring exactly once. The character variant returns null if absent; the index variant returns -1.

## Example

```text
"geeksforgeeks" → 'f', index 5
```

## Answer and approach

The character variant counts with insertion order; the alternative index variant scans every other position.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static Character firstNonRepeating(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1)
                return e.getKey();
        }
        return null;
    }
    public static int firstUniqChar(String s) {
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            boolean found = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {

                return i;
            }
        }
        return -1;
    }
```

## Complexity

- **Time:** O(n) expected character variant; O(n²) index variant.
- **Space:** O(u) character variant; O(1) index variant.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty input; every character repeats; underscore is a valid result.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
