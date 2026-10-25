# Corrections and clarified contracts

- Substring search now checks the final feasible position and returns -1 when absent; an empty needle returns 0.
- Second-smallest/largest mean second DISTINCT value, not second occurrence; insufficient distinct values throw an exception.
- Missing number uses values 1..n with n-1 elements. The upload's n=5 with [1,2,3,4,6] contradicts that contract; the example is corrected to n=6.
- Interval merging sorts a copy and compares against the last merged interval, handling unsorted and nested intervals.
- The incorrect `isbal` mismatch check is superseded by `isBalanced`.
- Compression and maximum-frequency lookup handle empty strings. All maximum-frequency ties are returned deterministically.
- Subset generation no longer stores results in static mutable state.
- The environment assignment example is ambiguous: four distinct assignments cannot use only three IDs. The documented solution assumes no reuse and uses backtracking rather than the original greedy algorithm. This assumption requires confirmation.
- Weekly schedules enforce the daily limit for fixed digits as well as unknown days. Fixed 8-hour days with a 4-hour cap have no solutions; the worked example uses a cap of 8.
- Rotation, intersection, sorting checks, subset filtering, and schedule generation accept arguments and return results instead of using hard-coded data and console output.
- Reverse-word solutions normalize whitespace and avoid leading spaces. Both word order and characters are reversed in the second variant.
- First non-repeating character returns nullable Character rather than using an underscore sentinel that could be a legitimate answer.
- Sums, complements, container area, and trapped water use long where needed to avoid integer overflow. Consecutive sequences guard integer endpoints.
- Maximum fixed-window sum uses a running sum; equilibrium indices use one running left/right pass; longest consecutive sequence uses a hash set without sorting the input.
- Brute-force variants remain where useful; their documented complexity is not presented as optimal.
- Every implemented source method is mapped in SOURCE_MAP.md, including aliases. Topic suggestions without solutions are retained in BACKLOG.md.
