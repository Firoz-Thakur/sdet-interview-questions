# 43. Trapping Rain Water

- **Pattern:** two-pointers
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `trap` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given nonnegative unit-width bar heights, return the total water trapped between bars after rain.

## Example

```text
[0,1,0,2,1,0,1,3,2,1,2,1] → 6
```

## Answer and approach

Track maximum heights from both sides and process the side with the smaller current height.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static long trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        long water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Monotonic heights; fewer than three bars; large total uses long.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
