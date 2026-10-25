# 19. Group Anagrams

- **Pattern:** hashing
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `groupAnagrams` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Group words that are anagrams. Preserve encounter order within each group; the order of groups is unspecified.

## Example

```text
["eat","tea","tan","ate","nat","bat"] → [["eat","tea","ate"],["tan","nat"],["bat"]] (group order may differ)
```

## Answer and approach

Use a sorted copy of each word as a hash-map key.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);

        }
        return new ArrayList<>(map.values());
    }
```

## Complexity

- **Time:** O(W × L log L) upper bound.
- **Space:** O(W × L).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty collection; empty words; duplicate words.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
