# 46. Largest Concatenated Number

- **Pattern:** sorting
- **Interview provenance:** Not specified for this question in the supplied notes.
- **Original method(s):** `largestNumber` (see [source map](../../reference/SOURCE_MAP.md) for aliases).

## Problem

Arrange nonnegative integers so their concatenation is lexicographically/numerically largest. Collapse an all-zero result to "0"; empty input returns "".

## Example

```text
[3,30,34,5,9] → "9534330"
```

## Answer and approach

Sort strings by comparing b+a with a+b; lexical order alone is insufficient.

## Java solution

Use the following methods inside `InterviewSolutions`, with `import java.util.*;`. The complete compilable class is [here](../../src/InterviewSolutions.java).

```java
    public static String largestNumber(int[] nums) {
        if (nums.length == 0) return "";
        for (int value : nums) if (value < 0) throw new IllegalArgumentException("Nonnegative values only");
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        if (arr[0].equals("0")) return "0";
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            result.append(s);
        }
        return result.toString();
    }
```

## Complexity

- **Time:** O(n log n × d).
- **Space:** O(n × d).
- n/m/p denote input lengths, u distinct characters, W word count, L maximum word length, p/t/r output counts as applicable, d maximum digit length or daily limit, q unknown days, b maximum choices per task, and t task count.

## SDET edge cases to discuss

All zero; shared prefixes; one number; negative input throws.

Inputs are non-null unless a method explicitly documents otherwise. Sorted-array, distinct-value, ASCII, interval-shape, and nonnegative-height preconditions are not exhaustively validated by every method.
