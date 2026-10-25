# SDET Interview Questions

A Java practice collection reconstructed from my supplied interview-preparation solutions. Each question includes a title, problem statement, example, answer, Java implementation, complexity, and SDET edge cases.

## About the questions

These questions were reported by the contributor as having appeared in company interviews. Company names and rounds are included only where the source notes identify them; they are personal reports, not independently verified company question banks. Problem statements were reconstructed from code rather than copied from official interview prompts. Ambiguous contracts are labeled explicitly.

The original upload is preserved in [reference/original-solutions.java.txt](reference/original-solutions.java.txt). It is reference material, not a compilable source file. [SOURCE_MAP.md](reference/SOURCE_MAP.md) maps original methods and variants to the organized questions. [CORRECTIONS.md](reference/CORRECTIONS.md) explains changed behavior. Suggested topics with no supplied implementation are listed separately in [BACKLOG.md](BACKLOG.md).

## Run the Java solutions and checks

Requires JDK 17 or newer; no external Java libraries are needed.

```bash
mkdir -p out
javac --release 17 -d out src/InterviewSolutions.java tests/InterviewSolutionsTest.java
java -cp out InterviewSolutionsTest
```

The tests use explicit checks that throw AssertionError; JVM `-ea` is not required. Build outputs are ignored. GitHub Actions runs the same checks on pushes and pull requests.

## Question index

