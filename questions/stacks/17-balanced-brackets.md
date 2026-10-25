# 17. Balanced Brackets

- **Pattern:** stacks
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `isBalanced` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given only bracket characters ()[]{}, return whether every opening bracket has a matching closing bracket in the correct nesting order.

## Example

```text
"[{()}]" → true; "([)]" → false
```

## Answer and approach

Push opening brackets and match each closing bracket against the latest opener.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char latestOpenedPar = st.pop();
                if (latestOpenedPar == '{' && ch != '}') {
                    return false;
                } else if (latestOpenedPar == '(' && ch != ')') {
                    return false;
                } else if (latestOpenedPar == '[' && ch != ']') {
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Empty string; unmatched opener; premature closing bracket.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
