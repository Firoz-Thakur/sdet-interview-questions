# 27. Longest Repeating Character Replacement

- **Pattern:** sliding-window
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `characterReplacementBrute` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given uppercase A-Z and k≥0, return the longest contiguous substring that can become one repeated letter by changing at most k characters.

## Example

```text
"AABABBA", k=1 → 4
```

## Answer and approach

For every start, extend the substring and track its highest character frequency. A window is feasible when length minus that frequency is at most k.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int characterReplacementBrute(String s, int k) {
        if (k < 0 || !s.matches("[A-Z]*")) throw new IllegalArgumentException("Need uppercase A-Z and nonnegative k");
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                count[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, count[s.charAt(j) - 'A']);
                int window = j - i + 1;
                if (window - maxFreq <= k) {
                    maxLen = Math.max(maxLen, window);
                }
            }
        }
        return maxLen;
    }
```

## Complexity

- **Time:** O(n²).
- **Space:** O(26).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty input; k=0; k≥length; invalid alphabet throws.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
