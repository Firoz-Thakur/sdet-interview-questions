# 20. Longest Common Prefix

- **Pattern:** strings
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `longestCommonPrefix` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the longest prefix shared by every input string; return an empty string when no prefix exists or the array is empty.

## Example

```text
["geeksforgeeks","geeks","geek","geezer"] → "gee"
```

## Answer and approach

Start with the first word and shorten the candidate until each next word begins with it.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
```

## Complexity

- **Time:** O(W × L²) conservative bound for repeated startsWith and substring copies.
- **Space:** O(L) live auxiliary space.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty array; empty word; no shared first letter.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
