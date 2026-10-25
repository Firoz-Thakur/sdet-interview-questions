# 22. Longest Substring Without Repeating Characters

- **Pattern:** sliding-window
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `lengthOfLongestSubstring, longestSubstring` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return the maximum length of a contiguous substring containing distinct characters. The companion method returns one such substring, choosing the first longest.

## Example

```text
"abcabcbb" → length 3, substring "abc"
```

## Answer and approach

Maintain a window of unique characters; move its left boundary until the new character is no longer duplicated.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static String longestSubstring(String s) {
        if (s == null || s.length() == 0) return "";
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0, startIndex = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
```

## Complexity

- **Time:** O(n) expected.
- **Space:** O(u).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty string; all equal; overlapping repeats.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
