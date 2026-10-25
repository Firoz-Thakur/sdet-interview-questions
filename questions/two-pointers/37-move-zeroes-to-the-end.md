# 37. Move Zeroes to the End

- **Pattern:** two-pointers
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `moveZeroes` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Move zero values to the end IN PLACE while preserving the relative order of nonzero values.

## Example

```text
[0,1,0,3,12] → [1,3,12,0,0]
```

## Answer and approach

Swap each nonzero element into the next available front position.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }

    }
```

## Complexity

- **Time:** O(n).
- **Space:** O(1).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

All zeros; no zeros; empty array.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
