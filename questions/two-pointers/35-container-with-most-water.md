# 35. Container With Most Water

- **Pattern:** two-pointers
- **Interview provenance:** The notes say "dp 3rd round"; company identity is not specified
- **Original method(s):** `maxArea` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Given nonnegative heights of vertical lines at unit-spaced indices, return the maximum water-container area from any pair. Fewer than two lines returns 0.

## Example

```text
[1,8,6,2,5,4,8,3,7] → 49
```

## Answer and approach

Measure the endpoint area, then discard the shorter side because keeping it while narrowing cannot improve the area.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static long maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        long maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            long area = (long) h * width;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

Zero heights; two lines; large products use long.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
