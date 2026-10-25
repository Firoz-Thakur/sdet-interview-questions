# 36. Three Sum

- **Pattern:** two-pointers
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `threeSum` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Return unique value triplets adding to zero, with three different indices per triplet. Each triplet is sorted; input may be reordered.

## Example

```text
[-1,0,1,2,-1,-4] → [[-1,-1,2],[-1,0,1]]
```

## Answer and approach

Sort, fix one value, then use two pointers. Skip repeated fixed and endpoint values.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
```

## Complexity

- **Time:** O(n²).
- **Space:** O(n) sorting stack upper bound, plus O(t) output.
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

All zero; no triplet; repeated values; overflow-safe sum.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