| # | Question | Pattern |
|---|---|---|
| 01 | [Reverse a String](questions/strings/01-reverse-a-string.md) | strings |
| 02 | [Reverse Word Order](questions/strings/02-reverse-word-order.md) | strings |
| 03 | [Reverse Word Order and Each Word](questions/strings/03-reverse-word-order-and-each-word.md) | strings |
| 04 | [Check a Palindrome](questions/strings/04-check-a-palindrome.md) | strings |
| 05 | [Minimum Array Element](questions/arrays/05-minimum-array-element.md) | arrays |
| 06 | [Second Smallest Distinct Element](questions/arrays/06-second-smallest-distinct-element.md) | arrays |
| 07 | [Second Largest Distinct Element](questions/arrays/07-second-largest-distinct-element.md) | arrays |
| 08 | [Remove Duplicate Characters](questions/strings/08-remove-duplicate-characters.md) | strings |
| 09 | [Character Frequency Count](questions/hashing/09-character-frequency-count.md) | hashing |
| 10 | [Most Frequent Characters](questions/hashing/10-most-frequent-characters.md) | hashing |
| 11 | [Two Sum Indices](questions/hashing/11-two-sum-indices.md) | hashing |
| 12 | [All Pair Values With Target Sum](questions/arrays/12-all-pair-values-with-target-sum.md) | arrays |
| 13 | [First Non-Repeating Character](questions/hashing/13-first-non-repeating-character.md) | hashing |
| 14 | [Run-Length String Compression](questions/strings/14-run-length-string-compression.md) | strings |
| 15 | [Left Rotate an Array](questions/arrays/15-left-rotate-an-array.md) | arrays |
| 16 | [Right Rotate an Array](questions/arrays/16-right-rotate-an-array.md) | arrays |
| 17 | [Balanced Brackets](questions/stacks/17-balanced-brackets.md) | stacks |
| 18 | [Check Anagrams](questions/strings/18-check-anagrams.md) | strings |
| 19 | [Group Anagrams](questions/hashing/19-group-anagrams.md) | hashing |
| 20 | [Longest Common Prefix](questions/strings/20-longest-common-prefix.md) | strings |
| 21 | [Missing Number From 1 to N](questions/arrays/21-missing-number-from-1-to-n.md) | arrays |
| 22 | [Longest Substring Without Repeating Characters](questions/sliding-window/22-longest-substring-without-repeating-characters.md) | sliding-window |
| 23 | [Longest Palindromic Substring](questions/strings/23-longest-palindromic-substring.md) | strings |
| 24 | [First Index of a Substring](questions/strings/24-first-index-of-a-substring.md) | strings |
| 25 | [Check String Rotation](questions/strings/25-check-string-rotation.md) | strings |
| 26 | [Binary Search](questions/searching/26-binary-search.md) | searching |
| 27 | [Longest Repeating Character Replacement](questions/sliding-window/27-longest-repeating-character-replacement.md) | sliding-window |
| 28 | [Next Greater Element to the Right](questions/stacks/28-next-greater-element-to-the-right.md) | stacks |
| 29 | [Remove Adjacent Duplicate Pairs](questions/stacks/29-remove-adjacent-duplicate-pairs.md) | stacks |
| 30 | [Maximum Sum of a Size-K Window](questions/sliding-window/30-maximum-sum-of-a-size-k-window.md) | sliding-window |
| 31 | [Longest Subarray With Sum at Most K](questions/arrays/31-longest-subarray-with-sum-at-most-k.md) | arrays |
| 32 | [Merge Overlapping Intervals](questions/arrays/32-merge-overlapping-intervals.md) | arrays |
| 33 | [Two Sum in a Sorted Array](questions/two-pointers/33-two-sum-in-a-sorted-array.md) | two-pointers |
| 34 | [Remove Duplicates From a Sorted Array](questions/two-pointers/34-remove-duplicates-from-a-sorted-array.md) | two-pointers |
| 35 | [Container With Most Water](questions/two-pointers/35-container-with-most-water.md) | two-pointers |
| 36 | [Three Sum](questions/two-pointers/36-three-sum.md) | two-pointers |
| 37 | [Move Zeroes to the End](questions/two-pointers/37-move-zeroes-to-the-end.md) | two-pointers |
| 38 | [Check Nondecreasing Array Order](questions/arrays/38-check-nondecreasing-array-order.md) | arrays |
| 39 | [Check a Subsequence](questions/two-pointers/39-check-a-subsequence.md) | two-pointers |
| 40 | [Intersection of Two Arrays](questions/hashing/40-intersection-of-two-arrays.md) | hashing |
| 41 | [Common Values in Three Sorted Arrays](questions/two-pointers/41-common-values-in-three-sorted-arrays.md) | two-pointers |
| 42 | [Longest Consecutive Sequence](questions/hashing/42-longest-consecutive-sequence.md) | hashing |
| 43 | [Trapping Rain Water](questions/two-pointers/43-trapping-rain-water.md) | two-pointers |
| 44 | [Maximum Subarray Sum](questions/arrays/44-maximum-subarray-sum.md) | arrays |
| 45 | [Merge Strings With Maximum Overlap](questions/strings/45-merge-strings-with-maximum-overlap.md) | strings |
| 46 | [Largest Concatenated Number](questions/sorting/46-largest-concatenated-number.md) | sorting |
| 47 | [Generate All Subsets](questions/backtracking/47-generate-all-subsets.md) | backtracking |
| 48 | [Subsets With a Target Sum](questions/backtracking/48-subsets-with-a-target-sum.md) | backtracking |
| 49 | [Count Equilibrium Indices](questions/prefix-sums/49-count-equilibrium-indices.md) | prefix-sums |
| 50 | [Assign Distinct Allowed Environments](questions/backtracking/50-assign-distinct-allowed-environments.md) | backtracking |
| 51 | [Generate Weekly Work Schedules](questions/backtracking/51-generate-weekly-work-schedules.md) | backtracking |

## Study approach

Read the problem before the answer. Clarify the input contract, solve a normal example, identify boundary cases, and explain the complexity. Then compare against the implementation and run the checks. For an SDET interview, explain which faulty implementations each test would catch.

## Scope and conventions

- Alternative implementations of the same problem share a page; they are not counted as separate interview questions.
- Character-based exercises assume ASCII. Unicode code points and grapheme clusters are separate follow-up requirements.
- Unless stated otherwise, inputs must be non-null and satisfy the documented preconditions.
- Methods retaining the upload's spelling are mapped in the source reference for traceability.
- No company endorsement or guarantee that a question will recur is implied.
