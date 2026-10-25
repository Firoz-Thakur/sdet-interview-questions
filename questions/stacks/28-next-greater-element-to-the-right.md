# 28. Next Greater Element to the Right

- **Pattern:** stacks
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `nextGreaterElement, nextGreaterElementBruteForce` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

For each array position, return the first STRICTLY greater value to its right, or -1 if none exists.

## Example

```text
[2,1,2,4,3] → [4,2,4,-1,-1]
```

## Answer and approach

Scan right-to-left with a decreasing stack; pop values no greater than the current one. Also retain the brute-force scan for comparison.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(arr[i]);
        }
        return result;
    }
    public static int[] nextGreaterElementBruteForce(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    arr[i] = nums[j];
                    break;
                }
            }
        }
        return arr;
    }
```

## Complexity

- **Time:** O(n) stack; O(n²) brute force.
- **Space:** O(n).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Equal neighbors; descending values; empty input; negative values.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
