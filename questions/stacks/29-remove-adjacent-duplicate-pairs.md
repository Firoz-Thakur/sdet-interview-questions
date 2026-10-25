# 29. Remove Adjacent Duplicate Pairs

- **Pattern:** stacks
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `removeAdjDuplicates` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Repeatedly remove adjacent equal character pairs until no pair remains; return the resulting string.

## Example

```text
"abbaca" → "ca"
```

## Answer and approach

An equal character cancels the stack top; otherwise push it. Cancellation naturally exposes earlier pairs.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String removeAdjDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty string; chain reactions; odd-sized runs.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
